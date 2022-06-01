package first;

import account.making.*;
import allof.exceptions.*;
import files.Savefiles;
import products.Product;
import products.digital.digitalProduct;
import products.digital.laptop;
import products.digital.mobile;
import products.house.houseProducts;
import products.house.refrigator;
import products.house.television;
import products.outfit.*;
import products.snacks.snacks;
import saleing.Sale;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static project.first.AllExceptions.*;
import static project.first.ProductPart.showEachProduct;
import static project.first.checking.checkInfo;
import static project.first.project.*;

public class SellerAccess
{
    //-------
    public static void sellerAccess()
    {
        Scanner sc = new Scanner(System.in);
        print("your account information:");
        print(useraccount.toString());
        print(useraccount.getSeller().toString());

        Integer number=9;
        while(number!=0)
        {

            print("============================");
            print("change info 1\nask to change a product 2\nask to add a product 3\nask to delete a product 4\nadd pro 5\ndelete pro 6" +
                    "\nchange pro 7\nselling history 8\nown product list 9\nmake discount 10\nend 0");


            number=checkIntException();
            if (number==null)
                number=20;

            if(number==2 ||number==3||number==4)
                Adminn.getAdmin().permission.add(useraccount);
            whatSellerAccess(number);
        }

    }
    public static void whatSellerAccess(int number)
    {
        switch (number)
        {
            case 0:
                break;
            case 1:
                SellerChangeInfo();
                break;
            case 2:
                useraccount.getSeller().requests.add(Request.CHANGE);
                break;
            case 3:
                useraccount.getSeller().requests.add(Request.ADD);
                break;
            case 4:
                useraccount.getSeller().requests.add(Request.DELETE);
                break;
            case 5:
                try {
                    addProduct();
                }
                catch (IllegalArgumentException error) {
                    IllegalArgumentException error2 = new IllegalArgumentException("wrong input");
                    print(error2.getMessage());
                }catch (AccessAllowance ac){}
                break;
            case 6:
                try {
                    deleteProduct();
                }catch (AccessAllowance a){}catch (notFound e){}
                break;
            case 7:
                try {
                    changeProductInfo();
                }catch (AccessAllowance e){}catch (notFound e){}
                break;
            case 8:
                showSellList();
                break;
            case 9:
                showOwnProducts();
                break;
            case 10:
                try {
                    makeDiscount();
                }catch (notFound e){}
                break;

            default:
                wrongOrder("wrong order : " +
                        "you should enter a number between 0 to 10");
        }
    }

    public static void makeDiscount() throws notFound
    {
        Scanner sc=new Scanner(System.in);
        showOwnProducts();
        print("enter the earmark of the product: ");
        Integer earmark=checkIntException();
        if (earmark==null)
            return;

        Product the_product=null;
        for (Product product: useraccount.getSeller().productList)
        {
            if (product.getEarmark()==earmark) {
                if (product instanceof digitalProduct || product instanceof outfit
                || product instanceof snacks)
                   the_product = product;
                else {
                    wrongOrder("sorry but this product can not have a discount");
                    return;
                }
            }
        }
        if (the_product==null)
            notFound("wrong earmark: the product not found");

        else
        {
            LocalDate date=takeDate();
            if (date==null)
                return;

            print("global discount 1 /special discount 2");
            Integer order=checkIntException();
            if (order==null)
                return;

            Sale sale;
            if (order == 1) {
                if (the_product instanceof digitalProduct)
                    sale=((digitalProduct) the_product).aDDDiscountNoCode(date);
                else  if (the_product instanceof  outfit)
                    sale=((outfit) the_product).aDDDiscountNoCode(date);
                else
                    sale=((snacks) the_product).aDDDiscountNoCode(date);
                print("added successfully");
                print("the discount info: "+sale.toString());
            }
            else if(order==2)
            {
                print("capacity: ");
                Integer capacity=checkIntException();
                if (capacity==null)
                    return;

                if (the_product instanceof digitalProduct)
                     sale=((digitalProduct) the_product).addDiscount(capacity,date);
                else if (the_product instanceof outfit)
                    sale=((outfit) the_product).addDiscount(capacity,date);
                else
                    sale=((snacks) the_product).addDiscount(capacity,date);
                print("added successfully");
                print("the discount info: "+sale.toString());
            }
            else
                wrongOrder("wrong order");
        }
    }

    public static LocalDate takeDate()
    {

        LocalDate date=null;
        Scanner sc=new Scanner(System.in);
        print("please enter the expiring date: ");

        String userInput=sc.nextLine();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            date = LocalDate.parse(userInput,dateFormat);

        }
        catch (DateTimeParseException error)
        {
            print("wrong date format");
        }
        finally {
            return date;
        }

    }

    public static void showSellList()
    {
        for(SellList sellList: useraccount.getSeller().list)
        {
            print("factor number: "+sellList.getFactorNum());
            print("Date: "+sellList.getDate());
            print("transmission: "+sellList.getTransmission());
            print("buyer name: "+sellList.getBuyerName());
            print("price: "+sellList.getPrice());

            print("products:");
            for (Product product:sellList.products_list)
            {
                print("name: "+product.getName()+"   earmark: "+product.getEarmark());
            }

        }
    }

    public static void showOwnProducts()
    {
        for(Product product: useraccount.getSeller().productList)
        {
            showEachProduct(product);
            print("***========================================***");
        }
    }

    public static void deleteProduct()throws AccessAllowance,notFound {
        if(useraccount.getSeller().getDelete_Product()<=0)
            accessDenied("you have not been allowed to delete a product");


        print("please enter the earmark of the product : ");
        Scanner sc = new Scanner(System.in);

        Integer earmark;

        earmark = checkIntException();
        if (earmark==null)
            return;


        int i = 0; //for finding the index of that product so we can delete it
        int finding = 10;
        for (Product find : useraccount.getSeller().productList) {
            if(finding==0)
                continue;

            if (earmark == find.getEarmark())
                finding = 0;
            ++i;
        }

        if (finding == 10)
            notFound("earmark was wrong");

        else {
            finding=10;
            useraccount.getSeller().productList.get(i-1).setDeleted_product(true);
            try {//saving it before removing it from arrays
                Savefiles.WriteSeller(useraccount);
            }catch (IOException e){}
            useraccount.getSeller().productList.remove(i-1);
            i=0;
            for (Product product:productArrayList) {
                if (finding == 0)
                    continue;

                if (product.getEarmark() == earmark)
                    finding = 0;
                ++i;
            }
            productArrayList.remove(i-1);
            useraccount.getSeller().setDelete_Product(useraccount.getSeller().getDelete_Product()-1);
            print("removed successfully");
        }
    }


    public static void changeProductInfo() throws AccessAllowance,notFound{

        if(useraccount.getSeller().getChange_Product()<=0)
        {
            accessDenied("you have not been allowed to change a product");
            return;
        }

        print("please enter the earmark of the product: ");
        Scanner scc = new Scanner(System.in);

        Integer earmark;
        earmark = checkIntException();
        if (earmark==null)
            return;


        Product product=null;
        for (Product find : useraccount.getSeller().productList) {
            if (earmark == find.getEarmark()) {
                product = find;
            }
        }

        String order="start";

        if (product == null)
            notFound("earmark was wrong");

        else {
            while (!(order.equals("end"))) {

                Scanner sc = new Scanner(System.in);
                print("please enter the name of what you want to change and then enter the new info after that:" +
                        "(when the action of changings is finished please enter end) ");

                order = sc.nextLine();

                findChange(product,order);
                useraccount.getSeller().setChange_Product(useraccount.getSeller().getChange_Product()-1);
            }
        }
    }

    public static void makeListForSeller(double payMoney, String time)
    {


        ArrayList<Seller> each_Seller=new ArrayList<Seller>();
        int find=1;

        //find each sellers and separate them to add their products into their list
        for(Product product: useraccount.getBuyer().getBuyList().products_List)
        {
            for (Seller find_Seller:each_Seller)
            {
                if(product.getSeller().getSame().getId().equals(find_Seller.getSame().getId()))
                {
                    find_Seller.getSellList().products_list.add(product);
                    find=0;
                }
            }
            if(find==1)
            {
                each_Seller.add(product.getSeller());
                product.getSeller().getSellList().products_list.add(product);
            }

        }
        for (Seller seller:each_Seller)
        {
            seller.getSellList().setDate(time);
            seller.getSellList().setBuyerName(useraccount.getBuyer().getSame().getName());
            int overAll=0;
            for (Product money:seller.getSellList().products_list)
            {
                overAll+=money.getPrice();
            }
            seller.getSellList().setPrice(overAll);
            seller.getSame().setMoneyInStock(overAll);

            seller.getSellList().setTransmission("4 to 7 days from the recipe's date");

            seller.list.add(seller.getSellList());
            seller.listMaker();
        }
    }


    public static void findChange(Product product,String order)
    {
        Scanner sc=new Scanner(System.in);

        if (order.equals("name")) {
            String name=sc.nextLine();
            if(checkInfo(name))
                return;

            product.setName(name);
        }
        else if (order.equals("brand")) {
            String name=sc.nextLine();
            if(checkInfo(name))
                return;

            product.setBrand(name);
        }

        else if (order.equals("price")) {
            Integer check=checkIntException();
            if (check==null)
                return;
            product.setPrice(check);
            if (product instanceof digitalProduct)
                ((digitalProduct) product).guaranteeCalculation();
            else if (product instanceof television)
                ((television) product).guaranteeCalculation();
            else if (product instanceof refrigator)
                ((refrigator) product).guaranteeCalculation();

        }
        else if (order.equals("in stock")) {

            Integer check=checkIntException();
            if (check==null)
                return;

            product.setInStock(check);
        }

        else if (product instanceof digitalProduct) {
            if (order.equals("ram space")) {
                Integer check=checkIntException();
                if (check==null)
                    return;
                ((digitalProduct) product).setRam_space(check);
            }
            else if (order.equals(("memory"))) {
                Integer check=checkIntException();
                if (check==null)
                    return;

                ((digitalProduct) product).setMemory(check);
            }

            else if (order.equals("operating system"))
                ((digitalProduct) product).setOperating_System(sc.nextLine());

            else if (order.equals("resolution"))
                ((digitalProduct) product).setResolution(sc.nextLine());

            else if (product instanceof mobile) {
                if (order.equals("sim numbers")) {
                    Integer check=checkIntException();
                    if (check==null)
                        return;
                    ((mobile) product).setSIM_num(check);
                }
                else if (order.equals("camera quality"))
                    ((mobile) product).setCameraQuantity(sc.nextLine());
                else {
                    print("wrong order");
                    return;
                }
            } else if (product instanceof laptop) {
                if (order.equals("processor model"))
                    ((laptop) product).setProcessor_Model(sc.nextLine());
                else if (order.equals("for gaming")) {
                    Boolean check=YesNoException();
                    if (check==null)
                        return;
                    ((laptop) product).setFor_Gaming(check);
                }
                else {
                    wrongOrder("wrong order");
                    return;
                }
                ((digitalProduct)product).guaranteeCalculation();
            }
        } else if (product instanceof outfit) {
            if (order.equals("made in"))
                ((outfit) product).setMade_In(sc.nextLine());
            else if (order.equals("material"))
                ((outfit) product).setMaterial(sc.nextLine());

            else if (product instanceof dressing) {
                if (order.equals("size"))
                    ((dressing) product).setSize(sc.nextLine());
                else if (order.equals("model")) {
                   try {
                       ((dressing) product).setModel(DressModel.valueOf(sc.nextLine()));
                   }
                   catch (IllegalArgumentException error)
                   {
                       IllegalArgumentException error2=new IllegalArgumentException("wrong input");
                       print(error2.getMessage());
                       return;
                   }
                }
                else {
                    wrongOrder("wrong order");
                    return;
                }

            } else if (product instanceof shoes) {
                if (order.equals("size")) {
                    Integer check=checkIntException();
                    if (check==null)
                        return;

                    ((shoes) product).setSize(check);
                }
                else if (order.equals("model")) {
                 try {
                     ((shoes) product).setModel(ShoesModel.valueOf(sc.nextLine()));
                 }
                 catch (IllegalArgumentException error)
                 {
                     IllegalArgumentException error2=new IllegalArgumentException("wrong input");
                     print(error2.getMessage());
                     return;
                 }
                }
                else {
                    wrongOrder("wrong order");
                    return;
                }
            }

        } else if (product instanceof houseProducts) {
            if (order.equals("energy")) {
                Integer check=checkIntException();
                if (check==null)
                    return;
                ((houseProducts) product).setEnergy_Usage(check);
            }
            else if (order.equals("guarantee")) {
                Boolean check=YesNoException();
                if (check==null)
                    return;
                ((houseProducts) product).setGarentie(check);
            }
            else if (product instanceof television) {
                if (order.equals("picture quality"))
                    ((television) product).setPic_Quality(sc.nextLine());
                else if (order.equals("windows size")) {
                    Integer check=checkIntException();
                    if (check==null)
                        return;
                    ((television) product).setWindows_Size(check);
                }
                else {
                    wrongOrder("wrong order");
                    return;
                }
                ((television)product).guaranteeCalculation();

            } else if (product instanceof refrigator) {
                if (order.equals("storage")) {
                    Integer check=checkIntException();
                    if (check==null)
                        return;
                    ((refrigator) product).setStorage(check);
                }
                else if (order.equals("model"))
                    ((refrigator) product).setModel(sc.nextLine());
                else if (order.equals("having freezer")) {
                    Boolean check=YesNoException();
                    if (check==null)
                        return;
                    ((refrigator) product).setHaving_Freezer(check);
                }
                else {
                    wrongOrder("wrong order");
                    return;
                }
                ((refrigator)product).guaranteeCalculation();
            }
        } else if (product instanceof snacks) {
            if (order.equals("producing date")) {

                String date=sc.nextLine();
                boolean check=checkDateFormat(date);
                if (! check)
                    return;
                ((snacks) product).setProducing_date(date);
            }
            else if (order.equals("expiring date")) {

                String date=sc.nextLine();
                boolean check=checkDateFormat(date);
                if (! check)
                    return;

                ((snacks) product).setExpiring_date(date);
            }
            else {
                wrongOrder("wrong order");
                return;
            }
        }
        else if(order.equals("end"))
            return;

        else {
            wrongOrder("wrong order");
        }
    }


    public static void addProduct() throws AccessAllowance {

        if(useraccount.getSeller().getAdd_product()<=0)
        {
            print("you have not been allowed to add a product");
            return;
        }

        print("what sort of category you want to add?");
        Scanner sc = new Scanner(System.in);
        String categoryType = sc.nextLine();

        print("please fill in the blanks: ");

        if (categoryType.equals("digital products")) {
            print("mobile 1/laptop 2");
            categoryType = sc.nextLine();

            if (categoryType.equals("1")) {
                mobile phone = new mobile();

                print("SIM num: ");
                Integer check=checkIntException();
                if (check==null)
                    return;
                phone.setSIM_num(check);

                print("camera quality: ");
                phone.setCameraQuantity(sc.nextLine());

                productMainInfo(phone);

            } else if (categoryType.equals("2")) {
                laptop lapTop = new laptop();


                print("Processor model: ");
                lapTop.setProcessor_Model(sc.nextLine());
                print("is it for gaming?(true/false): ");
                Boolean check=YesNoException();
                if (check==null)
                    return;
                lapTop.setFor_Gaming(check);


                productMainInfo(lapTop);

            }
            else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("outfit")) {
            print("dressing 1/shoes 2");

            categoryType = sc.nextLine();

            if (categoryType.equals("1")) {
                dressing dress = new dressing();


                print("size: ");
                dress.setSize(sc.nextLine());

                print("model:");
                dress.setModel(DressModel.valueOf((sc.nextLine())));



                productMainInfo(dress);

            } else if (categoryType.equals("2")) {
                shoes Shoes = new shoes();


                print("size: ");
                Integer check=checkIntException();
                if (check==null)
                    return;
                Shoes.setSize(check);


                print("model:");
                Shoes.setModel(ShoesModel.valueOf((sc.nextLine())));



                productMainInfo(Shoes);

            }
            else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("house products")) {
            print("television 1/refrigerator 2");
            categoryType = sc.nextLine();

            if (categoryType.equals("1")) {
                television TV = new television();


                print("picture quality: ");
                TV.setPic_Quality(sc.nextLine());

                print("windows size: ");
                Integer check=checkIntException();
                if (check==null)
                    return;
                TV.setWindows_Size(check);



                productMainInfo(TV);

            } else if (categoryType.equals("2")) {
                refrigator Ref = new refrigator();


                print("storage: ");
                Integer check=checkIntException();
                if (check==null)
                    return;
                Ref.setStorage(check);

                print("model: ");

                Ref.setModel(sc.nextLine());

                print("does it have a freezer?(true/false): ");
                Boolean check2=YesNoException();
                if (check2==null)
                    return;
                Ref.setHaving_Freezer(check2);


                productMainInfo(Ref);

            }
            else {
                wrongOrder("wrong num");
            }
        } else if (categoryType.equals("snacks")) {
            snacks snack = new snacks();


            print("producing date: ");
            String date=sc.nextLine();
            boolean check=checkDateFormat(date);
            if (! check)
                return;
            snack.setProducing_date(date);

            print("expiring date: ");
            date=sc.nextLine();
            check=checkDateFormat(date);
            if (! check)
                return;
            snack.setExpiring_date(date);



            productMainInfo(snack);

        } else
            wrongOrder("wrong category");

    }


    public static void productMainInfo(Product object) {//taking products main info for adding a product
        Scanner sc = new Scanner(System.in);
        print("name: ");
         String check1=sc.nextLine();
        if (checkInfo(check1))
            return;

        object.setName(check1);

        print("brand: ");
        check1=sc.nextLine();
        if (checkInfo(check1))
            return;
        object.setBrand(check1);

        print("price: ");
        Integer check=checkIntException();
        if (check==null)
            return;
        object.setPrice(check);

        object.setSeller(useraccount.getSeller());

        print("more info: ");
        object.setInfo(sc.nextLine());

        print("in stock: ");
        check=checkIntException();
        if (check==null)
            return;
        object.setInStock(check);



        if (object instanceof digitalProduct) {

            print("ram space: ");
            check=checkIntException();
            if (check==null)
                return;
            ((digitalProduct) object).setRam_space(check);

            print("memory: ");
            check=checkIntException();
            if (check==null)
                return;
            ((digitalProduct) object).setMemory(check);

            print("operating system: ");
            check1=sc.nextLine();
            if (checkInfo(check1))
                return;
            ((digitalProduct) object).setOperating_System(check1);

            print("resolution: ");
            check1=sc.nextLine();
            if (checkInfo(check1))
                return;
            ((digitalProduct) object).setResolution(check1);
        } else if (object instanceof outfit) {

            print("produced: ");
            check1=sc.nextLine();
            if (checkInfo(check1))
                return;
            ((outfit) object).setMade_In(check1);

            print("material:");
            check1=sc.nextLine();
            if (checkInfo(check1))
                return;
            ((outfit) object).setMaterial(check1);
        } else if (object instanceof houseProducts) {
            print("energy usage: ");
            check=checkIntException();
            if (check==null)
                return;
            ((houseProducts) object).setEnergy_Usage(check);

            print("guarantee: ");
            Boolean check2=YesNoException();
            if (check==null)
                return;
            ((houseProducts) object).setGarentie(check2);

        }

        print("the product earmark is:");
        print(object.getEarmark());

        productArrayList.add(object);
        useraccount.getSeller().productList.add(object);
        useraccount.getSeller().setAdd_product(useraccount.getSeller().getAdd_product()-1);
        if (object instanceof digitalProduct)
            ((digitalProduct) object).guaranteeCalculation();
        if (object instanceof refrigator)
            ((refrigator) object).guaranteeCalculation();
        if (object instanceof television)
            ((television) object).guaranteeCalculation();


        print("added successfully");

    }


    public static void SellerChangeInfo()
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
            changeInformation(order);
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


}
