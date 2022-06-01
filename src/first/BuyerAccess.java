package first;

import account.making.*;
import allof.exceptions.*;
import products.Product;
import random.works.*;
import saleing.Sale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static project.first.AllExceptions.*;
import static project.first.ProductPart.*;
import static project.first.SellerAccess.*;
import static project.first.project.*;

public class BuyerAccess
{
    public static void buyerAccess() {
        Scanner sc = new Scanner(System.in);

        print("your account information:");
        print(useraccount.toString());
        Integer order=9;
        while(order!=0)
        {

            print("=========================================");
            System.out.printf("changing info:1\nsee products:2\nsee your basket:3\nrate a product 4\nmoney in stock 5\nend 0");

                order = checkIntException();
                if(order==null)
                    order=10;

            switch (order) {
                case 0:
                    break;
                case 1:
                    changeInfo();
                    break;
                case 2:
                    products();
                    break;
                case 3:
                    basket();
                    break;
                case 4:
                    try {
                        rating();
                    }catch (RatingOutOfStar e){}catch (wrongInputType e){}
                    break;
                case 5:
                    print(useraccount.getMoneyInStock());
                    break;
                default:
                    wrongOrder("error: order must be between 0 to 5");
            }
        }

    }

    public static void rating () throws  RatingOutOfStar ,wrongInputType
    {
        for(BuyList buylist: useraccount.getBuyer().list) {
            for (Product eachProduct : buylist.products_List) {
                print("name: " + eachProduct.getName());
                print("earmark: " + eachProduct.getEarmark());
            }
        }

        print("for rating please enter the earmark of the product: ");
        Scanner sc=new Scanner(System.in);

        Integer earmark;
        earmark=checkIntException();

        int found=1;
        for(BuyList buylist: useraccount.getBuyer().list) {
            for (Product eachProduct : buylist.products_List) {
                if (found == 0)
                    continue;
                if (eachProduct.getEarmark() == earmark) {
                    found = 0;
                    print("rate from 1 to 5:");
                    Integer rate_number=9;
                    rate_number = checkIntException();
                    if (rate_number == null)
                        return;

                    RatingStar(rate_number);


                    Rate rate = new Rate();
                    rate.setRate(rate_number);
                    rate.setBuyer(useraccount.getBuyer());
                    rate.setProduct(eachProduct);
                    eachProduct.rate.add(rate);

                    eachProduct.ratingAmount();

                    try {
                        updateRate(eachProduct);
                    }catch (FileNotFoundException e){print("file could not be found");}
                }
            }
        }
        if(found==1)
            invalidInfo("wrong earmark !");
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

    public static void basket()
    {
        if(useraccount.getBuyer().getBuyList().products_List.size()==0)
        {
            print("the bascket is empty");
            return;
        }
        double payMoney=0;
        for(Product product: useraccount.getBuyer().getBuyList().products_List)
        {
            print("name: " + product.getName() + "   earmark: " + product.getEarmark());
            print("price: "+ product.getPrice());

            payMoney+= product.getPrice();
        }
        print("pay money: "+payMoney);

        Scanner sc=new Scanner(System.in);
        print("pay 1/back 2");
        Integer order=checkIntException();

        if (order== null)
            return;

        if(order==1) {
            if (useraccount.getMoneyInStock() >= payMoney)
                print("");

            else {
                outOfMoney();

                String adding = sc.nextLine();
                if (adding.equals("yes")) {
                    while (payMoney > useraccount.getMoneyInStock()) {
                        print("add money(it is not enough yet)");
                        Integer checking=checkIntException();
                        if (checking==null)
                            return;
                        useraccount.setMoneyInStock(checking);
                    }


                } else if (adding.equals("no")){
                    for (Product product : useraccount.getBuyer().getBuyList().products_List) {
                        product.setInStock(product.getInStock() + 1);
                        useraccount.getBuyer().getBuyList().products_List.removeAll(useraccount.getBuyer().getBuyList().products_List);
                    }
                }else
                    wrongOrder("error: either choose yes or no");
            }

            takeDiscountCodes();
            payMoney=newMoney();

            makeListForBuyer(payMoney);
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

    public static void takeDiscountCodes() throws DiscountCode,timeExpired,capacityFinish
    {
        Scanner sc=new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.now();

        print("do you have any discount code?(yes/no)");
        String check=sc.nextLine();

        String order="start";
        if (check.trim().equals("no"))
            order="end";
        Sale the_discount=null;

        while ( ! order.equals("end"))
        {
            print("please enter the code: ");
            String code=sc.nextLine();

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
                    if (find==1)
                        print("discount worked out successfully:");
                    else
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
            print("end (write down end)/ continue(press anything)");
            order=sc.nextLine();
        }
        lastDiscount(date);
    }

    public static void lastDiscount(LocalDate date)
    {
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

        //recipe:

        print("process done successfully:your recipe:");
        print("----------------------------------");
        print("Date: "+ useraccount.getBuyer().getBuyList().getDate());
        print("transmission: "+ useraccount.getBuyer().getBuyList().getDelivery());
        print("total price: "+ useraccount.getBuyer().getBuyList().getPrice());
        print("buyer: "+ useraccount.getBuyer().getBuyList().getBuyerName());
        print("products: ");
        int i=1;
        for (Product product: useraccount.getBuyer().getBuyList().products_List)
        {
            if (product.getPrice_with_discount()==-10)
                 print(i+"."+product.getName()+"    price: "+product.getPrice()
                         +"   with discount: "+product.getPrice());
            else
            {
                print(i+"."+product.getName()+"    price: "+product.getPrice()
                        +"   with discount: "+product.getPrice_with_discount());
                product.setPrice_with_discount(-10);
            }
            ++i;
        }
        print("----------------------------------");
        print("thanks for choosing our site :)");

        //making a new list after printing the recipe
        useraccount.getBuyer().listMaker();

        for (Product product: useraccount.getBuyer().getBuyList().products_List)
            product.setPrice_with_discount(-10);

    }

}
