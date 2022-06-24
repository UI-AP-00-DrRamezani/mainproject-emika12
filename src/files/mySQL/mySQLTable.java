
package files.mySQL;

import java.sql.*;

public class mySQLTable
{
    private final String URL ="jdbc:mysql://localhost:3306/sellers";
    private String UserName="root";
    private String password="8XvKnMPreHU65eq";

    Connection connection;
    private ResultSet table;

    public mySQLTable(String sqmlCmd,String command)
    {
        ExecuteCQL(sqmlCmd , command);
    }

    private Boolean ExecuteCQL (String sqmlCmd ,String command)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(URL,UserName , password);
            Statement statement=connection.prepareStatement(sqmlCmd);

            if (command.equals("write" )|| command.equals("update") || command.equals("delete"))
                statement.execute(sqmlCmd) ;
            else
               table=statement.executeQuery(sqmlCmd);

            return true;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        return false;}

    }

    public void closing()
    {
       try {
           connection.close();
       }catch (Exception e){}
    }
    public ResultSet getTable() {
        return table;
    }
}
