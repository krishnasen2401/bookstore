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
public class docw {
    public static void main(String args[]) throws IOException{
        XWPFDocument doc=new XWPFDocument();
        XWPFParagraph paragraph2 =doc.createParagraph();//creates 1st paragraph
        XWPFRun run2=paragraph2.createRun();
        XWPFParagraph paragraph =doc.createParagraph();//creates a paragraph
        XWPFRun run=paragraph.createRun();//create running text
        run.setText("pancakes");//no \t and \n works
        run.setText("nutella");//continues in the same line
        run.addBreak();//adds new line or a new para kind
        run.setText("i'am Hung0");
        run2.setText("hello");//goes into first paragraph even though it called 2nd
   try{     FileOutputStream f2=new FileOutputStream("file.docx");
       doc.write(f2);
        f2.close();
   }catch(Exception e){
   e.printStackTrace();
   }
    
    }
}
