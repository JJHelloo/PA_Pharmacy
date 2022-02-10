package com.csumb.cst363;

import java.util.Random;
import com.github.javafaker.Faker;

public class DataGenerate
{

	public static void main(String[] args)
  {
    /////
    public String updateDoctor(Doctor doctor, Model model)
    {
		try (Connection con = getConnection();)
    {
      //10 random doctors
      for (int i = 0; i < 10; i++)
      {
        Doctor doc = randomDoctor();

        PreparedStatement ps = con.prepareStatement("update doctor set id =NULL, SSN=?, name =?, specialty =?, practice_since =?");
        ps.setInt(2,  doc.getSsn());
        ps.setString(3, doc.getName());
        ps.setInt(4,  doc.getSpecialty());
        ps.setInt(5,  doc.getPractice_since_year());
      }

      //1000 random patients
      for (int i = 0; i < 1000; i++)
      {
        Patient pat = randomPatient();

        PreparedStatement ps = con.prepareStatement("update patient set id =NULL, SSN=?, name =?, birthdate =?, street =?, city =?, state =?, zipcode =?, primaryid =?");
        ps.setInt(2,  pat.getSsn());
        ps.setString(3, pat.getName());
        ps.setString(4,  pat.getBirthdate());
        ps.setString(5,  pat.getStreet());
        ps.setString(6,  pat.getCity());
        ps.setString(7,  pat.getState());
        ps.setInt(8,  pat.getZipcode());
        ps.setInt(9,  pat.getPrimaryID());

        //use variables located in Patient.java
      }
      //5000 random prescriptions
      for (int i = 0; i < 5000; i++)
      {
        Prescription pre = randomPrescription();

        //PreparedStatement
        /////////////////////////////////////////// AB to ADD _DRUGID variable and getter and setter to drug.java
        PreparedStatement ps = con.prepareStatement("update rx set RxID =NULL, _drugID =?, quantity =?, dateissued =?, datefilled =?, doctor_doctorid ?, patient_patientid =?");
        //use variables located in Prescription.java
        ps.setInt(2, pre.grt)
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
      //////
  }
}

//returns a random doctor
public Doctor randomDoctor()
{
  Doctor doc = new Doctor();
  Random gen = new Random();
  Faker faker = new Faker(); //https://github.com/DiUS/java-faker

  //name
  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();

  doc.setName(firstName + " " + lastName);

  //old method. not scalable
  /*
  String[] fNames = { "Hazel", "Alyssa", "Devon", "Aya", "Fiza", "Kyle", "Hafsah", 
    "Ann", "Kobe", "Ifrah" };
  String[] lNames = { "Bradshaw", "Clarke", "Carrillo", "Snow", "Holden", 
    "Massey", "Byrd", "Ritte", "Good", "Meza" };

  doc.setName(fNames[gen.nextInt(fNames.length)] + " " 
    + lNames[gen.nextInt(lNames.length)]);
  */

  //specialty
  String[] specialties = { "Internal Medicine", 
    "Family Medicine", "Pediatrics", "Orthopedics",
    "Dermatology",  "Cardiology", "Gynecology", 
    "Gastroenterology", "Psychiatry", "Oncology" };

  doc.setSpecialty(specialties[gen.nextInt(specialities.length)]);

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

//returns a random patient 1000
public Patient randomPatient()
{
  Patient pat = new Patient();


  return pat;
}

//returns a random prescription 5000
public Prescription randomPrescription()
{
  Prescription pre = new Prescription();


  return pre;
}

