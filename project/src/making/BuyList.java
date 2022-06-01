package making;

import products.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class BuyList implements Serializable
{
    private static int FactorNum=0;
    private String Date;
    private double price;


    public ArrayList<Product> products_List=new ArrayList<Product>(); //ولی برای چاپش بیاد و فقط اسمش رو چاپ کنه

    private String buyerName;
    private String delivery;



    public static int getFactorNum() {
        return FactorNum;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getPrice() {
        return price;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
