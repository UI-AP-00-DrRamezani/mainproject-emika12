package project.first;

import account.making.Admin;
import account.making.Request;
import account.making.userAccount;
import allof.exceptions.*;
import files.Savefiles;
import graphics.user.admin.Eachrequests;
import graphics.user.admin.show;
import products.Product;
import random.works.Comments;
import random.works.State;

import javax.swing.*;

import static files.mySQL.deleteMySQL.deletingUsers;
import static project.first.project.*;
import static project.first.AllExceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminAccess {

    private static Boolean requestState;
    private static boolean notifying =false;
    private static final Object lock = new Object();


    public static void deleteUser(String id) throws noUser {

        //print("enter the id of the user you want to delete:");

        //finding the id
        int find = 1;
        int index = 0;
        for (userAccount user : users) {
            if (find == 1) {
                if (user.getId().equals(id))
                    find = 0;
                else
                    ++index;
            }
        }
        if (find == 0) {

            for (int i = 0; i < productArrayList.size(); ++i) {
                if (productArrayList.get(i).getSeller() == users.get(index).getSeller())
                    productArrayList.remove(i--);
            }
            users.get(index).setDeleted_account(true);
            //deleting from database
            deletingUsers(users.get(index));

            try {
                if (users.get(index).getSeller() != null)
                    Savefiles.WriteSeller(users.get(index));
                else if (users.get(index).getBuyer() != null)
                    Savefiles.WriteBuyer(users.get(index));
            } catch (IOException e) {}

            users.remove(index);
        } else if (find == 1)
            UserNotFound();

    }

    public static void requests() {
       // print("requests for seller acc 1\nadd comment 2\nchange product by the seller 3");
        Scanner sc = new Scanner(System.in);

        Integer number = checkIntException();
        if (number == null)
            return;

        if (number == 1) {
            try {
                requestAddSeller();
            } catch (IOException e) {
            }

            Adminn.getAdmin().acceptUser.removeAll(Adminn.getAdmin().acceptUser); //for removing all elements in the array list
        } else if (number == 2) {
            requestComment();
            Adminn.getAdmin().comments_Permission.removeAll(Adminn.getAdmin().comments_Permission);

        } else if (number == 3) {
            requestSellerChangings();
            Adminn.getAdmin().permission.removeAll(Adminn.getAdmin().permission);
        } else
            wrongOrder("wrnog order:the order must be between 1 to 3");
    }

    //requests--
    public static void requestAddSeller() throws IOException {


        if (Adminn.getAdmin().acceptUser.size() == 0) {
            throw new notFound("there are no requests");
        }
        ArrayList<show>list=new ArrayList<>();

        //making the graphic
        for (userAccount user : Adminn.getAdmin().acceptUser) {
            show new_show=new show("========================================\n"+user.toString()+
                    "\n"+user.getSeller().toString());
            list.add(new_show);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Eachrequests eachrequests=new Eachrequests(list);
            }
        });
        //--------------------------------------------put the states
        for (userAccount user : Adminn.getAdmin().acceptUser) {
            locking2();//having a lock for each round till we can get the request state from the admin

            //print("do you want tp accept this seller?yes/no");

                if (requestState) {
                    user.getSeller().setAccount_Acceptence(State.ACCEPTED);
                    Savefiles.WriteSeller(user);
                } else if (!requestState) {
                    users.remove(user);
                    user = null;
                }
        }
        Adminn.getAdmin().acceptUser.removeAll(Adminn.getAdmin().acceptUser);
    }

    public static void requestComment() {

        ArrayList<show>list=new ArrayList<>();

        if (Adminn.getAdmin().comments_Permission.size() == 0)
            throw new notFound("there are no requests");

        //making the graphic
        for (Comments accept : Adminn.getAdmin().comments_Permission) {
            show s=new show("comment text: " + accept.getComment() + "from " + accept.getBuyer_Comment());
            list.add(s);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Eachrequests eachrequests=new Eachrequests(list);
            }
        });
        //--------------------------------------------put the states

        for (Comments accept : Adminn.getAdmin().comments_Permission) {
            //print("do you want to accept the comment?yes/no");
            locking2();

                if (requestState)
                    accept.setState(State.ACCEPTED);
                else if (!requestState)
                    accept.setState(State.NOT_ACCEPTED);
        }
        Adminn.getAdmin().comments_Permission.removeAll(Adminn.getAdmin().comments_Permission);
    }

    public static void requestSellerChangings() {


        if (Adminn.getAdmin().permission.size() == 0)
            throw new notFound("there are no requests");

        ArrayList<show>list=new ArrayList<>();

        //making the graphic
        for (userAccount accept : Adminn.getAdmin().permission) {
            if (accept.getSeller().requests.size() == 0)
                continue;
            for (Request request : accept.getSeller().requests) {
                show s=new show("seller id: " + accept.getId()+" "+request);
                list.add(s);
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Eachrequests eachrequests=new Eachrequests(list);
            }
        });

        //-------------------------------------------
        for (userAccount accept : Adminn.getAdmin().permission) {
            if (accept.getSeller().requests.size() == 0)
                continue;
            for (Request request : accept.getSeller().requests) {

                locking2();
            // print("do you want to give the permission?yes/no");

                    if (requestState) {
                        if (request == Request.ADD)
                            accept.getSeller().setAdd_product(accept.getSeller().getAdd_product() + 1);
                        else if (request == Request.CHANGE)
                            accept.getSeller().setChange_Product(accept.getSeller().getChange_Product() + 1);
                        else
                            accept.getSeller().setDelete_Product(accept.getSeller().getDelete_Product() + 1);
                    }
            }
            project.saving();
            accept.getSeller().requests.removeAll(accept.getSeller().requests);

        }
        Adminn.getAdmin().permission.removeAll(Adminn.getAdmin().permission);
    }

    public static void allCategory() {
        print("available categories: ");
        print("digital products/outfits/house products/snacks: ");
        Scanner sc = new Scanner(System.in);

        String order = sc.nextLine();
        if (order.equals("digital products")) {
            print("name:" + digital_Products.getName());
            print("features:" + digital_Products.getFeatures());
            print("===========================");
            print("available products:");
            for (Product product : digital_Products.products) {
                print("name: " + product.getName() + "       price:" + product.getPrice());
            }
        } else if (order.equals("outfits")) {
            print("name:" + outfit_Products.getName());
            print("features:" + outfit_Products.getFeatures());
            print("===========================");
            print("available products:");
            for (Product product : outfit_Products.products) {
                print("name: " + product.getName() + "       price:" + product.getPrice());
            }
        } else if (order.equals("house products")) {
            print("name:" + house_products.getName());
            print("features:" + house_products.getFeatures());
            print("===========================");
            print("available products:");
            for (Product product : house_products.products) {
                print("name: " + product.getName() + "       price:" + product.getPrice());
            }
        } else if (order.equals("snacks")) {
            print("name:" + snack_products.getName());
            print("features:" + snack_products.getFeatures());
            print("===========================");
            print("available products:");
            for (Product product : snack_products.products) {
                print("name: " + product.getName() + "       price:" + product.getPrice());
            }
        } else
            wrongOrder("wrong order");
    }

    public static ArrayList<show> allUsers(int order)//for just seeing them or delete them
    {
        ArrayList<show> list = new ArrayList<>();
        if (order == 1) {//for just seeing them
            for (userAccount user : users) {
                show new_show = null;
                if (user.getBuyer() != null) {
                    new_show = new show("Buyer: \n" + user.toString() + " \n-------------------");

                } else if (user.getSeller() != null) {
                    new_show = new show("Seller: \n" + user.toString() + user.getSeller().toString()
                            + " \n-------------------");

                }else continue;
                new_show.setID(user.getId());
                list.add(new_show);
            }
        } else {
            for (userAccount user : users) {
                show new_show;
                if (user.getAdmin() == null) {
                    new_show = new show("ID:" + user.getId() + "    name:" + user.getName() + "    post:" + user.getPost());
                    new_show.setID(user.getId());
                    list.add(new_show);
                }
            }
        }
        return list;

    }

    //=============================================locking up

    public static void locking2()
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
    public static void mySuspend()
    {
        synchronized (lock){
            lock.notifyAll();
        }
    }

    //==========================================getter/setter

    public static void setRequestState(Boolean requestState) {
        AdminAccess.requestState = requestState;
    }

    public static void setNotifying(boolean notifying) {
        AdminAccess.notifying = notifying;
    }
}