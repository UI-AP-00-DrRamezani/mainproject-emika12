package products.snacks;

import account.making.Admin;
import products.Product;
import products.outfit.ShoesModel;
import saleing.IDiscountFeature;
import saleing.Sale;

import java.time.LocalDate;
import java.util.Date;

public class snacks extends Product implements IDiscountFeature
{
    private String producing_date;
    private String expiring_date;


    public snacks() {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("snacks");
    }

    @Override
    public void readingFromFile(String[] info) {
        setName(info[0]);
        setBrand(info[1]);
        setPrice(Integer.parseInt(info[2]));
        setInStock(Integer.parseInt(info[3]));
        setEarmark(Integer.parseInt(info[4]));
        setCategory_model(info[5]);
        setInfo(info[6]);

        setProducing_date(info[7]);
        setExpiring_date(info[8]);

        setAddress(info[9]);
        setAddress2(info[10]);
        setDeleted_product(Boolean.parseBoolean(info[11]));
        setStar(Integer.parseInt(info[12]));
    }
//------------------------------------
    public String myToString2()
    {
        return producing_date+"\n"+expiring_date+"\n";
    }
    public String myToString3(){return "";}

    //---------------------------------------

    public String toString2()
    {
        return "producing date: "+producing_date+"\nexpiring date: "+expiring_date;
    }

    public double discountAmount() {
        return 0.07;
    }

    public double discountAmount2() {
        return 0.05;
    }

    public String partOfDiscountCode() {
        return "sna";
    }

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

    public String getProducing_date() {
        return producing_date;
    }

    public String getExpiring_date() {
        return expiring_date;
    }

    public void setProducing_date(String producing_date) {
        this.producing_date = producing_date;
    }

    public void setExpiring_date(String expiring_date) {
        this.expiring_date = expiring_date;
    }
}