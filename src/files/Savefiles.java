package files;
import com.mysql.cj.xdevapi.Result;
import files.mySQL.mySQLTable;
import products.Product;
import products.digital.laptop;
import products.digital.mobile;
import products.house.refrigator;
import products.house.television;
import products.outfit.dressing;
import products.outfit.shoes;
import project.first.*;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.making.*;
import random.works.Comments;
import random.works.Rate;
import random.works.State;
import saleing.Sale;

import static files.mySQL.saveMySQL.productWriteSQL;
import static files.mySQL.saveMySQL.writeMySQL;

public final class Savefiles
{
    private final static String buyerSaver="D:\\saved data\\users\\buyers\\buyer ";
    private final static String sellerSaver="D:\\saved data\\users\\sellers\\seller ";
    private final static String productSaver="D:\\saved data\\categories";




    //==================================================================

    public static void writingUsers() throws IOException {

        makeFolders();

        for (userAccount user : project.users)
        {
            if (user.getBuyer() != null)
                WriteBuyer(user);

            else if(user.getSeller() != null &&
                    user.getSeller().getAccount_Acceptence()!= State.NOT_ACCEPTED)
                WriteSeller(user);

            else if (user.getAdmin() != null){
                WriteAdmin(user);
            }
            writeMySQL(user);
        }
    }

    public static void WriteBuyer(userAccount user) throws IOException {

        String fileAddress;
        if (user.getAddress()== null) {
            fileAddress = buyerSaver + Integer.toString(readFiles.getBuyer_counter());
            user.setAddress(fileAddress);
            readFiles.setBuyer_counter(readFiles.getBuyer_counter()+1);
        }else
            fileAddress=user.getAddress();


        File theDir=new File("/"+fileAddress);
        if (!theDir.exists()) theDir.mkdirs();


        FileOutputStream info =new FileOutputStream(fileAddress+"\\info.txt");
        FileOutputStream factors =new FileOutputStream(fileAddress+"\\factors.txt");
        FileOutputStream basket =new FileOutputStream(fileAddress+"\\basket.txt");

        PrintWriter printWriter=new PrintWriter(info);
        ObjectOutputStream out=new ObjectOutputStream(factors);
        ObjectOutputStream out2=new ObjectOutputStream(basket);

        printWriter.format("%s%s",user.myToString(),user.addresses());
        printWriter.close();
        info.close();

        for (BuyList buyList : user.getBuyer().list)
            out.writeObject(buyList);
        out.close();
        factors.close();

        out2.writeObject(user.getBuyer().getBuyList());

        out2.close();
        basket.close();
    }

    public static void WriteSeller(userAccount user) throws IOException
    {
        String fileAddress ;
        if (user.getAddress()==null) {
            fileAddress = sellerSaver + Integer.toString(readFiles.getSeller_counter());
            user.setAddress(fileAddress);
            readFiles.setSeller_counter(readFiles.getSeller_counter()+1);
        }else
            fileAddress=user.getAddress();


        File theDir=new File("/"+fileAddress);
        if (!theDir.exists()) theDir.mkdirs();

        FileOutputStream info =new FileOutputStream(fileAddress+"\\info.txt");
        FileOutputStream factors =new FileOutputStream(fileAddress+"\\factors.txt");

        PrintWriter printWriter=new PrintWriter(info);
        ObjectOutputStream out=new ObjectOutputStream(factors);

        printWriter.printf("%s%s%s%s%s",user.myToString(),user.getSeller().myToString2(),user.addresses(),
                user.getSeller().innerInfo(),user.isDeleted_account());
        for (SellList sellList : user.getSeller().list)
            out.writeObject(sellList);

        out.close();
        factors.close();


        theDir=new File("/"+fileAddress+"/Products");
        if (!theDir.exists()) theDir.mkdirs();


        int product_counter=1;
        //finding the amount of products
        String [] files=theDir.list();
        product_counter=files.length+1;


        for (Product product : user.getSeller().productList) {

            writingProducts(product);
            writingProducts2(product ,product_counter,fileAddress);
            productWriteSQL(product);
            ++product_counter;
        }

        printWriter.close();
        out.close();
        factors.close();
        info.close();
    }

    public static void WriteAdmin(userAccount user) throws IOException
    {
        FileOutputStream fout = new FileOutputStream("D:\\saved data\\users\\admin\\info.txt");
        FileOutputStream fout2 = new FileOutputStream("D:\\saved data\\users\\admin\\requests permission.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout2);
        PrintWriter printWriter=new PrintWriter(fout);


        printWriter.format("%s%s",user.myToString(),user.addresses());
        for (userAccount account : user.getAdmin().permission)
            out.writeObject(account);

        out.close();
        printWriter.close();
        fout.close();
        fout2.close();

        fout=new FileOutputStream("D:\\saved data\\users\\admin\\request userAcc.txt");
        out=new ObjectOutputStream(fout);

        for (userAccount account : user.getAdmin().acceptUser)
            out.writeObject(account);

        out.close();
        fout.close();

        fout=new FileOutputStream("D:\\saved data\\users\\admin\\comment permission.txt");
        out=new ObjectOutputStream(fout);

        for (Comments comment : user.getAdmin().comments_Permission)
            out.writeObject(comment);

        out.close();
        fout.close();
    }

    public static void writingProducts(Product product) throws IOException
    {

        if (product.getAddress2()!=null)
            writeEachProduct(product ,-100);
        else {
            if (product instanceof television) {
                writeEachProduct(product, readFiles.getTv_counter());
                readFiles.setTv_counter(readFiles.getTv_counter() + 1);
            } else if (product instanceof refrigator) {
                writeEachProduct(product, readFiles.getRefri_counter());
                readFiles.setRefri_counter(readFiles.getRefri_counter() + 1);
            } else if (product instanceof mobile) {
                writeEachProduct(product, readFiles.getMobile_counter());
                readFiles.setMobile_counter(readFiles.getMobile_counter() + 1);
            } else if (product instanceof laptop) {
                writeEachProduct(product, readFiles.getLaptop_counter());
                readFiles.setLaptop_counter(readFiles.getLaptop_counter() + 1);
            } else if (product instanceof dressing) {
                writeEachProduct(product, readFiles.getDress_counter());
                readFiles.setDress_counter(readFiles.getDress_counter() + 1);
            } else if (product instanceof shoes) {
                writeEachProduct(product, readFiles.getShoes_counter());
                readFiles.setShoes_counter(readFiles.getShoes_counter() + 1);
            } else {
                writeEachProduct(product, readFiles.getSnack_counter());
                readFiles.setSnack_counter(readFiles.getSnack_counter() + 1);
            }
        }

    }

    public static void writingProducts2(Product product,int product_counter ,String fileAddress) throws IOException
    {
        FileOutputStream products_info;
        FileOutputStream products_comments;

        String address;
        if (product.getAddress()!=null)
            address=product.getAddress();

        else {
            if (product instanceof television)
                address = fileAddress + "\\Products\\television " + product_counter;
            else if (product instanceof refrigator)
                address = fileAddress + "\\Products\\refrigerator " + product_counter;

            else if (product instanceof shoes)
                address = fileAddress + "\\Products\\shoe " + product_counter;

            else if (product instanceof dressing)
                address = fileAddress + "\\Products\\dressing " + product_counter;

            else if (product instanceof mobile)
                address = fileAddress + "\\Products\\mobile " + product_counter;

            else if (product instanceof laptop)
                address = fileAddress + "\\Products\\laptop " + product_counter;
            else
                address = fileAddress + "\\Products\\snack " + product_counter;
        }
        String address2=address.replaceAll("\\\\","/");

        if (product.getAddress()==null)
            product.setAddress(address);

        File theDir=new File("/"+address2);
        if (!theDir.exists()) theDir.mkdirs();

        products_info =new FileOutputStream(address +"\\info.txt");
        products_comments =new FileOutputStream(address +"\\comments.txt");
        FileOutputStream products_sale=new FileOutputStream(address+"\\sales.txt");
        FileOutputStream products_rates=new FileOutputStream(address+"\\rates.txt");

        ObjectOutputStream out2=new ObjectOutputStream(products_comments);
        PrintWriter printWriter1=new PrintWriter(products_info);

        for (Comments comment : product.comments)
            out2.writeObject(comment);

        out2.close();
        products_comments.close();

        printWriter1.printf("%s%s%s%s%d",product.myToString(),product.myToString2(),product.myToString3(),product.addressesAndStar()
        ,product.getStar());

        printWriter1.close();
        products_info.close();

        out2=new ObjectOutputStream(products_rates);
        for (Rate rate : product.rate)
            out2.writeObject(rate);

        out2.close();
        products_rates.close();

        out2=new ObjectOutputStream(products_sale);
        for (Sale sale : product.sales)
            out2.writeObject(sale);

        out2.close();
        products_sale.close();
    }
    public static void writeEachProduct(Product product , int count) throws IOException
    {
        FileOutputStream fout;
        PrintWriter printWriter;

        String fileAddress;
        if (product.getAddress2()!=null)
            fileAddress=product.getAddress2();
        else {
            if (product instanceof television) {
                fileAddress = productSaver + "\\house products\\tv " + count;
                ++count;
            } else if (product instanceof refrigator) {
                fileAddress = productSaver + "\\house products\\refrigerator " + count;
                ++count;
            } else if (product instanceof mobile) {
                fileAddress = productSaver + "\\digital products\\mobile " + count;
                ++count;
            } else if (product instanceof laptop) {
                fileAddress = productSaver + "\\digital products\\laptop " + count;
                ++count;
            } else if (product instanceof dressing) {
                fileAddress = productSaver + "\\outfit\\dress " + count;
                ++count;
            } else if (product instanceof shoes) {
                fileAddress = productSaver + "\\outfit\\shoes " + count;
                ++count;
            } else {
                fileAddress = productSaver + "\\snacks\\snack " + count;
                ++count;
            }
        }
        if (product.getAddress2()==null)
            product.setAddress2(fileAddress);


        File theDir = new File(fileAddress.replaceAll("\\\\","/"));
        if (!theDir.exists())
            theDir.mkdirs();

        fout=new FileOutputStream(fileAddress+"\\info.txt");
        printWriter=new PrintWriter(fout);

        product.ratingAmount();
        printWriter.printf("%s%s%s%s%d",product.myToString(),product.myToString2(),product.myToString3(),product.addressesAndStar()
        ,product.getStar());
        printWriter.close();
        fout.close();

        fout=new FileOutputStream(fileAddress+"\\comment.txt");
        ObjectOutputStream out =new ObjectOutputStream(fout);
        for (Comments comments1 : product.comments)
            out.writeObject(comments1);

        out.close();
        fout.close();

        fout=new FileOutputStream(fileAddress+"\\rate.txt");
        out=new ObjectOutputStream(fout);

        for (Rate rate : product.rate)
            out.writeObject(rate);

        out.close();
        fout.close();

        fout=new FileOutputStream(fileAddress+"\\sale.txt");
        out=new ObjectOutputStream(fout);

        for (Sale sale : product.sales)
            out.writeObject(sale);

        out.close();
        fout.close();

        fout=new FileOutputStream(fileAddress+"\\seller.txt");
        out=new ObjectOutputStream(fout);

        out.writeObject(product.getSeller());

        out.close();
        fout.close();
    }

    public static void makeFolders()
    {
        File theDir = new File("D://saved data/users/admin");
        if (!theDir.exists())
            theDir.mkdirs();

        theDir=new File("D://saved data/users/buyers");
        if (!theDir.exists())
            theDir.mkdirs();

        theDir=new File("D://saved data/users/sellers");
        if (!theDir.exists())
            theDir.mkdirs();

        theDir=new File("D://saved data/categories");
        if (!theDir.exists())
            theDir.mkdirs();
    }




}