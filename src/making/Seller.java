package making;

import products.Product;
import random.works.State;

import java.io.Serializable;
import java.util.ArrayList;

public
class Seller implements Serializable
{
    private String factoryName;
    private String instituteName;
    private String workShopName;
    private int Change_Product=0;
    private int Add_product=0;
    private int Delete_Product=0;
    private State account_Acceptence=State.ACCEPTING;

    public ArrayList<Product> productList=new ArrayList<Product>();
    public ArrayList<Request>requests=new ArrayList<Request>();
    public ArrayList<SellList> list=new ArrayList<SellList>();

    private userAccount same;
    private SellList sellList;

    public Seller(userAccount use)
    {
        this.same=use;
        listMaker();
    }

    @Override
    public String toString() {
        return "factory: "+factoryName+"\nworkshop: "+workShopName+"\ninstitute: "+instituteName;
    }

    //-----------------------------for writing to files
    public String myToString2()
    {
        return factoryName+"\n"+instituteName+"\n"+workShopName+"\n";
    }
    public String innerInfo(){
        return Change_Product+"\n"+Add_product+"\n"+Delete_Product+"\n"+account_Acceptence+"\n";
    }
    //----------------------------------
    public void readTheInfoPart2(String []s) {
        this.factoryName = s[8];
        this.instituteName = s[9];
        this.workShopName = s[10];
        Change_Product=Integer.parseInt(s[13]);
        Add_product=Integer.parseInt(s[14]);
        Delete_Product=Integer.parseInt(s[15]);
        account_Acceptence= State.valueOf(s[16]);
    }

    public void listMaker()
    {

        sellList=new SellList();
    }

    public void fullfillInfo(String factoryName,String instituteName,String workShopName)
    {
        this.factoryName=factoryName;
        this.instituteName=instituteName;
        this.workShopName=workShopName;
    }


    public String getFactoryName() {
        return factoryName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public int getChange_Product() {
        return Change_Product;
    }

    public int getAdd_product() {
        return Add_product;
    }

    public int getDelete_Product() {
        return Delete_Product;
    }

    public userAccount getSame() {
        return same;
    }

    public SellList getSellList() {
        return sellList;
    }


    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public void setWorkShopName(String workShopName) {
        this.workShopName = workShopName;
    }


    public void setChange_Product(int change_Product) {
        Change_Product = change_Product;
    }

    public void setAdd_product(int add_product) {
        Add_product = add_product;
    }

    public void setDelete_Product(int delete_Product) {
        Delete_Product = delete_Product;
    }



    public void setSellList(SellList sellList) {
        this.sellList = sellList;
    }

    public State getAccount_Acceptence() {
        return account_Acceptence;
    }

    public void setAccount_Acceptence(State account_Acceptence) {
        this.account_Acceptence = account_Acceptence;
    }
}
