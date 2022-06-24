package account.making;

import random.works.Comments;
import saleing.Sale;

import java.io.Serializable;
import java.security.SecureRandomParameters;
import java.util.ArrayList;

public class Admin implements Serializable
{
    private userAccount same;

    public ArrayList<userAccount> permission=new ArrayList<userAccount>();
    public ArrayList <userAccount>acceptUser=new ArrayList<userAccount>();
    public ArrayList<Comments>comments_Permission=new ArrayList<Comments>();
    public static ArrayList <Sale> sales=new ArrayList<Sale>();

    public Admin(userAccount use)
    {
        this.same=use;
    }

    public userAccount getSame() {
        return same;
    }

    public void setSame(userAccount same) {
        this.same = same;
    }
}
