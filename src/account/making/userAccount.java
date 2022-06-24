package account.making;

import java.io.Serial;
import java.io.Serializable;

public class userAccount implements Serializable
{
    private String id;
    private String name;
    private String familyName;
    private String email;
    private String phoneNum;
    private String password;
    private final Post post;
    private double moneyInStock=0;

    private Buyer buyer=null;
    private Seller seller=null;
    private Admin admin=null;


    private String address;
    private boolean deleted_account=false;


    public userAccount (String id, String name, String familyName, String email, String phoneNum, String password,
                        Post post,String deleted_acc)
    {
        this.id=id;
        this.name=name;
        this.familyName=familyName;
        this.email=email;
        this.password=password;
        this.phoneNum=phoneNum;
        //this.moneyInStock=moneyInStock;
        this.post=post;
        this.deleted_account=Boolean.parseBoolean(deleted_acc);

        postAccessabilty();

    }

    @Override
    public String toString() {
        return "id: "+id+"\nname: "+name+"\nfamily name: "+familyName+"\nemail: "+email+"\nphone number: "+phoneNum+
                "\nmoney in stock: "+moneyInStock;
    }
//=================================================
    public String myToString()
    {
        String string=id+"\n"+name+"\n"+ familyName+"\n"+email+"\n"+phoneNum+"\n"+password+"\n"+post+"\n"+moneyInStock+"\n";
        return string;
    }

    public String addresses()
    {
        return address +"\n"+deleted_account+"\n";
    }
//==================================================

    public void postAccessabilty()
    {
        if(this.post== Post.BUYER)
            buyer=new Buyer(this);
        else if(this.post== Post.SELLER)
            seller=new Seller(this);
        else if(this.post== Post.ADMIN)
            admin=new Admin(this);

    }


    //=========================mySQL=========================

    public String mySQLToString(String value)
    {
        return  "' "+value+" '"+",";
    }


    public String getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public Post getPost() {
        return post;
    }


    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public Admin getAdmin() {
        return admin;
    }

    public double getMoneyInStock() {
        return moneyInStock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDeleted_account() {
        return deleted_account;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeleted_account(boolean deleted_account) {
        this.deleted_account = deleted_account;
    }

    public void setMoneyInStock(double moneyInStock) {
        this.moneyInStock = moneyInStock;
    }
}
