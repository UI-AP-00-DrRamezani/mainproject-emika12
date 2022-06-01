package first;

import account.making.*;
import allof.exceptions.*;
import files.Savefiles;
import files.readFiles;
import products.Product;
import products.digital.digitalProduct;
import products.house.houseProducts;
import products.outfit.outfit;
import random.works.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static project.first.AdminAccess.*;
import static project.first.AllExceptions.*;
import static project.first.BuyerAccess.*;
import static project.first.ProductPart.*;
import static project.first.SellerAccess.*;
import static project.first.checking.*;


public class project {
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
        Scanner sc = new Scanner(System.in);
        try {

            try {
                readFiles.mainRead();
            } catch (ClassNotFoundException ex) {
                print("there were no files(yet");
            } catch (IOException ex) {
            } catch (NullPointerException ex) {
            }

            users.add(Adminn);

            Integer order = 1;
            while (order != 0) {
                CategoryOrganize();
                useraccount = null;

                print("Login/Sign up 1");
                print("Products 2");
                print("save data 3");
                print("end 0");

                order = checkIntException();
                if (order == null)
                    order = 20;
                else if (order == 20)
                    order = 19;

                if (order == 1)
                    login();
                else if (order == 2) {
                    try {
                        products();
                    } catch (noUser e) {
                    }
                } else if (order == 3) saving();

                else if (order != 20 && order != 0)
                    wrongOrder("wrong number: either enter 1 , 2 , or 0");

                digital_Products.products.removeAll(digital_Products.products);
                outfit_Products.products.removeAll(outfit_Products.products);
                house_products.products.removeAll(house_products.products);
                snack_products.products.removeAll(snack_products.products);
            }
            saving();
        }catch (Exception e){print("we had a problem reading files");}
        finally {
            print("hope we see you again :)");
        }
    }

    public static void print(Object object) {
        System.out.println(object);

    }

    //login_sign up

    public static void login() {
        Scanner sc = new Scanner(System.in);
        print("login 1  " + "sign up 0  ");
        Integer order = checkIntException();
        if (order==null)
            return;


        if (order == 0)
        {
            try {
                signingUp();
            } catch (InvalidEmail E){} catch (InvalidPhoneNum E){} catch (wrongInputType e){}catch (IOException e){}

        }
        else if(order==1){
            print("id: ");
            String id = sc.nextLine();
            print("password: ");
            String password = sc.nextLine();

           try {
               findUser(id, password);
           }catch (wrongInputType e){}catch (noUser e){}

        }
        else
           wrongOrder("wrong number: either enter 1 , 2 , or 0");


    }

    public static void signingUp() throws InvalidEmail,InvalidPhoneNum,wrongInputType,IOException {

        Scanner sc = new Scanner(System.in);
        print("please enter your name and family name ");
        String name = sc.nextLine();
        String family = sc.nextLine();
        print("please enter your email ");
        String email = sc.nextLine();


        //checking for email validation
            if (invalidEmail(email))
                return;



        print("please enter your phone num");
        String phoneNum = sc.nextLine();

        //checking for phone validation
            if (invalidPhoneNum(phoneNum))
                return;




        print("please enter your post(SELLER/BUYER)");
        Post post;
        try {
             post = Post.valueOf(sc.nextLine());
        }
        catch (IllegalArgumentException error)
        {
            IllegalAccessException error2=new IllegalAccessException("either choose BUYER or SELLER");
            print(error2.getMessage());
            return;
        }

        print("please enter your id and your password");
        String id = sc.nextLine();
        String password = sc.nextLine();

        checkInfo(name,family,id,password);

        id=notHavingSameID(id);
        if (id ==null)
            return;

        //--------------------------
        userAccount account = new userAccount(id, name, family, email, phoneNum, password, post,"false");
        users.add(account);
        useraccount = account;

        if (post == Post.BUYER)
            Savefiles.WriteBuyer(useraccount);

        if (post == Post.SELLER) {
            Scanner moreInfo = new Scanner(System.in);
            print("please enter your factory,institute,and work shop name in row");

            String factory = moreInfo.nextLine();
            String institute = moreInfo.nextLine();
            String workshop = moreInfo.nextLine();

            checkInfo(factory,workshop,institute);

            useraccount.getSeller().fullfillInfo(factory, institute, workshop);
            useraccount.getSeller().setAccount_Acceptence(State.ACCEPTING);
            Adminn.getAdmin().acceptUser.add(useraccount);

        }

        userPanel();
    }



    public static String notHavingSameID(String id)
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
            if (vary == 0)
              id=UserFinding();

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
                print("access allowed");
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
            buyerAccess();
        else if (useraccount.getPost() == Post.SELLER && useraccount.getSeller().getAccount_Acceptence()==State.ACCEPTED)
            sellerAccess();
        else if (useraccount.getPost() == Post.SELLER && useraccount.getSeller().getAccount_Acceptence()==State.ACCEPTING)
            print("your account has not been accepted yet...please try again later");
        else if(useraccount.getPost()==Post.ADMIN)
            adminAccess();
    }

    //-----------------------
    public static void CategoryOrganize()
    {
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


    public static void changeInfo() {
        System.out.println("what do you wan to change?" +
                "password 2 /name 3/family name 4 /email 5/money in stock 6/phone number 7 " +
                "after choosing your order please enter the new info");
        Integer order;

        Scanner getOrder = new Scanner(System.in);
        order =checkIntException();
        if (order==null)
            return;

        if (order < 1 || order > 7) {
            wrongOrder("wrong order: enter something between 1 to 7 ");
            return;
        }

        try {
            changeInformation(order);
        }

        catch (InputMismatchException error)
        {
            print(((wrongInputType)error).getMessage());
            print(((wrongInputType)error).toString());
        }
    }

    public static void changeInformation(int order) throws InputMismatchException
    {

        Scanner sc=new Scanner(System.in);

        switch (order)
        {
            case 2:
                String password=sc.nextLine();
                if (!checkInfo2(password))
                   useraccount.setPassword(password);
                break;

            case 3:
                String name= sc.nextLine();
                if (! checkInfo(name))
                   useraccount.setName(name);
                break;

            case 4:
                String familyName=sc.nextLine();
                if (! checkInfo(familyName))
                   useraccount.setFamilyName(familyName);
                break;

            case 5:
                String email=sc.nextLine();
                //checking for email validation
                if ( !invalidEmail(email) )
                    useraccount.setEmail(email);
                break;

            case 6:
                Integer money=checkIntException();
                if (money==null)
                    return;

                useraccount.setMoneyInStock(money);
                break;

            case 7:
                String phoneNum= sc.nextLine();

                //checking for phone validation
                if (!invalidPhoneNum(phoneNum))
                    useraccount.setPhoneNum(phoneNum);
                break;

        }
    }

    //saving to files
    public static void saving()
    {
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
}








