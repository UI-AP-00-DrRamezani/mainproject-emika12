package files.mySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class readMySQL {


    public static ResultSet readSQLUsers(String cmd , String url)
    {
        mySQLTable mySQL_Table=new mySQLTable(cmd ,"read");
        ResultSet table =mySQL_Table.getTable();

        mySQL_Table.closing();

        return table;
    }

    public static void readSQLProducts(String cmd)
    {
        readEarmark();
    }

  public static void readEarmark()
  {
      String [] allCategories={"mobile digital_products" , "laptop digital_products" ,"refrigerator house_products",
              "television house_products","snacks snacks" };


      //==========================================================reading and joining the tables

      for (int i=0 ; i<5 ;++i)
      {
          String [] category=allCategories[1].split("\\s");
          String cmd= String.format("SELECT *FROM `%s` ,`%s` INNER JOIN ON `%s`.earmark =`%s`.earmark " +
                  "INNER JOIN `%s` ON `%s`.earmark =`%s`.earmark",category[1],category[2],category[1],category[2]
          ,"products",category[2],"products");
          mySQLTable mySQL_Table=new mySQLTable(cmd,"read");

          ResultSet rs=mySQL_Table.getTable();

          mySQL_Table.closing();

      }

  }

}
