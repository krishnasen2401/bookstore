
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lakshmi
 */
public class datestest {
    public static void main (String args[]){
    System.out.println(java.time.LocalDate.now()); 
    LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date=localDate.format(formatter);
        System.out.println(date);
        String.format("%1$"+21+ "s", date);
    }
}
