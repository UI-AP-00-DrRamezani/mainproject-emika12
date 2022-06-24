package project.first;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


import allof.exceptions.*;
import files.Savefiles;
import products.*;
import products.digital.*;
import products.outfit.*;
import products.snacks.*;
import products.house.*;

import account.making.*;
import saleing.Sale;

import javax.swing.*;

import static files.mySQL.deleteMySQL.deletingProduct;
import static project.first.ProductPart.showEachProduct;
import static project.first.checking.checkInfo;
import static project.first.project.*;
import static project.first.AllExceptions.*;

public class SellerAccess {
    //-------
    public static void makeDiscount() throws notFound {
        Scanner sc = new Scanner(System.in);
        showOwnProducts();
        print("enter the earmark of the product: ");
        Integer earmark = checkIntException();
        if (earmark == null)
            return;

        Product the_product = null;
        for (Product product : useraccount.getSeller().productList) {
            if (product.getEarmark() == earmark) {
                if (product instanceof digitalProduct || product instanceof outfit
                        || product instanceof snacks)
                    the_product = product;
                else {
                    wrongOrder("sorry but this product can not have a discount");
                    return;
                }
            }
        }
        if (the_product == null)
            notFound("wrong earmark: the product not found");

        else {
            LocalDate date = takeDate();
            if (date == null)
                return;

            print("global discount 1 /special discount 2");
            Integer order = checkIntException();
            if (order == null)
                return;

            Sale sale;
            if (order == 1) {
                if (the_product instanceof digitalProduct)
                    sale = ((digitalProduct) the_product).aDDDiscountNoCode(date);
                else if (the_product instanceof outfit)
                    sale = ((outfit) the_product).aDDDiscountNoCode(date);
                else
                    sale = ((snacks) the_product).aDDDiscountNoCode(date);
                print("added successfully");
                print("the discount info: " + sale.toString());
            } else if (order == 2) {
                print("capacity: ");
                Integer capacity = checkIntException();
                if (capacity == null)
                    return;

                if (the_product instanceof digitalProduct)
                    sale = ((digitalProduct) the_product).addDiscount(capacity, date);
                else if (the_product instanceof outfit)
                    sale = ((outfit) the_product).addDiscount(capacity, date);
                else
                    sale = ((snacks) the_product).addDiscount(capacity, date);
                print("added successfully");
                print("the discount info: " + sale.toString());
            } else
                wrongOrder("wrong order");
        }
    }

    public static LocalDate takeDate() {

        LocalDate date = null;
        Scanner sc = new Scanner(System.in);
        print("please enter the expiring date: ");

        String userInput = sc.nextLine();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            date = LocalDate.parse(userInput, dateFormat);

        } catch (DateTimeParseException error) {
            print("wrong date format");
        } finally {
            return date;
        }

    }

    public static void showSellList() {
        for (SellList sellList : useraccount.getSeller().list) {
            print("factor number: " + sellList.getFactorNum());
            print("Date: " + sellList.getDate());
            print("transmission: " + sellList.getTransmission());
            print("buyer name: " + sellList.getBuyerName());
            print("price: " + sellList.getPrice());

            print("products:");
            for (Product product : sellList.products_list) {
                print("name: " + product.getName() + "   earmark: " + product.getEarmark());
            }

        }
    }

    public static void showOwnProducts() {
        for (Product product : useraccount.getSeller().productList) {
            showEachProduct(product);
            print("***========================================***");
        }
    }


    public static void deletingAllowed()
    {
        if (useraccount.getSeller().getDelete_Product() <= 0)
            accessDenied("you have not been allowed to delete a product");
    }
    public static void deleteProduct(int earmark) throws AccessAllowance, notFound {

        //print("please enter the earmark of the product : ");
        //Scanner sc = new Scanner(System.in);


        findEarmark(earmark);

        int i = 0; //for finding the index of that product so we can delete it
        int finding = 10;
        for (Product find : useraccount.getSeller().productList) {
            if (finding == 0)
                continue;

            if (earmark == find.getEarmark())
                finding = 0;
            ++i;
        }
        finding = 10;
        useraccount.getSeller().productList.get(i - 1).setDeleted_product(true);
        //deleting from data base
        deletingProduct(useraccount.getSeller().productList.get(i - 1));
        try {//saving it before removing it from arrays
            Savefiles.WriteSeller(useraccount);
        } catch (IOException e) {
        }
        useraccount.getSeller().productList.remove(i - 1);
        i = 0;
        for (Product product : productArrayList) {
            if (finding == 0)
                continue;

            if (product.getEarmark() == earmark)
                finding = 0;
            ++i;
        }
        productArrayList.remove(i - 1);
        useraccount.getSeller().setDelete_Product(useraccount.getSeller().getDelete_Product() - 1);
    }


    public static void changingAllowed()
    {
        if (useraccount.getSeller().getChange_Product() <= 0)
            accessDenied("you have not been allowed to delete a product");
    }

    public static void changeProductInfo(Product product, String order, String change) throws IllegalArgumentException, wrongInputType {

        if (order.equals("name")) {
            String name = change;
            if (checkInfo(name))
                return;

            product.setName(name);
        } else if (order.equals("brand")) {
            String name = change;
            if (checkInfo(name))
                return;

            product.setBrand(name);
        } else if (order.equals("price")) {
            int check = Integer.parseInt(change);

            product.setPrice(check);
            if (product instanceof digitalProduct)
                ((digitalProduct) product).guaranteeCalculation();
            else if (product instanceof television)
                ((television) product).guaranteeCalculation();
            else if (product instanceof refrigator)
                ((refrigator) product).guaranteeCalculation();

        } else if (order.equals("in stock")) {

            int check = Integer.parseInt(change);


            product.setInStock(check);
        } else if (product instanceof digitalProduct) {
            if (order.equals("ram space")) {
                int check = Integer.parseInt(change);

                ((digitalProduct) product).setRam_space(check);
            } else if (order.equals(("memory"))) {
                int check = Integer.parseInt(change);


                ((digitalProduct) product).setMemory(check);
            } else if (order.equals("operating system"))
                ((digitalProduct) product).setOperating_System(change);

            else if (order.equals("resolution"))
                ((digitalProduct) product).setResolution(change);

            else if (product instanceof mobile) {
                if (order.equals("sim numbers")) {
                    int check = Integer.parseInt(change);

                    ((mobile) product).setSIM_num(check);
                } else if (order.equals("camera quality"))
                    ((mobile) product).setCameraQuantity(change);
                else {
                    print("wrong order");
                    return;
                }
            } else if (product instanceof laptop) {
                if (order.equals("processor model"))
                    ((laptop) product).setProcessor_Model(change);
                else if (order.equals("for gaming")) {
                    boolean check = Boolean.parseBoolean(change);
                    ((laptop) product).setFor_Gaming(check);
                } else {
                    wrongOrder("wrong order");
                    return;
                }
                ((digitalProduct) product).guaranteeCalculation();
            }
        } else if (product instanceof outfit) {
            if (order.equals("made in"))
                ((outfit) product).setMade_In(change);
            else if (order.equals("material"))
                ((outfit) product).setMaterial(change);

            else if (product instanceof dressing) {
                if (order.equals("size"))
                    ((dressing) product).setSize(change);
                else if (order.equals("model")) {
                    ((dressing) product).setModel(DressModel.valueOf(change));

                } else {
                    wrongOrder("wrong order");
                    return;
                }

            } else if (product instanceof shoes) {
                if (order.equals("size")) {
                    Integer check = checkIntException();
                    if (check == null)
                        return;

                    ((shoes) product).setSize(check);
                } else if (order.equals("model"))
                    ((shoes) product).setModel(ShoesModel.valueOf(change));

                else {
                    wrongOrder("wrong order");
                    return;
                }
            }

        } else if (product instanceof houseProducts) {
            if (order.equals("energy")) {
                int check = Integer.parseInt(change);

                ((houseProducts) product).setEnergy_Usage(check);
            } else if (order.equals("guarantee")) {
                Boolean check = Boolean.parseBoolean(change);

                ((houseProducts) product).setGarentie(check);
            } else if (product instanceof television) {
                if (order.equals("picture quality"))
                    ((television) product).setPic_Quality(change);
                else if (order.equals("windows size")) {
                    int check = Integer.parseInt(change);
                    ((television) product).setWindows_Size(check);
                } else {
                    wrongOrder("wrong order");
                    return;
                }
                ((television) product).guaranteeCalculation();

            } else if (product instanceof refrigator) {
                if (order.equals("storage")) {
                    int check = Integer.parseInt(change);
                    ((refrigator) product).setStorage(check);
                } else if (order.equals("model"))
                    ((refrigator) product).setModel(change);
                else if (order.equals("having freezer")) {
                    Boolean check = Boolean.parseBoolean(change);

                    ((refrigator) product).setHaving_Freezer(check);
                } else {
                    wrongOrder("wrong order");
                    return;
                }
                ((refrigator) product).guaranteeCalculation();
            }
        } else if (product instanceof snacks) {
            if (order.equals("producing date")) {

                String date = change;
                boolean check = checkDateFormat(date);
                if (!check)
                    return;
                ((snacks) product).setProducing_date(date);
            } else if (order.equals("expiring date")) {

                String date = change;
                boolean check = checkDateFormat(date);
                if (!check)
                    return;

                ((snacks) product).setExpiring_date(date);
            } else {
                wrongOrder("wrong order");
                return;
            }
        } else if (order.equals("end"))
            return;

        else
            wrongOrder("wrong order");

        useraccount.getSeller().setChange_Product(useraccount.getSeller().getChange_Product() - 1);

    }


    public static Product findEarmark(int earmark) throws notFound, InputMismatchException {
        //print("please enter the earmark of the product: ");
        //Scanner scc = new Scanner(System.in);

        Product product = null;
        for (Product find : useraccount.getSeller().productList) {
            if (earmark == find.getEarmark()) {
                product = find;
            }
        }
        if (product == null)
            notFound("earmark was wrong");

        return product;
    }

    public static void makeListForSeller(double payMoney, String time) {


        ArrayList<Seller> each_Seller = new ArrayList<Seller>();
        int find = 1;

        //find each sellers and separate them to add their products into their list
        for (Product product : useraccount.getBuyer().getBuyList().products_List) {
            for (Seller find_Seller : each_Seller) {
                if (product.getSeller().getSame().getId().equals(find_Seller.getSame().getId())) {
                    find_Seller.getSellList().products_list.add(product);
                    find = 0;
                }
            }
            if (find == 1) {
                each_Seller.add(product.getSeller());
                product.getSeller().getSellList().products_list.add(product);
            }

        }
        for (Seller seller : each_Seller) {
            seller.getSellList().setDate(time);
            seller.getSellList().setBuyerName(useraccount.getBuyer().getSame().getName());
            int overAll = 0;
            for (Product money : seller.getSellList().products_list) {
                overAll += money.getPrice();
            }
            seller.getSellList().setPrice(overAll);
            seller.getSame().setMoneyInStock(overAll);

            seller.getSellList().setTransmission("4 to 7 days from the recipe's date");

            seller.list.add(seller.getSellList());
            seller.listMaker();
        }
    }


    public static void addProduct(String name, String brand, String price, String money, String info
            , String category, String type,String[]info2) throws AccessAllowance {


        String categoryType = category;


        if (categoryType.equals("digital products")) {
            categoryType = type;

            if (categoryType.equals("mobile")) {
                mobile phone = new mobile();
                phone.setSIM_num(Integer.parseInt(info2[info2.length-2]));
                phone.setCameraQuantity(info2[info2.length-1]);
                productMainInfo(phone, name, brand, price, info, money, info2);

            } else if (categoryType.equals("lap top")) {
                laptop lapTop = new laptop();
                lapTop.setProcessor_Model(info2[info2.length-2]);
                lapTop.setFor_Gaming(Boolean.parseBoolean(info2[info2.length-1]));

                productMainInfo(lapTop, name, brand, price, info, money, info2);

            } else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("outfits")) {
            // print("dressing 1/shoes 2");

            categoryType = type;

            if (categoryType.equals("dressing")) {
                dressing dress = new dressing();
                dress.setSize(info2[info2.length-2]);
                dress.setModel(DressModel.valueOf(info2[info2.length-1]));

                productMainInfo(dress, name, brand, price, info, money, info2);

            } else if (categoryType.equals("shoes")) {
                shoes Shoes = new shoes();
                Shoes.setSize(Integer.parseInt(info2[info2.length-2]));
                Shoes.setModel(ShoesModel.valueOf(info2[info2.length-1]));

                productMainInfo(Shoes, name, brand, price, info, money, info2);

            } else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("house products")) {
            //print("television 1/refrigerator 2");
            categoryType = type;

            if (categoryType.equals("television")) {
                television TV = new television();

                TV.setPic_Quality(info2[info2.length-2]);

                TV.setWindows_Size(Integer.parseInt(info2[info2.length-1]));


                productMainInfo(TV, name, brand, price, info, money, info2);

            } else if (categoryType.equals("refrigerator")) {
                refrigator Ref = new refrigator();


                Ref.setStorage(Integer.parseInt(info2[info2.length-3]));

                Ref.setModel(info2[info2.length-2]);
;

                Ref.setHaving_Freezer(Boolean.parseBoolean(info2[info2.length-1]));


            } else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("snacks")) {
            snacks snack = new snacks();


            //print("producing date: ");
            String date = info2[info2.length-2];
            boolean check = checkDateFormat(date);
            if (!check)
                throw new wrongInputType("wrong date type: please enter it yy/mm/dd");

            snack.setProducing_date(date);

            //print("expiring date: ");
            date = info2[info2.length-1];
            check = checkDateFormat(date);
            if (!check)
                throw new wrongInputType("wrong date type: please enter it yy/mm/dd");
            snack.setExpiring_date(date);

            productMainInfo(snack, name, brand, price, info, money, info2);

        } else
            wrongOrder("wrong category");

    }


    public static void productMainInfo(Product object, String name, String brand, String price, String info, String money
            , String[] info2)
    {
        //taking products main info for adding a product

        // print("name: ");
        String check1 = name;
        if (checkInfo(check1))
            throw new wrongInputType("wrong input type !");

        object.setName(check1);

        //print("brand: ");
        check1 = brand;
        if (checkInfo(check1))
            throw new wrongInputType("wrong input type !");
        object.setBrand(check1);

        //print("price: ");
        int check = Integer.parseInt(price);
        object.setPrice(check);

        object.setSeller(useraccount.getSeller());

        //print("more info: ");
        object.setInfo(info);

        //print("in stock: ");
        check = Integer.parseInt(money);
        object.setInStock(check);

        mainInfo2(object ,info2);


    }

    public static void mainInfo2(Product object, String[] info2) {
        if (object instanceof digitalProduct) {
            //if (order.equals("ram space"))
                ((digitalProduct) object).setRam_space(Integer.parseInt(info2[0]));

            //if (order.equals("memory"))
                ((digitalProduct) object).setMemory(Integer.parseInt(info2[1]));

            //if (order.equals("operating system")) {

                if (checkInfo(info2[2]))
                    return;
                ((digitalProduct) object).setOperating_System(info2[3]);
            //if (order.equals("resolution")) {
            if (checkInfo(info2[3]))
                return;
            ((digitalProduct) object).setResolution(info2[3]);
        } else if (object instanceof outfit) {

          //  if (order.equals("produced"))
                if (checkInfo(info2[0]))
                    return;

                ((outfit) object).setMade_In(info2[0]);


                if (checkInfo(info2[1]))
                    return;
                ((outfit) object).setMaterial(info2[1]);

        } else if (object instanceof houseProducts) {
           // if (order.equals("energy usage")) {

                ((houseProducts) object).setEnergy_Usage(Integer.parseInt(info2[0]));


            //if (order.equals("guarantee")) {
                ((houseProducts) object).setGarentie(Boolean.parseBoolean(info2[1]));
            //}

        }

        String message ="the product earmark is:" + Integer.toString(object.getEarmark());
        JOptionPane.showInputDialog(message);

        productArrayList.add(object);
        useraccount.getSeller().productList.add(object);
        useraccount.getSeller().setAdd_product(useraccount.getSeller().getAdd_product() - 1);
        if (object instanceof digitalProduct)
            ((digitalProduct) object).guaranteeCalculation();
        if (object instanceof refrigator)
            ((refrigator) object).guaranteeCalculation();
        if (object instanceof television)
            ((television) object).guaranteeCalculation();

    }
     /* public static void SellerChangeInfo()
    {
        System.out.println("what do you wan to change?" +
                "password 2 /name 3/family name 4 /email 5/money in stock 6/phone number 7/workshop 8/institute 9/factory 10 " +
                "after choosing your order please enter the new info");
        Integer order ;

        Scanner getOrder = new Scanner(System.in);
        order = checkIntException();
        if (order==null)
            return;

        if(order<1 || order>=10) {
            wrongOrder("wrong order");
            return;
        }

        if(order>=2 && order<=7) {
            //changeInformation(order);
            return;
        }

        getOrder.nextLine();
        String change=getOrder.nextLine();
        if (order==8)
            useraccount.getSeller().setWorkShopName(change);
        else if (order==9)
            useraccount.getSeller().setInstituteName(change);
        else
            useraccount.getSeller().setFactoryName(change);

    }

    */

    public static void AskAdd()
    {
        project.useraccount.getSeller().requests.add(Request.CHANGE);
        Adminn.getAdmin().permission.add(useraccount);
    }
    public static void AskChange()
    {
        project.useraccount.getSeller().requests.add(Request.ADD);
        Adminn.getAdmin().permission.add(useraccount);
    }
    public static void AskDelete()
    {
        useraccount.getSeller().requests.add(Request.DELETE);
        Adminn.getAdmin().permission.add(useraccount);
    }
}


