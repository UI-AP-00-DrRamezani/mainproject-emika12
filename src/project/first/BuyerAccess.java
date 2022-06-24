package project.first;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import allof.exceptions.*;
import graphics.user.buyer.ListForBuyer;
import graphics.user.buyer.basket;
import graphics.user.buyer.rateProduct;
import products.*;

import random.works.*;
import account.making.*;
import saleing.Sale;

import javax.swing.*;

import static project.first.ProductPart.*;
import static project.first.SellerAccess.*;
import static project.first.project.*;
import static project.first.AllExceptions.*;

public class BuyerAccess
{
    private static boolean notifying=false;
    private static final Object lock = new Object();
    private static ArrayList <showing> rateShowing;



    public static void rating (Integer rating_earmark ,int rating_num) throws  RatingOutOfStar ,wrongInputType
    {
        //finding earmark
        int found=1;
        for(BuyList buylist: useraccount.getBuyer().list) {
            for (Product eachProduct : buylist.products_List) {
                if (found == 0)
                    continue;
                if (eachProduct.getEarmark() == rating_earmark) {
                    found = 0;


                    //==================rating from 1 to 5
                    RatingStar(rating_num);

                    Rate rate = new Rate();
                    rate.setRate(rating_num);
                    rate.setBuyer(useraccount.getBuyer());
                    rate.setProduct(eachProduct);
                    eachProduct.rate.add(rate);

                    eachProduct.ratingAmount(); //making new average

                    try {
                        updateRate(eachProduct);
                    }catch (FileNotFoundException e){print("file could not be found");}
                }
            }
        }

        if(found==1)
            invalidInfo("wrong earmark !");
    }

    public static ArrayList<showing> rating_allowed_products()
    {
        rateShowing=new ArrayList<>();
        for(BuyList buylist: useraccount.getBuyer().list) {
            for (Product eachProduct : buylist.products_List) {
                showing show = new showing(eachProduct.getName() ,Integer.toString(eachProduct.getEarmark()));
                rateShowing.add(show);
            }
        }
        return rateShowing;
    }


    public static void updateRate(Product product)throws FileNotFoundException
    {
        RandomAccessFile update=new RandomAccessFile(product.getAddress()+"/info.txt" ,"rw");
        RandomAccessFile update2=new RandomAccessFile(product.getAddress2() +"/info.txt","rw");
        Path path= Paths.get(product.getAddress()+"/info.txt");

        long size=0;
        try {
            size=Files.size(path);
            update.seek(update.length()-4);
            update.writeInt(product.getStar());
            update2.seek(update.length()-4);
            update2.writeInt(product.getStar());
        }catch (IOException e){}
        finally {
            try {
                update.close();
                update2.close();
            }catch (IOException e){}
        }
    }

    public static void basket(int order ) throws outOfMoney {
        double payMoney = 0;
        for (Product product : project.useraccount.getBuyer().getBuyList().products_List)
            payMoney += product.getPrice();

        if (order == 1) {
            if (useraccount.getMoneyInStock() < payMoney)
                outOfMoney();
        }else {
            cancelBasket();
            return;
        }
    }

    public static void cancelBasket() {
        for (Product product : useraccount.getBuyer().getBuyList().products_List) {
            product.setInStock(product.getInStock() + 1);
            useraccount.getBuyer().getBuyList().products_List.removeAll(useraccount.getBuyer().getBuyList().products_List);
        }
    }

    public static double newMoney()
    {
        double money=0;
        for (Product product: useraccount.getBuyer().getBuyList().products_List)
        {
            money=+product.getPrice_with_discount();
        }
        return money;
    }

    public static void takeDiscountCodes(String check ,String code) throws DiscountCode,timeExpired,capacityFinish
    {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.now();


        String order="start";
        if (check.trim().equals("no"))
            order="end";
        Sale the_discount=null;

        if ( ! order.equals("end"))
        {

            for (Sale discountCode : Admin.sales)
            {
                if (discountCode.getCode().equals(code)) {
                    the_discount = discountCode;
                    break;
                }
            }
            if (the_discount ==null)
                wrongDiscountCode();
            else
            {
                int find=0;

                if ((the_discount.getCapacity() > 0 )
                && (the_discount.getDate().isAfter(date)))
                {
                    for (Product product: useraccount.getBuyer().getBuyList().products_List)
                    {

                        if (product == the_discount.getProduct()) {
                            find = 1;
                            if (product.getPrice_with_discount() !=-10)
                                break;

                            product.setPrice_with_discount((1 - the_discount.getDiscount()) * product.getPrice());
                            the_discount.setCapacity(the_discount.getCapacity() - 1);
                        }
                            break;

                    }
                    if (find != 1)
                        notFound("you haven't bought the product with this discount code");
                }
                else if (the_discount.getCapacity()==0) {
                    capacityFinished();
                    the_discount.getProduct().setPrice_with_discount(the_discount.getProduct().getPrice());
                }
                else {
                    timeExpired();
                    the_discount.getProduct().setPrice_with_discount(the_discount.getProduct().getPrice());
                }
            }

        }
    }

    public static void lastDiscount()
    {
        LocalDate date = LocalDate.now();
        for (Product product :useraccount.getBuyer().getBuyList().products_List)
        {
            ArrayList <Sale> sales =product.getSales();
            for (Sale sale :sales )
            {
                if (sale.getCode().equals("ALL"))
                    if (sale.getDate().isAfter(date)) {
                        if (product.getPrice_with_discount() == -10)
                            product.setPrice_with_discount(product.getPrice());

                            product.setPrice_with_discount((1 - sale.getDiscount()) *
                                    product.getPrice_with_discount());
                    }
            }
            if (product.getPrice_with_discount() == -10)
                product.setPrice_with_discount(product.getPrice());
        }

        Double payMoney = newMoney();

        makeListForBuyer(payMoney);
    }

    public static void makeListForBuyer(double payMoney)
    {
        //making th recipe for the buyer:

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);

        useraccount.setMoneyInStock(useraccount.getMoneyInStock()-payMoney);
        useraccount.getBuyer().getBuyList().setDate(time);
        useraccount.getBuyer().getBuyList().setPrice(payMoney);
        useraccount.getBuyer().getBuyList().setBuyerName(useraccount.getName());
        useraccount.getBuyer().getBuyList().setDelivery("4 to 7 days from the recipe's date");

        useraccount.getBuyer().list.add(useraccount.getBuyer().getBuyList());


        //try to find each seller in the list and making them a sell list

        makeListForSeller(payMoney,time);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListForBuyer page=new ListForBuyer();
            }
        });


        //recipe:
        locking();

        //print("----------------------------------");
        //print("thanks for choosing our site :)");

        //making a new list after printing the recipe
        useraccount.getBuyer().listMaker();

        for (Product product: useraccount.getBuyer().getBuyList().products_List)
            product.setPrice_with_discount(-10);

    }

    public static void locking()
    {
        synchronized (lock)
        {
            while (! notifying ) {
                try {
                    lock.wait();
                }catch (Exception e){}
            }
            if (notifying)
                lock.notify();

            notifying=false;
        }
    }


    public static void notifier()
    {
        synchronized (lock){
            lock.notifyAll();
        }
    }
    //================

    public static boolean isNotifying() {
        return notifying;
    }

    public static void setNotifying(boolean notifying) {
        BuyerAccess.notifying = notifying;
    }
}
