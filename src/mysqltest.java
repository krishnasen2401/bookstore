
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lakshmi
 */
public class mysqltest {
    public static void main(String[] args) {
        Connection con=null;
        try{
            Class.forName("java.sql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","root");
            Statement stmt = con.createStatement();
            String query="select status from books where bookid=2;";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String status=rs.getString("status");
                if("no".equals(status)){
            System.out.println("failed");
            }
                else{
                    System.out.println("yes");
                String sql = "insert into bookhistory values(123,2,'0000-00-00','0000-00-00');";
           String sql1 = "update books set status='no' where bookid=2;";
            System.out.println("done");
            
            int no = stmt.executeUpdate(sql);
            int no1 = stmt.executeUpdate(sql1);
  con.prepareStatement(sql);
                }
         
            }
          
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
