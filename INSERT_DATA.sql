Select * from rx limit 15;
Select * from patient limit 15;
Select * from doctor limit 15;
Select * from drug limit 15;

-- INSERTS FOR SOME PRESCRIPTIONS
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('59184', 12, 120, '2021-12-10', '2021-01-01', 4, 4);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('59654', 12, 30, '2020-12-10', '2022-01-01', 1, 7);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('12654', 12, 5, '2019-10-10', '2022-02-05', 4, 5);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('12671', 12, 90, '2022-01-10', '2022-01-10', 2, 3);

-- INSERTS FOR SOME PATIENTS
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 333495434, 'patient One', '2000-05-06', '87 SE sreet', 'roseville', 'CA', 95913, 1);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 222495474, 'patient Two', '2003-01-21', '654 Main sreet', 'sacramento', 'CA', 95812, 2);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 888495844, 'patient Three', '2015-07-28', '12345 Paula sreet', 'Los Angeles', 'CA', 96413, 3);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 666495441, 'patient Four', '1974-01-05', '67543 Donner sreet', 'Marin', 'CA', 98274, 4);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 368515434, 'patient Five', '2000-05-06', '87 E street', 'roseville', 'CA', 95913, 1);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 222323174, 'patient Six', '2003-01-21', '654 Mai street', 'sacramento', 'CA', 95812, 2);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 888357944, 'patient Seven', '2015-07-28', '12345 Paul street', 'Los Angeles', 'CA', 96413, 3);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 666421221, 'patient Eight', '1974-01-05', '67543 Doner street', 'Marin', 'CA', 98274, 4);


-- INSERTS FOR SOME DOCTORS
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 512423654, 'Doctor Jane', 'Geriatrics', '1984');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232023654, 'Doctor John', 'Pediatrics', '1997');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232577454, 'Doctor Kim', 'Pediatrics', '1999');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232025521, 'Doctor Pat', 'Family Medicine', '2003');