package project.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import static project.first.project.*;

import allof.exceptions.noUser;
import graphics.products.showEachProduct;
import graphics.user.admin.show;
import products.*;
import products.digital.*;
import products.outfit.*;
import products.snacks.*;
import products.house.*;

import random.works.*;
import account.making.*;

import javax.swing.*;

import static project.first.AllExceptions.*;


public class ProductPart
{
    public static Product[]  products()
    {
        ArrayList<show>list=new ArrayList<>();

        Product[]products=new Product[project.productArrayList.size()];
        int i=0;


        for (Product a:project.productArrayList)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);
        return products;
    }


    //filters---
    public static Product[]  digitalProductFilter()
    {

        Product []products=new Product[digital_Products.products.size()];
        int i=0;


        for (Product a:digital_Products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        return products;

    }

    public static Product[]  outfitFilter()
    {
        Product []products=new Product[outfit_Products.products.size()];
        int i=0;

        for (Product a:outfit_Products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        return products;
    }

    public static Product[]  houseProductsFilter()
    {

        Product []products=new Product[house_products.products.size()];
        int i=0;

        for (Product a:house_products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        return products;
    }

    public static Product[]  snackFilter()
    {
        Product []products=new Product[snack_products.products.size()];
        int i=0;

        for (Product a:snack_products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);
        return products;
    }

    public static Product[]  mostExpensiveFilter()
    {
        Product[] products1 =new Product[project.productArrayList.size()];
        int i=0;


        for (Product a:project.productArrayList)
        {
            products1[i]=a;
            ++i;
        }
        for (int s=0;s<productArrayList.size();++s)
        {
            for (int j = 0; j < productArrayList.size()-1; ++j)
            {
                if (products1[j].getPrice() < products1[j+1].getPrice())
                {
                    Product tempt=products1[j];
                    products1[j]=products1[j+1];
                    products1[j+1]=tempt;
                }

            }
        }
        return products1;
    }

    public static Product[] lessExpensiveFilter()
    {
        Product[] products1 =new Product[project.productArrayList.size()];
        int i=0;


        for (Product a:project.productArrayList)
        {
            products1[i]=a;
            ++i;
        }

        for (int s=0;s<productArrayList.size();++s)
        {
            for (int j = 0; j < productArrayList.size() - 1; ++j)
            {
                if (products1[j].getPrice() > products1[j+1].getPrice())
                {
                    Product tempt=products1[j];
                    products1[j]=products1[j+1];
                    products1[j+1]=tempt;
                }

            }
        }
        return products1;
    }
    //----


    public static void eachProduct (Product products ,String order) throws InputMismatchException, noUser {



        if (order.trim().equals("BUY")) {

            //print("in stock:" + (products.getInStock() - 1));
            if (useraccount != null) {
                if (products.getInStock() >= 0) {
                    useraccount.getBuyer().getBuyList().products_List.add(products);
                    products.setInStock(products.getInStock() - 1);
                } else
                    outOfStuck();

            } else {
                shouldLogin();

                if (products.getInStock() > 0) {
                    useraccount.getBuyer().getBuyList().products_List.add(products);
                    products.setInStock(products.getInStock() - 1);
                } else
                    outOfStuck();
            }
        } else if (order.trim().equals("ADD COMMENT")) {

            Comments comment = new Comments();

            comment.setComment(JOptionPane.showInputDialog("text: "));

            if (useraccount == null)
                comment.setBuyer_Comment("Guest");
            else
                comment.setBuyer_Comment(useraccount.getName());
            comment.setProduct(products);

            if (useraccount == null)
                comment.setHavingBought(false);
            else {
                int find = 0;
                for (BuyList buyList : useraccount.getBuyer().list)
                    for (Product product : useraccount.getBuyer().getBuyList().products_List) {
                        if (find == 1)
                            continue;

                        if (product == products) {
                            find = 1;
                            comment.setHavingBought(true);
                        }
                    }
                if (find == 0)
                    comment.setHavingBought(false);
            }
            Adminn.getAdmin().comments_Permission.add(comment);
            products.comments.add(comment);

        }

    }


    public static void showEachProduct(Product products)
    {
        String myString;

        myString=products.toString()+"\n"+"more information about it: "+"\n";
        if (products instanceof digitalProduct)
        {
            myString+=(((digitalProduct) products).toString2());

            if(products instanceof mobile)
            {
                myString+="\nSIM number: "+((mobile) products).getSIM_num();
                myString+="\ncamera quality: "+((mobile) products).getCameraQuantity();
            }
            else if (products instanceof laptop)
            {
                myString+="\nprocessor model: "+((laptop) products).getProcessor_Model();
                myString+="\nis it for gaming?"+((laptop) products).getFor_Gaming();
            }


        }
        else if (products instanceof houseProducts)
        {
            myString+="\nenergy usage:"+((houseProducts) products).getEnergy_Usage();
            myString+="\nhaving gaurentee:"+((houseProducts) products).getGarentie();

            if (products instanceof refrigator)
                myString+="\n"+((refrigator) products).toString2();

            else if(products instanceof television)
                myString+="\n"+((television) products).toString2();

        }
        else if (products instanceof outfit)
            myString+="\n"+((outfit) products).toString2();

        else if(products instanceof snacks)
            myString+="\n"+((snacks) products).toString2();

        if (products instanceof houseProducts)
        {
            myString+="\nguarantee:" +((houseProducts) products).getGuaranteeValue()+"   "
                    +((houseProducts) products).getGuaranteeTime();
        }
        if (products instanceof digitalProduct)
        {

            myString+="\nguarantee:" +((digitalProduct) products).getGuaranteeValue()+"   "
                    +((digitalProduct) products).getGuaranteeTime();
        }

        myString+="\n-------";
        myString+="\n"+products.getInfo();
        myString+="\n-------";

        myString+="\nprice: "+products.getPrice();
        myString+="\nin stock: "+products.getInStock();

        myString+="\n-------------------------------------------------------------";
        myString+="\nComments: \n-------------------------------------------------------------";

        for (Comments a:products.comments)
        {
            if(a.getState()== State.ACCEPTED)
            {
                myString+="\nuser " + a.getBuyer_Comment()+ ":"+"having bought the product: "+a.isHavingBought();
                myString+="\n"+a.getComment();
                myString+="\n-------------------------------------------------------------";
            }
        }

        myString+="\nRating: ";
        myString+="\n-------------------------------------------------------------";

        int average=0;
        for (Rate a:products.rate)
        {
            average+=a.getRate();
            myString+="\n"+a.getBuyer().getSame().getName()+":"+a.getRate();
        }

        if(products.rate.size()!=0)
            products.setStar(average/products.rate.size());
        else
            products.setStar(0);

        myString+="\naverage: "+products.getStar();

        String finalMyString = myString;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showEachProduct show=new showEachProduct(finalMyString ,products);
            }
        });
    }


}
