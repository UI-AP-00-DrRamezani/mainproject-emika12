package project.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import allof.exceptions.*;
import files.Savefiles;
import graphics.mainPage;
import graphics.user.admin.AdminMainMenu;
import graphics.user.seller.SellerMainMenu;
import products.*;
import products.digital.*;
import products.outfit.*;
import products.house.*;

import random.works.*;
import account.making.*;
import files.*;

import javax.swing.*;

import graphics.user.buyer.*;
import static project.first.ProductPart.*;
import static project.first.SellerAccess.*;
import static project.first.BuyerAccess.*;
import static project.first.AdminAccess.*;
import static project.first.AllExceptions.*;
import static project.first.checking.*;

import static graphics.mainPage.*;


public class project {

    private static boolean notifying =false;
    private static final Object lock = new Object();
    private static boolean programEnded=false;


    public static ArrayList<userAccount> users = new ArrayList<userAccount>();
    public static userAccount useraccount=null;
    public static ArrayList<Product>productArrayList=new ArrayList<Product>();
    public static userAccount Adminn=new userAccount("admin","melika","Shi","admin@yahoo.com","09132223338","admin",
            Post.ADMIN,"false");
    public static Category digital_Products =new Category("digital products","high tech features with latests versions");
    public static Category outfit_Products=new Category("outfit products","warm,cool,etc outfits for everyone");
    public static Category house_products=new Category("house products","digital,non digital and etc products");
    public static Category snack_products=new Category("snack products","delicious snacks from many different brands");

    public static void main(String[] args) throws Exception{

        try {

            try {
                readFiles.mainRead();
            } catch (ClassNotFoundException ex) {
                print("there were no files(yet");
            } catch (IOException ex) {
            } catch (NullPointerException ex) {
            }
            //==============================================files

            users.add(Adminn);

            while (!programEnded) {
                CategoryOrganize();
             try {
                 SwingUtilities.invokeLater(new Runnable() {
                     @Override
                     public void run() {
                         com.formdev.flatlaf.FlatDarkLaf.setup();
                         mainPage main_Page=new mainPage();
                         if(main_Page.isDisplayable()) {
                             notifying = true;
                             programEnded=true;
                         }
                     }
                 });
             }catch (RuntimeException e)
             {
                 JOptionPane.showInputDialog(e.getMessage());
             }


                locking();


            }
            saving();
        }catch (Exception e){print("we had a problem reading files");}
        finally {
            print("hope we see you again :)");
        }
    }


    //locking up the main

    public static void mySuspend()
    {
        synchronized (lock){
            lock.notifyAll();
        }
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
                lock.notifyAll();

            notifying=false;
        }
    }
    //-------------------------------

    public static void print(Object object) {
        System.out.println(object);

    }

    //login_sign up

    public static void login(String ID , String pass) throws wrongInputType{

            String id = ID;
            String password =pass;

            findUser(id, password);

        }


    public static void signingUp(String Name , String Family ,String Email , String PhoneNum ,String POST , String ID , String pass
                                 ,String Institute , String workSh ,String Factory)
            throws InvalidEmail,InvalidPhoneNum,wrongInputType,IOException {


        String name = Name;
        String family = Family;
        String email =Email;


        //checking for email validation
        if(invalidEmail(email))
            throw new InvalidEmail();

        String phoneNum = PhoneNum;

        //checking for phone validation
            if (invalidPhoneNum(phoneNum))
                throw new InvalidPhoneNum();

        Post post;
        try {
             post = Post.valueOf(POST);
        }
        catch (IllegalArgumentException error) {throw new IllegalArgumentException("wrong post type");}

        String id = ID;
        String password = pass;

        checkInfo(name,family,id,password);

        id=notHavingSameID(id);
        if (id ==null)
            throw new wrongInputType("wrong id input!");

        //--------------------------
        userAccount account = new userAccount(id, name, family, email, phoneNum, password, post,"false");
        users.add(account);
        useraccount = account;

        if (post == Post.BUYER)
            Savefiles.WriteBuyer(useraccount);

        if (post == Post.SELLER) {
            String factory = Factory;
            String institute = Institute;
            String workshop = workSh;

            checkInfo(factory,workshop,institute);

            useraccount.getSeller().fullfillInfo(factory, institute, workshop);
            useraccount.getSeller().setAccount_Acceptence(State.ACCEPTING);
            Adminn.getAdmin().acceptUser.add(useraccount);

        }

        userPanel();
    }



    public static String notHavingSameID(String id) throws wrongInputType
    {
        Scanner sc=new Scanner(System.in);
        int vary = 1;
        do {
            for (userAccount find : users) {
                if (!(find.getId().equals(id)))
                    vary = 1;
                else {
                    vary = 0;
                    break;
                }
            }
            if (vary == 0) {
                id = UserFinding();
                throw new duplicateID();
            }
        }while(vary==0);
        return id;
    }

    public static void findUser(String id, String password)throws wrongInputType,noUser {

        int findd=0;

        for (userAccount find : users) {
            if(findd==1)
                continue;

            if (find.getId().equals(id)  && !(find.getPassword().equals(password))) {
                wrongPassword();
                return;
            }

            else if (!(find.getId().equals(id)))
                findd=0;


            else if (find.getId().equals(id) && find.getPassword() .equals( password)) {

                useraccount = find;
               // print("access allowed");
                if (useraccount.getPost()==Post.BUYER)
                    useraccount.getBuyer().listMaker();
                findd=1;
            }

        }
        if(findd==0)
           UserNotFound();

        else if (findd==1)
            userPanel();
    }

    public static void userPanel() {
        if (useraccount.getPost() == Post.BUYER)
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    mainMenu main_menu=new mainMenu();
                }
            });
        }
        else if (useraccount.getPost() == Post.SELLER && useraccount.getSeller().getAccount_Acceptence()==State.ACCEPTED)
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SellerMainMenu main_menu=new SellerMainMenu();
                }
            });
        }
        else if (useraccount.getPost() == Post.SELLER && useraccount.getSeller().getAccount_Acceptence()==State.ACCEPTING)
            throw new AccessAllowance("your account has not been accepted yet...please try again later");
        else if(useraccount.getPost()==Post.ADMIN)
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AdminMainMenu mainMenu=new AdminMainMenu();
                }
            });
        }
    }

    //-----------------------
    public static void CategoryOrganize()
    {

        digital_Products.products.removeAll(digital_Products.products);
        outfit_Products.products.removeAll(outfit_Products.products);
        house_products.products.removeAll(house_products.products);
        snack_products.products.removeAll(snack_products.products);

        for(Product product:productArrayList)
        {
            if(product instanceof digitalProduct)
                digital_Products.products.add(product);
            else if(product instanceof outfit)
                outfit_Products.products.add(product);
            else if(product instanceof houseProducts)
                house_products.products.add(product);
            else
                snack_products.products.add(product);
        }
    }


    //each user access allowance


    public static void changeInformation(String order , String newValue) throws InputMismatchException
    {

        switch (order)
        {
            case "pass":
                String password=newValue;
                if (!checkInfo2(password))
                   useraccount.setPassword(password);
                break;

            case "name":
                String name= newValue;
                if (! checkInfo(name))
                   useraccount.setName(name);
                break;

            case "family" :
                String familyName=newValue;
                if (! checkInfo(familyName))
                   useraccount.setFamilyName(familyName);
                break;

            case "email":
                String email=newValue;
                //checking for email validation
                if ( !invalidEmail(email) )
                    useraccount.setEmail(email);
                break;

            case "money":
                Integer money=Integer.parseInt(newValue);
                useraccount.setMoneyInStock(money);
                break;

            case "phone":
                String phoneNum= newValue;
                //checking for phone validation
                if (!invalidPhoneNum(phoneNum))
                    useraccount.setPhoneNum(phoneNum);
                break;
            case "work":
                useraccount.getSeller().setWorkShopName(newValue);
                break;
            case "factory":
                useraccount.getSeller().setFactoryName(newValue);
                break;
            case "institute":
                useraccount.getSeller().setInstituteName(newValue);
                break;

        }
    }

    //saving to files
    public static void saving()
    {
        CategoryOrganize();
        try {
            Savefiles.writingUsers();
        }catch (IOException Ex){print("we had a problem for saving the data");}

        int num=6;
        System.out.printf("saving . . .");
        while (num > 0)
        {
            try {
                Thread.sleep(500);
            }catch (Exception e){}
            System.out.printf(" .");
            num--;
        }
        print("");
    }



    //getter setter

    public static boolean isNotifying() {
        return notifying;
    }

    public static void setNotifying(boolean notifying) {
        project.notifying = notifying;
    }
}








