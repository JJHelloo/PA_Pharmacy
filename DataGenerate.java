package com.csumb.cst363;

java.util.Random;

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

//returns a random doctor 10
public Doctor randomDoctor()
{
  Doctor doc = new Doctor();

  Random gen = new Random();

  //id randomly generated by database
  //name
  String[] fNames = { "Hazel", "Alyssa", "Devon", "Aya", "Fiza", "Kyle", "Hafsah", 
    "Ann", "Kobe", "Ifrah" };
  String[] lNames = { "Bradshaw", "Clarke", "Carrillo", "Snow", "Holden", 
    "Massey", "Byrd", "Ritte", "Good", "Meza" };

  doc.setName(fNames[gen.nextInt(fNames.length)] + " " 
    + lNames[gen.nextInt(lNames.length)]);

  //specialty
  String[] specialties = { "Internal Medicine", 
    "Family Medicine", "Pediatrics", "Orthopedics",
    "Dermatology",  "Cardiology", "Gynecology", 
    "Gastroenterology", "Psychiatry", "Oncology" };

  doc.setSpecialty(specialties[gen.nextInt(specialities.length)]);

  //practice_since_year
  //from 1950 to 2022
  int randNum = 1950 + gen.nextInt(2022 - 1950 + 1);

  doc.setPractice_since_year(String.valueOf(randNum));

  //ssn
  String randSsn = "";
  for(int i = 0; i < 9; i++)
  {
    int x = 0 + gen.nextInt(9 - 0 + 1);
    randSsn = randSsn.concat(String.valueOf(x));
  }

  doc.setSsn(randSsn);

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
