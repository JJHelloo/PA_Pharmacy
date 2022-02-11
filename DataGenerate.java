//Written by Ryan
//Generates random doctor, patient, and prescription data

package com.csumb.cst363;

import java.sql.*;
import java.util.Random;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataGenerate
{
   public static void main(String[] args)
   {
      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); )
      {
         //10 random doctors
         for (int i = 0; i < 10; i++)
         {
            Doctor doc = randomDoctor();

            PreparedStatement ps = con.prepareStatement("insert into doctor values (null, ?, ?, ?, ?)");
            ps.setString(1, doc.getSsn());
            ps.setString(2, doc.getName());
            ps.setString(3, doc.getSpecialty());
            ps.setString(4, doc.getPractice_since_year());
            
            ps.executeUpdate();
         }

         //1000 random patients
         for (int i = 0; i < 1000; i++)
         {
            Patient pat = randomPatient();

            PreparedStatement ps = con.prepareStatement("insert into patient values (null, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pat.getSsn());
            ps.setString(2, pat.getName());
            ps.setString(3, pat.getBirthdate());
            ps.setString(4, pat.getStreet());
            ps.setString(5, pat.getCity());
            ps.setString(6, pat.getState());
            ps.setString(7, pat.getZipcode());
            ps.setInt(8, pat.getPrimaryID());

            ps.executeUpdate();
         }
         
         //5000 random prescriptions
         for (int i = 0; i < 5000; i++)
         {
            Prescription pre = randomPrescription();

            PreparedStatement ps = con.prepareStatement("insert into rx values (?, ?, ?, ?, null, ?, ?, null)");
            ps.setInt(1, Integer.valueOf(pre.getRxid()));
            ps.setInt(2, pre.getDrugID());
            ps.setInt(3, pre.getQuantity());
            ps.setString(4, pre.getDateIssued());
            ps.setInt(5, pre.getDoctorID());
            ps.setInt(6, pre.getPatientID());
            
            ps.executeUpdate();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }


   //returns a random doctor
   public static Doctor randomDoctor()
   {
      Doctor doc = new Doctor();
      Random gen = new Random();
      Faker faker = new Faker(); //https://github.com/DiUS/java-faker

      //name
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();

      doc.setName(firstName + " " + lastName);

      //specialty
      String[] specialties = { "Internal Medicine", 
            "Family Medicine", "Pediatrics", "Orthopedics",
            "Dermatology",  "Cardiology", "Gynecology", 
            "Gastroenterology", "Psychiatry", "Oncology" };

      doc.setSpecialty(specialties[gen.nextInt(specialties.length)]);

      //practice_since_year
      //from 1900 to 2022
      int randNum = 1900 + gen.nextInt(2022 - 1900 + 1);

      doc.setPractice_since_year(String.valueOf(randNum));

      //ssn
      String randSsn = "";
      int x = 0;
      for(int i = 0; i < 9; i++)
      {
         //pick number
         //Social security numbers never start with a 0 or a 9
         if(i == 0)
         {
            x = 1 + gen.nextInt(8 - 1 + 1); //1-8
         }
         //the middle 2 digits are 01-99 (never 00)
         else if (i == 4  && randSsn.indexOf(3) == '0')
         {
            x = 1 + gen.nextInt(9 - 1 + 1); //1-9
         }
         //the last 4 digits are 0001-9999 (never 0000)
         else if (i == 8 && randSsn.indexOf(5) == '0' 
               && randSsn.indexOf(6) == '0' && randSsn.indexOf(7) == '0')
         {
            x = 1 + gen.nextInt(9 - 1 + 1); //1-9
         }
         else
         {
            x = 0 + gen.nextInt(9 - 0 + 1); //0-9
         }

         //add to string
         randSsn = randSsn.concat(String.valueOf(x));
      }

      doc.setSsn(randSsn);

      //return doctor object
      return doc;
   }

   //returns a random patient
   public static Patient randomPatient()
   {
      Patient pat = new Patient();
      Random gen = new Random();
      Faker faker = new Faker();

      //ssn
      String randSsn = "";
      int x = 0;
      for(int i = 0; i < 9; i++)
      {
         //pick number
         //Social security numbers never start with a 0 or a 9
         if(i == 0)
         {
            x = 1 + gen.nextInt(8 - 1 + 1); //1-8
         }
         //the middle 2 digits are 01-99 (never 00)
         else if (i == 4  && randSsn.indexOf(3) == '0')
         {
            x = 1 + gen.nextInt(9 - 1 + 1); //1-9
         }
         //the last 4 digits are 0001-9999 (never 0000)
         else if (i == 8 && randSsn.indexOf(5) == '0' 
               && randSsn.indexOf(6) == '0' && randSsn.indexOf(7) == '0')
         {
            x = 1 + gen.nextInt(9 - 1 + 1); //1-9
         }
         else
         {
            x = 0 + gen.nextInt(9 - 0 + 1); //0-9
         }

         //add to string
         randSsn = randSsn.concat(String.valueOf(x));
      }

      //perform select to check duplicates?
      pat.setSsn(randSsn);

      //name
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();

      pat.setName(firstName + " " + lastName);

      //birthdate
      //from 1900 to 2022
      SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("YYYY-MM-dd");
      Calendar c = Calendar.getInstance();
      c.set(Calendar.YEAR, 1900);
      c.add(Calendar.YEAR, gen.nextInt(122));
      c.set(Calendar.DAY_OF_YEAR, 1);
      c.add(Calendar.DAY_OF_YEAR, gen.nextInt(365));
      Date dt = new Date(c.getTimeInMillis());
      String random_date = simpleDateFormat.format(dt);

      pat.setBirthdate(random_date);

      //fake address
      Address address = faker.address();

      //street
      pat.setStreet(address.streetAddress());

      //city
      pat.setCity(address.city());

      //state
      pat.setState(address.state());

      //zipcode
      pat.setZipcode(address.zipCode());

      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); )
      {
         //primaryid
         PreparedStatement ps = con.prepareStatement("select count(*) from doctor");
         ResultSet rs = ps.executeQuery();
         rs.next();
         //find how many doctors there are
         int count = Integer.valueOf(rs.getString(1));
         
         //pick one at random
         int randDoctorID = 1 + gen.nextInt(count - 1 + 1);
         
         //obtain that doctor's id
         ps = con.prepareStatement("select id from doctor order by id");
         rs = ps.executeQuery();
         for (int i = 1; i <= randDoctorID; i++)
            rs.next();
         
         //set doctor as primary doctor for patient
         pat.setPrimaryID(rs.getInt(1));
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      return pat;
   }

   //returns a random prescription
   public static Prescription randomPrescription()
   {
      Prescription pre = new Prescription();
      Random gen = new Random();
      Faker faker = new Faker();

      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa_pharmacy", "root", "root"); )
      {
         //rxid
         //search database for max rxid that exists
         PreparedStatement ps = con.prepareStatement("select max(RxID) from rx;");
         ResultSet rs = ps.executeQuery();
         rs.next();
         //increment
         int maxRxID = rs.getInt(1);
         int newRxID = maxRxID + 1;
         
         String newRxIDasString = String.valueOf(newRxID);
         //set rxid
         pre.setRxid(newRxIDasString);
         
         //drugID
         //find how many drugs there are
         ps = con.prepareStatement("select count(*) from drug");
         rs = ps.executeQuery();
         rs.next();
         int count = Integer.valueOf(rs.getString(1));
         
         //pick one at random
         int randDrugID = 1 + gen.nextInt(count - 1 + 1);
         
         //obtain that drug's id
         ps = con.prepareStatement("select drugid from drug");
         rs = ps.executeQuery();
         for (int i = 1; i <= randDrugID; i++)
            rs.next();
         
         //set drugID
         pre.setDrugID(rs.getInt(1));
         
         //doctorid
         //pick random doctor
         ps = con.prepareStatement("select count(*) from doctor");
         rs = ps.executeQuery();
         rs.next();
         //find how many doctors there are
         int doctorCount = Integer.valueOf(rs.getString(1));
         
         //pick one at random
         int randDoctorID = 1 + gen.nextInt(doctorCount - 1 + 1);
         
         //obtain that doctor's id
         ps = con.prepareStatement("select id from doctor order by id");
         rs = ps.executeQuery();
         for (int i = 1; i <= randDoctorID; i++)
            rs.next();
         //set doctor
         pre.setDoctorID(rs.getInt(1));
         
         //patientid
         ps = con.prepareStatement("select count(*) from patient");
         rs = ps.executeQuery();
         rs.next();
         int patientCount = Integer.valueOf(rs.getString(1));
         
         //pick one at random
         int randPatient = 1 + gen.nextInt(patientCount - 1 + 1);
         
         //obtain that patient's id
         ps = con.prepareStatement("select id from patient order by id");
         rs = ps.executeQuery();
         for (int i = 1; i <= randPatient; i++)
            rs.next();
         
         //set patientid
         pre.setPatientID(rs.getInt(1));
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
      //quantity (1-200)
      int randQuantity = 1 + gen.nextInt(200 - 1 + 1);

      pre.setQuantity(randQuantity);

      //dateissued
      //from 1900 to 2022
      SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("YYYY-MM-dd");
      Calendar c = Calendar.getInstance();
      c.set(Calendar.YEAR, 1900);
      c.add(Calendar.YEAR, gen.nextInt(122));
      c.set(Calendar.DAY_OF_YEAR, 1);
      c.add(Calendar.DAY_OF_YEAR, gen.nextInt(365));
      Date dt = new Date(c.getTimeInMillis());
      String random_date = simpleDateFormat.format(dt);
      
      pre.setDateIssued(random_date);

      //datefilled is null

      //pharmacy_id is null

      return pre;
   }
}


