//Written by Anna Bellizzi
//Take user paramenters for FDA report requirements
//Output result table to Console

package com.csumb.cst363;
import java.sql.*;

/*
An FDA government official is looking for the quantity of drugs that each doctor has prescribed.  The report shows the doctor’s name and quantity prescribed.  Input is drug name (may be partial name) and a start and end date range.
*/

public class FDAreport {

public static void main(String[] args) {
    
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); ) {
///////

/////// TESTING SELECT EXECUTION AND DISPLAY TO CONSOLE
PreparedStatement ps = con.prepareStatement("select DrugID, TradeName, GenericName from drug where DrugID<=?");
            ps.setInt(1, 15);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String DrugID = rs.getString(1);
                String TradeName = rs.getString(2);
                String GenericName = rs.getString(3);
 
                System.out.printf("%5s %-20s %-20s \n", DrugID, TradeName, GenericName);
            }


//////
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}          