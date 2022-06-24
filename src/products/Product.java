package products;

import account.making.*;
import random.works.*;

import java.io.Serializable;
import java.util.ArrayList;
import products.digital.*;
import products.house.*;
import products.outfit.*;
import products.snacks.*;
import saleing.Sale;

abstract public class Product implements Comparable, Serializable
{
    private static int earmarkMaker=400000;
    private String name;
    private String brand;
    private int price;
    private Seller seller;
    private int inStock=0;
    private int earmark;
    private String category_model;
    private double price_with_discount=-10;

    private String address;
    private String address2;//for saving it in category as well
    private boolean deleted_product=false;

    private String info;
    private int star=0;

    public ArrayList<Comments> comments=new ArrayList<Comments>();
    public ArrayList<Rate> rate=new ArrayList<Rate>();
    public ArrayList<Sale>sales=new ArrayList<Sale>();


    public abstract void readingFromFile(String [] info);

     //========for saving and writing into files===================================
     abstract public String myToString2();
     abstract public String myToString3();
     public String myToString()
     {
         String string=name+"\n"+brand+"\n"+price+"\n"+inStock+"\n"+earmark+"\n"+category_model+"\n"+info+"\n";
         return string;
     }

     public String addressesAndStar()
     {
         return address+"\n"+address2+"\n"+deleted_product+"\n";
     }

     //================================================================================
     @Override
     public int compareTo(Object object)
     {
         int comparing=this.category_model.compareTo(((Product)object).category_model);
         if (comparing > 0)
             return 1;
         else if (comparing < 0)
             return -1;
         else
         {
             comparing=this.name.compareTo(((Product) object).name);

             if (comparing > 0)
                 return 1;
             else if (comparing < 0)
                 return -1;

             else
             {
                 if (this instanceof digitalProduct)
                 {
                     comparing=((digitalProduct) this).getMemory()-((digitalProduct)object).getMemory();

                     if (comparing > 0)
                         return 1;
                     else if (comparing < 0)
                         return -1;
                 }
                 else if(this instanceof houseProducts)
                 {
                     comparing=((houseProducts) this).getEnergy_Usage()-((houseProducts)object).getEnergy_Usage();

                     if (comparing > 0)
                         return 1;
                     else if(comparing < 0)
                         return -1;
                 }
                 else if (this instanceof outfit)
                 {
                     if (this instanceof dressing)
                     {
                         comparing=((dressing) this).getModel().compareTo(((dressing)object).getModel());

                         if (comparing > 0)
                             return 1;
                         else if(comparing < 0)
                             return -1;
                     }
                     else if(this instanceof shoes)
                     {
                         comparing=((shoes) this).getSize()-((shoes)object).getSize();

                         if (comparing > 0)
                             return 1;
                         else if(comparing < 0)
                             return -1;
                     }
                 }
                 else if (this instanceof snacks)
                 {
                     comparing= ((snacks) this).getExpiring_date().compareTo(((snacks)object).getExpiring_date());
                     if (comparing > 0)
                         return 1;
                     else if (comparing < 0)
                         return -1;
                 }
                 else {

                     comparing = this.star - ((Product) object).star;

                     if (comparing > 0)
                         return 1;
                     else if (comparing < 0)
                         return -1;
                     else {
                         comparing = this.price - ((Product) object).price;

                         if (comparing > 0)
                             return 1;
                         else if (comparing < 0)
                             return -1;
                         else {
                             comparing = this.inStock - ((Product) object).inStock;

                             if (comparing > 0)
                                 return 1;
                             else if (comparing < 0)
                                 return -1;
                             else
                                 return 0;
                         }
                     }
                 }
             }
         }
         return 0;
     }


    @Override
    public String toString() {
        return "name: "+name+"\nearmark: "+earmark+"\nbrand: "+brand+"\nseller: "+seller.getSame().getName();
    }



    public void ratingAmount()
    {
        int counter=0;
        int tempt=0;
        for (Rate rates : rate)
        {
            tempt+=rates.getRate();
            ++counter;
        }
        if (counter!=0) {
            tempt /= counter;
        }
        this.star= tempt;
    }


    //==========================================mySQL ==========================

    public String mySQLToString(String value)
    {
        return  "' "+value+" ' ,";
    }


    //===============================getter setter

    public String getCategory_model() {
        return category_model;
    }

    public void setCategory_model(String category_model) {
        this.category_model = category_model;
    }

    public int getEarmark() {
        return earmark;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }

    public int getInStock() {
        return inStock;
    }

    public String getInfo() {
        return info;
    }

    public int getStar() {
        return star;
    }


    public static int getEarmarkMaker() {
        return earmarkMaker;
    }

    public static void setEarmarkMaker(int earmarkMaker) {
        Product.earmarkMaker = earmarkMaker;
    }


    public void setEarmark(int earmark) {
        this.earmark = earmark;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(Sale sale) {
        this.sales.add(sale);
    }

    public double getPrice_with_discount() {
        return price_with_discount;
    }

    public void setPrice_with_discount(double price_with_discount) {
        this.price_with_discount = price_with_discount;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDeleted_product() {
        return deleted_product;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeleted_product(boolean deleted_product) {
        this.deleted_product = deleted_product;
    }

}
