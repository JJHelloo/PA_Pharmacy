//Written by Anna Bellizzi
//Take user paramenters for FDA report requirements
//Output result table to Console

package com.csumb.cst363;
import java.sql.*;
import java.util.Scanner;

/*
An FDA government official is looking for the quantity of drugs that each doctor has prescribed.  The report shows the doctor’s name and quantity prescribed.  Input is drug name (may be partial name) and a start and end date range.
*/

public class FDAreport {

public static void main(String[] args) {
	
	//GET USER INPUT FOR REPORT
	Scanner input = new Scanner(System.in);  // Reading from System.in
    System.out.println("Enter a Drug: ");
    String DrugIn = input.next();
    System.out.println("Prescribed between (Enter search Start Date YYY-MM-DD: ");
    String StartDate = input.next();
    System.out.println("Prescribed between (Enter search End Date YYY-MM-DD: ");
    String EndDate = input.next();
    
    input.close(); 
    
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); ) {
///////

PreparedStatement ps = con.prepareStatement("select dr.name, sum(rx.quantity) from doctor dr join rx on dr.id = rx.Doctor_DoctorID join drug d on rx._drugID = d.DrugID where d.TradeName =? AND rx.datefilled >? AND rx.datefilled <? group by dr.name");
			ps.setString(1, DrugIn);
			ps.setString(2, StartDate);
			ps.setString(3, EndDate);
			
			//ps.setString(2, "2022-02-07");
			//ps.setString(3, "2000-01-01");
			
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