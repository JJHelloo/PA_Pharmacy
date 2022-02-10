//Written by Anna Bellizzi
//Take user parameters for ManagerReport requirements
//Output result table to Console
package com.csumb.cst363;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
A pharmacy manager requests a report of the quantity of drugs that have been used to fill prescriptions by the pharmacy.  The report will contain the names of drugs used and the quantity of each drug used. Input is pharmacy id and a start and end date range.
*/

public class ManagerReport {

	public static void main(String[] args) {
		
		//GET USER INPUT FOR REPORT
		Scanner input = new Scanner(System.in);  // Reading from System.in
	    System.out.println("Enter a Pharmacy ID: ");
	    String PharmacyId = input.next();
	    System.out.println("Prescribed between (Enter search Start Date YYY-MM-DD: ");
	    String StartDate = input.next();
	    System.out.println("Prescribed between (Enter search End Date YYY-MM-DD: ");
	    String EndDate = input.next();
	    
	    input.close(); 
	    
	        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); ) {
	///////

	PreparedStatement ps = con.prepareStatement("select d.tradename, sum(rx.quantity) from rx join drug d on rx._drugid = d.drugid where rx.pharmacy_id =? AND datefilled BETWEEN ? AND ? group by tradename");
				ps.setString(1, PharmacyId);
				ps.setString(2, StartDate);
				ps.setString(3, EndDate);

	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                String DrugName = rs.getString(1);
	                int Sum = rs.getInt(2);
	             
	                System.out.printf("%-20s %-20s \n", DrugName, Sum);
	            }


	//////
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	    }
} 