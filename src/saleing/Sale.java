package saleing;

import products.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Sale implements Serializable
{
    private double discount=0;
    private LocalDate date;
    private int capacity;
    private String code;
    private Product product;

    public Sale(double discount , LocalDate date , int capacity,Product product)
    {
        this.discount=discount;
        this.capacity=capacity;
        this.date=date;
        this.product=product;
    }

    @Override
    public String toString()
    {
        return "code: "+code+"\ndiscount: "+discount+" %"+"\nexpiring date: "+date;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
//LocalDate date = LocalDate.of(1988,10,23);