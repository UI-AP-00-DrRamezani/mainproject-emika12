package files;

import account.making.*;
import products.Product;
import products.digital.laptop;
import products.digital.mobile;
import products.house.refrigator;
import products.house.television;
import products.outfit.dressing;
import products.outfit.shoes;
import products.snacks.snacks;
import project.first.*;
import random.works.*;
import saleing.Sale;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class readFiles {


    private static int tv_counter=1;
    private static int refri_counter=1;
    private static int mobile_counter=1;
    private static int laptop_counter=1;
    private static int dress_counter=1;
    private static int shoes_counter=1;
    private static int snack_counter=1;
    private static int seller_counter=1;
    private static int buyer_counter=1;


    public static void mainRead() throws IOException, ClassNotFoundException,NullPointerException {
        String[] files_name;
        File file = new File("D:/saved data/users");

        files_name = file.list();

        for (String name : files_name) {
            if (name.equals("admin"))
                readAdmin();
            else if (name.equals("sellers"))
                readSeller();
            else
                readBuyer();

        }
    }

    public static void readAdmin() throws IOException, ClassNotFoundException {
        FileInputStream fin;
        ObjectInputStream in;

        String[] files_name;
        String address = "D:/saved data/users/admin";
        File file = new File(address);
        address+="/";

        //reading the info
        fin = new FileInputStream(address + "info.txt");
        Scanner readInfo = new Scanner(fin);

        ArrayList <String> info2=new ArrayList<>();
        while (readInfo.hasNext())
            info2.add(readInfo.next());

        readInfo.close();
        fin.close();

        String [] info=new String[info2.size()];
        for (int i=0 ;i<info2.size();++i)
            info[i]=info2.get(i);

        userAccount admin = new userAccount(info[0], info[1], info[2], info[3], info[4], info[5], Post.valueOf(info[6]),
                info[info.length-1]);
        admin.setMoneyInStock(Double.parseDouble(info[7]));

        //reading the comment permission
        fin = new FileInputStream(address + "comment permission.txt");
        in = new ObjectInputStream(fin);

        while (fin.available() != 0)
            admin.getAdmin().comments_Permission.add((Comments) in.readObject());

        in.close();
        fin.close();

        //read users requests
        fin = new FileInputStream(address + "request userAcc.txt");
        in = new ObjectInputStream(fin);

        while (fin.available() != 0)
            admin.getAdmin().acceptUser.add((userAccount) in.readObject());

        in.close();
        fin.close();

        //read seller requests permission
        fin = new FileInputStream(address + "requests permission.txt");
        in = new ObjectInputStream(fin);

        while (fin.available() != 0)
            admin.getAdmin().permission.add((userAccount) in.readObject());

        in.close();
        fin.close();

        project.Adminn = admin;
    }


    public static void readBuyer() throws IOException, ClassNotFoundException {
        FileInputStream theBuyer;
        ObjectInputStream in;

        String[] files_name;
        String address = "D:/saved data/users/buyers";
        File file = new File(address);
        files_name = file.list();
        buyer_counter=files_name.length+1;
        address+="/";

        for (String eachFile : files_name) {

            //reading the info
            theBuyer = new FileInputStream(address + eachFile + "/info.txt");
            Scanner readInfo = new Scanner(theBuyer);

            ArrayList <String> info=new ArrayList<>();

            while (readInfo.hasNext())
                info.add(readInfo.nextLine());

            readInfo.close();
            theBuyer.close();

            userAccount buyer = new userAccount(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4), info.get(5)
                    , Post.valueOf(info.get(6)),info.get(info.size()-1));
            buyer.setMoneyInStock(Double.parseDouble(info.get(7)));
            buyer.setAddress(info.get(8));
            buyer.setDeleted_account(Boolean.parseBoolean(info.get(9)));

            //reading the basket
            theBuyer = new FileInputStream(address + eachFile + "/basket.txt");
            in = new ObjectInputStream(theBuyer);

            while (theBuyer.available() != 0)
                buyer.getBuyer().setBuyList((BuyList) in.readObject());
            in.close();
            theBuyer.close();

            //reading the factors
            theBuyer = new FileInputStream(address + eachFile + "/factors.txt");
            in = new ObjectInputStream(theBuyer);

            while (theBuyer.available() != 0)
                buyer.getBuyer().list.add((BuyList) in.readObject());
            in.close();
            theBuyer.close();

            //adding the users
            if ( ! buyer.isDeleted_account())
                project.users.add(buyer);

        }
    }

    public static void readSeller() throws IOException, ClassNotFoundException {
        FileInputStream theSeller;
        ObjectInputStream in;

        String[] files_name;
        String address = "D:/saved data/users/sellers";
        File file = new File(address);
        files_name = file.list();
        seller_counter=files_name.length+1;

        address+="/";

        for (String eachFile : files_name) {

            //reading the info
            theSeller = new FileInputStream(address + eachFile + "/info.txt");
            Scanner readInfo = new Scanner(theSeller);


            ArrayList <String> info=new ArrayList<>();
            while (readInfo.hasNext())
                info.add(readInfo.nextLine());

            readInfo.close();
            theSeller.close();

            String [] info2=new String[info.size()];
            for (int i=0 ;i<info.size();++i)
                info2[i]=info.get(i);

            userAccount seller = new userAccount(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4), info.get(5)
                    , Post.valueOf(info.get(6)),info.get(info.size()-1));
            seller.setMoneyInStock(Double.parseDouble(info.get(7)));
            seller.getSeller().readTheInfoPart2(info2);
            seller.setAddress(info.get(11));
            seller.setDeleted_account(Boolean.parseBoolean(info.get(12)));

            //reading factors
            theSeller = new FileInputStream(address + eachFile + "/factors.txt");
            in = new ObjectInputStream(theSeller);

            while (theSeller.available() != 0)
                seller.getSeller().list.add((SellList) in.readObject());

            in.close();
            theSeller.close();

            if( ! seller.isDeleted_account()) {
                project.users.add(seller);
                //reading the products
                readProducts(seller, address + eachFile + "/Products");
            }
        }
    }

    public static void readProducts(userAccount seller , String address) throws IOException ,ClassNotFoundException
    {
        File file=new File(address);
        String [] products=file.list();

        address+="/";
        FileInputStream fin;
        ObjectInputStream in;

        for (String name : products)
        {
            Product product;
            //info
            fin=new FileInputStream(address+name+"/info.txt");
            Scanner reader=new Scanner(fin);

            ArrayList <String> info=new ArrayList<>();
            while (reader.hasNext())
                info.add(reader.nextLine());

            String [] info2=new String[info.size()];
            for (int i=0 ;i<info.size();++i)
                info2[i]=info.get(i);

            if (name.contains("laptop")) {
                product = new laptop();
                laptop_counter++;
            }
            else if (name.contains("mobile")) {
                product = new mobile();
                mobile_counter++;
            }
            else if (name.contains("refrigerator")) {
                product = new refrigator();
                refri_counter++;
            }
            else if (name.contains("television")) {
                product = new television();
                tv_counter++;
            }
            else if (name.contains("dress")) {
                product = new dressing();
                dress_counter++;
            }
            else if (name.contains("shoe")) {
                product = new shoes();
                shoes_counter++;
            }
            else {
                product = new snacks();
                snack_counter++;
            }

            product.readingFromFile(info2);

            //rates
            fin=new FileInputStream(address+name+"/rates.txt");
            in=new ObjectInputStream(fin);

            while (fin.available()!=0)
                product.rate.add((Rate) in.readObject());

            in.close();
            fin.close();

            //comments
            fin=new FileInputStream(address+name+"/comments.txt");
            in=new ObjectInputStream(fin);

            while (fin.available()!=0)
                product.comments.add((Comments) in.readObject());

            in.close();
            fin.close();

            //sales
            fin=new FileInputStream(address+name+"/sales.txt");
            in=new ObjectInputStream(fin);
            while(fin.available()!=0)
                product.sales.add((Sale) in.readObject());

            in.close();
            fin.close();

            //adding them in the right places

            if ( ! product.isDeleted_product()) {
                product.setSeller(seller.getSeller());
                seller.getSeller().productList.add(product);
                project.productArrayList.add(product);
            }

        }
    }

    public static int getTv_counter() {
        return tv_counter;
    }

    public static int getRefri_counter() {
        return refri_counter;
    }

    public static int getMobile_counter() {
        return mobile_counter;
    }

    public static int getLaptop_counter() {
        return laptop_counter;
    }

    public static int getDress_counter() {
        return dress_counter;
    }

    public static int getShoes_counter() {
        return shoes_counter;
    }

    public static int getSnack_counter() {
        return snack_counter;
    }

    public static int getSeller_counter() {
        return seller_counter;
    }

    public static int getBuyer_counter() {
        return buyer_counter;
    }

    public static void setTv_counter(int tv_counter) {
        readFiles.tv_counter = tv_counter;
    }

    public static void setRefri_counter(int refri_counter) {
        readFiles.refri_counter = refri_counter;
    }

    public static void setMobile_counter(int mobile_counter) {
        readFiles.mobile_counter = mobile_counter;
    }

    public static void setLaptop_counter(int laptop_counter) {
        readFiles.laptop_counter = laptop_counter;
    }

    public static void setDress_counter(int dress_counter) {
        readFiles.dress_counter = dress_counter;
    }

    public static void setShoes_counter(int shoes_counter) {
        readFiles.shoes_counter = shoes_counter;
    }

    public static void setSnack_counter(int snack_counter) {
        readFiles.snack_counter = snack_counter;
    }

    public static void setSeller_counter(int seller_counter) {
        readFiles.seller_counter = seller_counter;
    }

    public static void setBuyer_counter(int buyer_counter) {
        readFiles.buyer_counter = buyer_counter;
    }
}