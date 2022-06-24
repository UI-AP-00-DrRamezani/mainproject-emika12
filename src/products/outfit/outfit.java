package products.outfit;

import account.making.Admin;
import products.Product;
import saleing.IDiscountFeature;
import saleing.Sale;

import java.time.LocalDate;
import java.util.Date;

abstract public class outfit extends Product implements IDiscountFeature
{
    private String made_In;
    private String material;


    public outfit()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
    }

    public String myToString2()
    {
        return made_In+"\n"+material+"\n";
    }

    public abstract String toString2();

    public abstract double discountAmount();
    public abstract String partOfDiscountCode();
    public abstract double discountAmount2();


    @Override
    public Sale addDiscount(int capacity, LocalDate localDate)
    {
        String code=makeDiscountCode();
        Sale sale =new Sale(discountAmount() ,localDate,capacity,this);
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

    public String getMade_In() {
        return made_In;
    }

    public String getMaterial() {
        return material;
    }

    public void setMade_In(String made_In) {
        this.made_In = made_In;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
