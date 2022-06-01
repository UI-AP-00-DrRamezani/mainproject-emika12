package making;

import products.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class SellList implements Serializable
{
    private static int FactorNumMaker=0;
    private double price;
    private String Date;
    private int FactorNum=0;

    public ArrayList<Product> products_list=new ArrayList<Product>();

    private String buyerName;
    private String transmission;

    public SellList()
    {
        FactorNum=FactorNumMaker++;
    }

    public int getFactorNum() {
        return FactorNum;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getTransmission() {
        return transmission;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}


