package files.mySQL;

import account.making.userAccount;
import products.Product;

import products.digital.*;
import products.outfit.*;
import products.house.*;
import products.snacks.snacks;

public class deleteMySQL {

    public static void deletingUsers(userAccount user)
    {
        String cmd=String.format("DELETE FROM `allusers` WHERE `ID`='%s'",user.getId());
        mySQLTable mySQL_Table=new mySQLTable(cmd , "delete");
        mySQL_Table.closing();

        if (user.getSeller()!=null)
        {
            cmd=String.format("DELETE FROM `sllerextrainfo` WHERE `ID`='%s'",user.getId());
            mySQL_Table=new mySQLTable(cmd ,"delete");
            mySQL_Table.closing();
        }
    }

    public static void deletingProduct(Product product)
    {
        String cmd=String.format("DELETE FROM `products` WHERE `earmark`='%s'",product.getEarmark());
        mySQLTable mySQL_Table=new mySQLTable(cmd , "delete");
        mySQL_Table.closing();

        if (product instanceof digitalProduct)
        {
            cmd=String.format("DELETE FROM `digital_products` WHERE `earmark`='%s'",product.getEarmark());
            connecting(cmd);

            if (product instanceof mobile)
            {
                cmd=String.format("DELETE FROM `mobile` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }else if (product instanceof laptop)
            {
                cmd=String.format("DELETE FROM `laptop` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }
        }
        else if (product instanceof houseProducts)
        {
            cmd=String.format("DELETE FROM `house_products` WHERE `earmark`='%s'",product.getEarmark());
            connecting(cmd);
            if (product instanceof television)
            {
                cmd=String.format("DELETE FROM `television` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }else if (product instanceof refrigator)
            {
                cmd=String.format("DELETE FROM `refrigerator` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }
        }
        else if (product instanceof outfit)
        {
            cmd=String.format("DELETE FROM `outfits` WHERE `earmark`='%s'",product.getEarmark());
            connecting(cmd);

            if (product instanceof shoes)
            {
                cmd=String.format("DELETE FROM `shoes` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }else if (product instanceof dressing)
            {
                cmd=String.format("DELETE FROM `dressing` WHERE `earmark`='%s'",product.getEarmark());
                connecting(cmd);
            }
        }
        else
        {
            cmd=String.format("DELETE FROM `snacks` WHERE `earmark`='%s'",product.getEarmark());
            connecting(cmd);

        }

    }

    public static void connecting(String cmd)
    {

        mySQLTable mySQL_Table=new mySQLTable(cmd , "delete");
        mySQL_Table.closing();
    }

}
