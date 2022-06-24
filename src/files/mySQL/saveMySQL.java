package files.mySQL;

import account.making.userAccount;
import products.Product;
import products.digital.mobile;

import java.sql.ResultSet;
import java.sql.SQLException;

import products.*;
import products.digital.*;
import products.outfit.*;
import products.house.*;
import products.snacks.snacks;


public class saveMySQL {


    //============================SQL commands


    private static String mySQLInsertUser=String.format("INSERT INTO allusers (`ID`,`Name` ,`family name` ,`phone number`" +
            " ,`email` , `post`) VALUES ");
    private static String mySQLInsertSeller=String.format("INSERT INTO sellerextrainfo(`ID` ,`factory` ,`institute` ,`work shop`) VALUES ");
    private static String mySQLInsertPro=String.format("INSERT INTO products (`earmark` , `name` , `category model` " +
            ",`in stock` , `price` ,`seller ID`) VALUES ");


    //=================================

    public static void writeMySQL(userAccount user)
    {
        if (user.isDeleted_account())return;
        boolean update=checkingForUpdates(user);

        if (!update)return;

        String cmd=mySQLInsertUser+"("+user.mySQLToString(user.getId())+user.mySQLToString(user.getName())+user.mySQLToString(user.getFamilyName())
                +user.mySQLToString(user.getPassword())+user.mySQLToString(user.getEmail())+
                " ' "+user.getPost()+" '"+")" ;

        mySQLTable mySQL_Table =new mySQLTable(cmd,"write");


        if (user.getSeller()!=null)
        {
            String cmd2=String.format("INSERT INTO sellerextrainfo(`ID` ,`factory` ,`institute` ,`work shop`)" +
                    " VALUES ( '%s' ,'%s' ,'%s' ,'%s')" , user.getId(),user.getSeller().getFactoryName(),
                    user.getSeller().getInstituteName(),user.getSeller().getWorkShopName());

            mySQLTable mySQL_Table2 =new mySQLTable(cmd2,"write");
        }
    }

    public static void updateUsers(userAccount user)
    {
        String cmd=String.format("UPDATE `allusers` SET `Name`='%s' ,`family name`='%s' ," +
                        "`phone number`='%s' , `email`='%s' ,`post`='%s' WHERE `ID`='%s'",
                user.getName(),user.getFamilyName(),user.getPhoneNum(),user.getEmail(),user.getPost(),user.getId());
        mySQLTable mySQL_Table=new mySQLTable(cmd ,"update");

        if (user.getSeller()!=null)
        {
            String cmd2=String.format("UPDATE `sellerextrainfo` SET `factory`='%s' ,`institute`='%s' , `work shop`='%s' WHERE  `ID`='%s' ",
                    user.getSeller().getFactoryName(),user.getSeller().getInstituteName(),user.getSeller().getWorkShopName()
                    ,user.getId());
            mySQLTable mySQL_Table2=new mySQLTable(cmd2 ,"update");
        }

    }
//===============================================================================
    public static void productWriteSQL(Product product)
    {
        if (product.isDeleted_product())return;

        boolean update=checkingForProUpdates(product);
        if (! update)return;

        String cmd=String.format(String.format("INSERT INTO products (`earmark` , `name` , `category model` ," +
                        "`in stock` , `price` ,`seller ID`) VALUES ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s')",product.getEarmark()
                ,product.getName(),
                product.getCategory_model(),product.getInStock()
                ,product.getPrice(),product.getSeller().getSame().getName()));

        mySQLTable mySQL_Table =new mySQLTable(cmd, "write");
        mySQL_Table.closing();

        if (product instanceof digitalProduct) {
            cmd = String.format(String.format("INSERT INTO digital_products VALUES  ('%s' ,'%s' ,'%s' ,'%s' ,'%s' ,'%s','%s' )"
                    ,((digitalProduct) product).getRam_space(),
                    ((digitalProduct) product).getMemory(),((digitalProduct) product).getOperating_System(),((digitalProduct) product).getResolution()
                    ,((digitalProduct) product).getGuaranteeTime(),((digitalProduct) product).getGuaranteeValue(),
                    product.getEarmark()));


            mySQL_Table = new mySQLTable(cmd, "write");
            mySQL_Table.closing();
            if (product instanceof mobile) {
                cmd = String.format(String.format("INSERT INTO mobile " +
                                "VALUES ('%s' ,'%s' ,'%s')", ((mobile) product).getSIM_num(), ((mobile) product).getCameraQuantity()
                        , product.getEarmark()));

                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();

            }if (product instanceof laptop)
            {
                cmd = String.format(String.format("INSERT INTO laptop " +
                                "VALUES ('%s' ,'%s' ,'%s')", ((laptop) product).getProcessor_Model(),((laptop) product).getFor_Gaming()
                        , product.getEarmark()));

                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();
            }
        }
        else if (product instanceof houseProducts){
            cmd = String.format(String.format("INSERT INTO house_products " +
                            "VALUES  ('%s' ,'%s' ,'%s' ,'%s' ,'%s' )",((houseProducts) product).getEnergy_Usage(),
                    ((houseProducts) product).getGarentie(),((houseProducts) product).getGuaranteeTime(),((houseProducts) product).getGuaranteeValue()
            ,product.getEarmark()));


            mySQL_Table = new mySQLTable(cmd, "write");
            mySQL_Table.closing();

            if (product instanceof television)
            {
                cmd = String.format(String.format("INSERT INTO television " +
                                "VALUES ('%s' ,'%s' ,'%s')",((television) product).getPic_Quality(),
                        ((television) product).getWindows_Size(),product.getEarmark() ));

                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();

            }else if (product instanceof refrigator)
            {
                cmd = String.format(String.format("INSERT INTO refrigerator " +
                                "VALUES ('%s' ,'%s' ,'%s','%s')",((refrigator) product).getStorage(),((refrigator) product).getModel()
                ,((refrigator) product).isHaving_Freezer(),product.getEarmark()));


                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();

            }
        }
        else if (product instanceof outfit)
        {
            cmd = String.format(String.format("INSERT INTO outfits " +
                            "VALUES ('%s' ,'%s' ,'%s')", ((outfit) product).getMade_In(),((outfit) product).getMaterial()
                    , product.getEarmark()));

            mySQL_Table = new mySQLTable(cmd, "write");
            mySQL_Table.closing();

            if (product instanceof shoes)
            {
                cmd = String.format(String.format("INSERT INTO shoes " +
                                "VALUES ('%s' ,'%s' ,'%s')", ((shoes) product).getSize(),((shoes) product).getModel()
                        , product.getEarmark()));

                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();

            }else if (product instanceof dressing)
            {
                cmd = String.format(String.format("INSERT INTO dressing " +
                                "VALUES ('%s' ,'%s' ,'%s')", ((dressing) product).getSize(),((dressing) product).getModel()
                        , product.getEarmark()));

                mySQL_Table = new mySQLTable(cmd, "write");
                mySQL_Table.closing();
            }

        }
        else if (product instanceof snacks)
        {
            cmd = String.format(String.format("INSERT INTO snacks " +
                            "VALUES ('%s' ,'%s' ,'%s')",((snacks) product).getProducing_date(),((snacks) product).getExpiring_date()
                    , product.getEarmark()));

            mySQL_Table = new mySQLTable(cmd, "write");
            mySQL_Table.closing();
        }


    }

    public static boolean checkingForUpdates(userAccount user)
    {
        mySQLTable mySQL_Table=new mySQLTable("SELECT * FROM allusers","read");

        ResultSet table=mySQL_Table.getTable();

        while (true) {
            try {
                if (!table.next()) {
                    updateUsers(user);
                    mySQL_Table.closing();
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                String id=table.getString("ID");
                if (id.trim().equals(user.getId())) {
                    mySQL_Table.closing();
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean checkingForProUpdates(Product product)
    {
        mySQLTable mySQL_Table=new mySQLTable("SELECT * FROM products","read");

        ResultSet table=mySQL_Table.getTable();

        while (true) {
            try {
                if (!table.next()) {
                    updateProduct(product);
                    mySQL_Table.closing();
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                String id=table.getString("earmark");
                id=id.trim();
                if (Integer.parseInt(id)==product.getEarmark()) {
                    mySQL_Table.closing();
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateProduct(Product product)
    {
        String cmd=String.format("UPDATE `products` SET `name`='%s' ,`category model` ='%s' ,`in stock`='%s' ,`price`='%s' " +
                        "WHERE `earmark`='%s' ",
                product.getName(),product.getCategory_model(),product.getInStock(),product.getPrice(),product.getEarmark());

        mySQLTable mySQL_Table=new mySQLTable(cmd ,"update");
    }
}
