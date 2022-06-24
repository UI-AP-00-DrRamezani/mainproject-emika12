package products.digital;
import account.making.Admin;
import products.IGuaranteeValue;
import products.Product;
import saleing.IDiscountFeature;
import saleing.Sale;

import java.time.LocalDate;
import java.util.Date;


abstract public class digitalProduct extends Product implements IGuaranteeValue, IDiscountFeature
{
    private int ram_space;
    private int memory;
    private String operating_System;
    private String resolution;
    private int guaranteeTime;
    private Double guaranteeValue;


    public void guaranteeCalculation()
    {
        this.setGuaranteeTime(calculateGuarantee());
        this.setGuaranteeValue(calculateGuaranteeValue());
    }

    public String toString2()
    {
        return "ram: "+ram_space+"\nmemory: "+memory+"\noperating system: "+operating_System+"\nresolution: "+resolution
                +"\nguarantee value: "+guaranteeValue;
    }

    public String myToString2()
    {
        return ram_space+"\n"+memory+"\n"+operating_System+"\n"+resolution+"\n"+guaranteeTime+"\n"+guaranteeValue+"\n";
    }

    @Override
    public Double calculateGuaranteeValue()
    {
        return this.getPrice()*(0.4);
    }

    @Override
    public int calculateGuarantee()
    {
        return (ram_space*5)+memory;
    }


    public abstract double discountAmount();
    public abstract String partOfDiscountCode();
    public abstract double discountAmount2();



    @Override
    public Sale addDiscount(int capacity, LocalDate localDate)
    {
        String code=makeDiscountCode();
        Sale sale =new Sale(discountAmount() ,localDate , capacity,this);
        sale.setCode(code);

        setSales(sale);
        Admin.sales.add(sale);
        return sale;
    }

    @Override
    public  String makeDiscountCode()
    {
        int numbers=(int)(Math.random() *10000);
        String number2=String.valueOf(numbers);
        String code= partOfDiscountCode()+number2;

        return code;
    }

    @Override
    public Sale aDDDiscountNoCode(LocalDate localDate )
    {
        Sale sale =new Sale(discountAmount2(),localDate,-20,this);
        sale.setCode("ALL");
        setSales(sale);
        Admin.sales.add(sale);

        return sale;
    }


    public int getRam_space() {
        return ram_space;
    }

    public int getMemory() {
        return memory;
    }

    public String getOperating_System() {
        return operating_System;
    }

    public String getResolution() {
        return resolution;
    }

    public void setRam_space(int ram_space) {
        this.ram_space = ram_space;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setOperating_System(String operating_System) {
        this.operating_System = operating_System;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getGuaranteeTime() {
        return guaranteeTime;
    }

    public Double getGuaranteeValue() {
        return guaranteeValue;
    }

    public void setGuaranteeTime(int guaranteeTime) {
        this.guaranteeTime = guaranteeTime;
    }

    public void setGuaranteeValue(Double guaranteeValue) {
        this.guaranteeValue = guaranteeValue;
    }
}

