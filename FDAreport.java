//Written by Anna Bellizzi
//Take user paramenters for FDA report requirements
//Output result table to Console

//TODO    ------  Program for user input to determine drug name and dates

package com.csumb.cst363;
import java.sql.*;

/*
An FDA government official is looking for the quantity of drugs that each doctor has prescribed.  The report shows the doctor’s name and quantity prescribed.  Input is drug name (may be partial name) and a start and end date range.
*/

public class FDAreport {

public static void main(String[] args) {
    
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); ) {
///////

PreparedStatement ps = con.prepareStatement("select dr.name, sum(rx.quantity) from doctor dr join rx on dr.id = rx.Doctor_DoctorID join drug d on rx._drugID = d.DrugID where d.TradeName =? AND rx.datefilled <? AND rx.datefilled >? group by dr.name");
//TODO    ------  Program for user input to determine drug name and dates
			ps.setString(1, "Lipitor");
			ps.setString(2, "2022-02-07");
			ps.setString(3, "2000-01-01");
			
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String DocName = rs.getString(1);
                int Sum = rs.getInt(2);
             
                System.out.printf("%-20s %-20s \n", DocName, Sum);
            }


//////
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}