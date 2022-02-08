Select * from rx limit 15;
Select * from patient limit 15;
Select * from doctor limit 15;
Select * from drug limit 15;

Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('52416', 12, 5, '2021-12-10', '2022-02-01', 2, 1); 


insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 444444444, 'patient two', '2003-02-21', '87457 Burnett sreet', 'sacramento', 'CA', 95864, 1);



insert into doctor (id, ssn, name, specialty, practice_since) values (null, 512423654, 'John Doe', 'Geriatrics', '1984');