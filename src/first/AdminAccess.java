package first;

import account.making.Request;
import account.making.userAccount;
import allof.exceptions.*;
import files.Savefiles;
import products.Product;
import random.works.Comments;
import random.works.State;

import java.io.IOException;
import java.util.Scanner;

import static project.first.AllExceptions.*;
import static project.first.project.*;

public class AdminAccess {

    public static void adminAccess() {
        Scanner sc = new Scanner(System.in);
        print("your account information:");

        System.out.printf("id: %s\nname: %s\nfamily name: %s\nemail: %s\nphone number: %s\n", useraccount.getId(),
                useraccount.getName(), useraccount.getFamilyName(), useraccount.getEmail(),
                useraccount.getPhoneNum());

        Integer number = 10;
        while (number != 0) {
            print("===============================================");

            print("change info 1\nrequests 2\nall user's accounts 3\ncategories 4\ndelete a user 5\nend 0");

                number = checkIntException();
                if (number==null)
                    number=10;


            switch (number) {
                case 0:
                    break;
                case 1:
                    changeInfo();
                    break;
                case 2:
                    requests();
                    break;
                case 3:
                    allUsers();
                    break;
                case 4:
                    allCategory();
                    break;
                case 5:
                    try {
                        deleteUser();
                    }catch (noUser e){}
                    break;
                default:
                    wrongOrder("wrong order: please enter a number between 0 to 5");
                    break;
            }

        }


    }

    public static void deleteUser() throws noUser {
        print("all users:");
        for (userAccount user : users)
            print("ID:" + user.getId() + "    name:" + user.getName() + "    post:" + user.getPost());

        print("======================");
        print("enter the id of the user you want to delete:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

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

            int number = 0;
            int j = 0;

            for (int i = 0; i < productArrayList.size(); ++i) {
                if (productArrayList.get(i).getSeller() == users.get(index).getSeller())
                    productArrayList.remove(i--);
            }
            users.get(index).setDeleted_account(true);
            try {
                if (users.get(index).getSeller()!=null)
                    Savefiles.WriteSeller(users.get(index));
                else if (users.get(index).getBuyer()!=null)
                    Savefiles.WriteBuyer(users.get(index));
            }catch (IOException e){};
            users.remove(index);
        } else if (find == 1)
            UserNotFound();

    }

    public static void requests() {
        print("requests for seller acc 1\nadd comment 2\nchange product by the seller 3");
        Scanner sc = new Scanner(System.in);

        Integer number = checkIntException();
        if (number==null)
            return;

        if (number == 1) {
            try {
                requestAddSeller();
            }catch (IOException e){}

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
        Scanner sc = new Scanner(System.in);
        if (Adminn.getAdmin().acceptUser.size() == 0) {
            print("there are no requests!");
            return;
        }

        for (userAccount user : Adminn.getAdmin().acceptUser) {
            print("========================================");
            print(user.toString());
            print(user.getSeller().toString());


            print("do you want tp accept this seller?yes/no");

            String order;

            do {
                order = sc.nextLine();
                if (order.equals("yes")) {
                    user.getSeller().setAccount_Acceptence(State.ACCEPTED);
                    Savefiles.WriteSeller(user);
                }
                else if (order.equals("no")) {
                    users.remove(user);
                    user = null;
                } else
                    wrongOrder("error: either choose yes or no");
            } while (!order.equals("yes") && !order.equals("no"));
        }
    }

    public static void requestComment() {
        Scanner sc = new Scanner(System.in);

        if (Adminn.getAdmin().comments_Permission.size() == 0) {
            print("there are no request");
            return;
        }

        for (Comments accept : Adminn.getAdmin().comments_Permission) {
            print("comment text:" + accept.getComment() + "from" + accept.getBuyer_Comment());
            print("do you want to accept the comment?yes/no");

            String order;

            do {
                order = sc.nextLine();
                if (order.equals("yes"))
                    accept.setState(State.ACCEPTED);
                else if (order.equals("no"))
                    accept.setState(State.NOT_ACCEPTED);
                else
                    wrongOrder("error: either choose yes or no");
            } while (!order.equals("yes") && !order.equals("no"));
        }
    }

    public static void requestSellerChangings() {
        Scanner sc = new Scanner(System.in);

        if (Adminn.getAdmin().permission.size() == 0)
            print("there are no requests");

        for (userAccount accept : Adminn.getAdmin().permission) {
            if (accept.getSeller().requests.size() == 0)
                continue;
            print("seller id: " + accept.getId());
            for (Request request : accept.getSeller().requests) {
                print(request);
                print("do you want to give the permission?yes/no");

                String order;

                do {
                    order = sc.nextLine();
                    if (order.equals("yes")) {
                        if (request == Request.ADD)
                            accept.getSeller().setAdd_product(accept.getSeller().getAdd_product() + 1);
                        else if (request == Request.CHANGE)
                            accept.getSeller().setChange_Product(accept.getSeller().getChange_Product() + 1);
                        else
                            accept.getSeller().setDelete_Product(accept.getSeller().getDelete_Product() + 1);
                    } else if (!order.equals("no"))
                        wrongOrder("error: either choose yes or no");

                } while (!order.equals("yes") && !order.equals("no"));


            }
            accept.getSeller().requests.removeAll(accept.getSeller().requests);
        }

    }
    public static void allCategory ()
    {
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

    public static void allUsers ()
    {
        for (userAccount user : users) {
            if (user.getBuyer() != null) {
                print("Buyer:");
                print(user.toString());

            } else if (user.getSeller() != null) {
                print("Seller:");
                print(user.toString());
                print(user.getSeller().toString());

            }
        }
        Scanner sc = new Scanner(System.in);
        print("back (press any button)");
        String order = sc.nextLine();

    }
}
