package making;

import java.io.Serializable;
import java.util.ArrayList;

public class Buyer implements Serializable
{
    private userAccount same;
    private BuyList buyList;
    public ArrayList<BuyList> list=new ArrayList<BuyList>();

    public Buyer(userAccount use)
    {
        listMaker();
        this.same=use;
    }

    public void listMaker()
    {
        buyList=new BuyList();
    }

    public userAccount getSame() {
        return same;
    }

    public BuyList getBuyList() {
        return buyList;
    }

    public void setBuyList(BuyList buyList) {
        this.buyList = buyList;
    }
}
