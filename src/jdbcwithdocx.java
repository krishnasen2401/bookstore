/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lakshmi
 */
import java.io.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class jdbcwithdocx {
    
    public static void main(String args[]){
        Connection con;
Statement stmt;
String query;
ResultSet rs;
String temp=null;
        XWPFDocument doc=new XWPFDocument();
    XWPFParagraph paragraph =doc.createParagraph();//creates a paragraph
        XWPFRun run=paragraph.createRun();//create running text
    try{FileOutputStream f2=new FileOutputStream("file.docx");
        Class.forName("java.sql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","root");
stmt = con.createStatement();
query="select * from inventory;";
rs=stmt.executeQuery(query);
while(rs.next()){
    int id=rs.getInt("itemid");
    String iname=rs.getString("itemname");
    String cname=rs.getString("category");
    int presentcost=rs.getInt("price");
    System.out.println(id+"\t"+iname+"\t10"+cname+"\t10"+presentcost);
    run.setText(id+" "+iname+" "+cname+" "+presentcost);
    //temp=id+" "+iname+" "+cname+" "+presentcost;
    //run.setText(temp);
    run.addBreak();
    //temp=null;
    }
doc.write(f2);
rs.close();
stmt.close();
con.close();
f2.close();
   }catch(Exception e){
   e.printStackTrace();
   }

}
}
