package first;

import account.making.*;
import allof.exceptions.noUser;
import products.Product;
import products.digital.digitalProduct;
import products.digital.laptop;
import products.digital.mobile;
import products.house.houseProducts;
import products.house.refrigator;
import products.house.television;
import products.outfit.outfit;
import products.snacks.snacks;
import random.works.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static project.first.AllExceptions.*;
import static project.first.project.*;


public class ProductPart
{

    public static void products()
    {
        Product[]products=new Product[project.productArrayList.size()];
        int i=0;


        for (Product a:project.productArrayList)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        Scanner sc=new Scanner(System.in);

        for (int s=0;s<products.length;++s) {
            print("product name:" + products[s].getName());
            print("price:" + products[s].getPrice());
            print("press INFO then  " + (s + 1) + " for more information...");
            print("-------------------------------------------------------------");
        }

        print("for filtering the products:no filter 0/digital products 1/outfits 2/house products 3" +
                "/snacks 4/most expensive 5/less expensive 6");

        print("=================");
        print("end");

        String order=sc.nextLine();

        if (order.trim().equals("end"))
            return;

        else if(order.trim().equals("INFO"))
        {
            Integer product_number = checkIntException();
            if (product_number==null)
                return;

            eachProduct(products[product_number-1]);
        }

        else if(order.trim().equals("filtering"))
        {
            Integer num= checkIntException();
            if (num==null)
                return;

            if (num==0)
                showEachProductInfo(products);

            else if(num==1)
                digitalProductFilter();

            else if(num==2)
                outfitFilter();

            else if(num==3)
                houseProductsFilter();
            else if(num==4)
                snackFilter();

            else if(num==5)
                mostExpensiveFilter(products);

            else if(num==6)
                lessExpensiveFilter(products);

            else
                wrongOrder("wrong order:order must be between 0 to 6");
        }
        else
            wrongOrder("wrong order : order must be INFO/filtering/end");

    }

    //filters---
    public static void digitalProductFilter()
    {

        Product []products=new Product[digital_Products.products.size()];
        int i=0;


        for (Product a:digital_Products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        showEachProductInfo(products);

    }

    public static void outfitFilter()
    {
        Product []products=new Product[outfit_Products.products.size()];
        int i=0;

        for (Product a:outfit_Products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        showEachProductInfo(products);
    }

    public static void houseProductsFilter()
    {

        Product []products=new Product[house_products.products.size()];
        int i=0;

        for (Product a:house_products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);

        showEachProductInfo(products);
    }

    public static void snackFilter()
    {
        Product []products=new Product[snack_products.products.size()];
        int i=0;

        for (Product a:snack_products.products)
        {
            products[i]=a;
            ++i;
        }
        Arrays.sort(products);
        showEachProductInfo(products);
    }

    public static void mostExpensiveFilter(Product[] products1)
    {

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
        showEachProductInfo(products1);
    }

    public static void lessExpensiveFilter(Product[] products1)
    {

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
        showEachProductInfo(products1);
    }
    //----
    public static void showEachProductInfo(Product [] products)
    {
        Scanner sc=new Scanner(System.in);
        int page=0;
        for (int s=0;s<products.length;++s)
        {

            print("product name:"+products[s].getName());
            print("price:"+products[s].getPrice());
            print("press INFO then  "+(s+1)+" for more information...");
            print("-------------------------------------------------------------");

            if(page==2)
            {
                String nextPage;
                do
                {
                    print("****=========NEXT========****");
                    nextPage=sc.nextLine();
                    if (!(nextPage.trim().equals("NEXT")) && !(nextPage.trim().equals("INFO")))
                        wrongOrder("error: please choose INFO/NEXT");

                }while (!(nextPage.trim().equals("NEXT")) && !(nextPage.trim().equals("INFO")));

                if(nextPage.trim().equals("INFO"))
                {
                    Scanner scanner=new Scanner(System.in);
                    try {
                        eachProduct(products[scanner.nextInt() - 1]);
                    }
                    catch (InputMismatchException error)
                    {
                        print(error.getMessage());
                    }
                    finally {
                        return;
                    }
                }
                page=-1;
            }
            ++page;
        }
        print("most expensive 1/less expensive 2/no filter 3/end");


        String order=sc.nextLine();

        if(order.trim().equals("INFO"))
        {
            Scanner scanner=new Scanner(System.in);
            try {
                eachProduct(products[scanner.nextInt() - 1]);
            }
            catch (InputMismatchException error)
            {
                print(error.getMessage());
                return;
            }
        }

        if (order.equals("1"))
            mostExpensiveFilter(products);
        else if (order.equals("2"))
            lessExpensiveFilter(products);
        else if (order.equals("3"))
            products();
        else if (! order.equals("end"))
            wrongOrder("wrong number!");
    }

    public static void eachProduct (Product products) throws InputMismatchException, noUser
    {

        showEachProduct(products);
        print("-------------------------------------------------------------");
        print("Comments: \n-------------------------------------------------------------");

        for (Comments a:products.comments)
        {
            if(a.getState()== State.ACCEPTED)
            {
                print("user " + a.getBuyer_Comment()+ ":"+"having bought the product: "+a.isHavingBought());
                print(a.getComment());
                print("-------------------------------------------------------------");
            }
        }

        print("Rating: ");
        print("-------------------------------------------------------------");

        int average=0;
        for (Rate a:products.rate)
        {
            average+=a.getRate();
            print(a.getBuyer().getSame().getName()+":"+a.getRate());
        }

        if(products.rate.size()!=0)
            products.setStar(average/products.rate.size());
        else
            products.setStar(0);

        print("average: "+products.getStar());

        String order;

        do {
            print("____________");
            print("BUY");
            print("ADD COMMENT");
            print("BACK");
            print("END");

            Scanner sc = new Scanner(System.in);
            order = sc.nextLine();


            if (order.trim().equals("BUY")) {

                print("in stock:"+(products.getInStock()-1));
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
            }
            else if (order.trim().equals("ADD COMMENT")) {
                print("text:");
                Scanner text=new Scanner(System.in);
                Comments comment=new Comments();

                comment.setComment(text.nextLine());
                if(useraccount==null)
                    comment.setBuyer_Comment("Guest");
                else
                    comment.setBuyer_Comment(useraccount.getName());
                comment.setProduct(products);

                if(useraccount==null)
                    comment.setHavingBought(false);
                else
                {
                    int find=0;
                    for (BuyList buyList: useraccount.getBuyer().list)
                        for(Product product: useraccount.getBuyer().getBuyList().products_List)
                        {
                            if(find==1)
                                continue;

                            if(product==products)
                            {
                                find=1;
                                comment.setHavingBought(true);
                            }
                        }
                    if(find==0)
                        comment.setHavingBought(false);
                }

                Adminn.getAdmin().comments_Permission.add(comment);
                products.comments.add(comment);

            } else if (order.trim().equals("BACK")) {
                products();
            }else if(order.trim().equals("END"))
                return;
            else
                wrongOrder("wrong order");
        }while (!(order.trim().equals("END")) && !(order.trim().equals("BACK")));
    }


    public static void showEachProduct(Product products)
    {
        print(products.toString());
        print("more information about it: ");
        if (products instanceof digitalProduct)
        {
            print(((digitalProduct) products).toString2());

            if(products instanceof mobile)
            {
                print("SIM number: "+((mobile) products).getSIM_num());
                print("camera quality: "+((mobile) products).getCameraQuantity());
            }
            else if (products instanceof laptop)
            {
                print("processor model: "+((laptop) products).getProcessor_Model());
                print("is it for gaming?"+((laptop) products).getFor_Gaming());
            }


        }
        else if (products instanceof houseProducts)
        {
            print("energy usage:"+((houseProducts) products).getEnergy_Usage());
            print("having gaurentee:"+((houseProducts) products).getGarentie());

            if (products instanceof refrigator)
                print(((refrigator) products).toString2());

            else if(products instanceof television)
                print(((television) products).toString2());

        }
        else if (products instanceof outfit)
            print(((outfit) products).toString2());

        else if(products instanceof snacks)
            print(((snacks) products).toString2());

        if (products instanceof houseProducts)
        {
            print("guarantee:" +((houseProducts) products).getGuaranteeValue()+"   "
                    +((houseProducts) products).getGuaranteeTime());
        }
        if (products instanceof digitalProduct)
        {

            print("guarantee:" +((digitalProduct) products).getGuaranteeValue()+"   "
                    +((digitalProduct) products).getGuaranteeTime());
        }

        print("-------");
        print(products.getInfo());
        print("-------");

        print("price: "+products.getPrice());
        print("in stock: "+products.getInStock());
    }

}
