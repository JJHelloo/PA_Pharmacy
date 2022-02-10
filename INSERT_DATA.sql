Select * from rx limit 15;
Select * from patient limit 15;
Select * from doctor limit 15;
Select * from drug limit 15;

-- INSERTS FOR SOME DOCTORS
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 512423654, 'Doctor Jane', 'Geriatrics', '1984');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232023654, 'Doctor John', 'Pediatrics', '1997');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232577454, 'Doctor Kim', 'Pediatrics', '1999');
insert into doctor (id, ssn, name, specialty, practice_since) values (null, 232025521, 'Doctor Pat', 'Family Medicine', '2003');

-- INSERTS FOR PHARMACY
insert into pharmacy (pharmacyid, pharmacyname, address, phonenum) values (null, 'CVS-001', 'Sacramento', '555-555-4444');
insert into pharmacy (pharmacyid, pharmacyname, address, phonenum) values (null, 'Walgreens', 'Roseville', '916-555-4444');
insert into pharmacy (pharmacyid, pharmacyname, address, phonenum) values (null, 'Dokomos', 'Grass Valley', '530-333-5844');
insert into pharmacy (pharmacyid, pharmacyname, address, phonenum) values (null, 'Safeway Rx', 'Marin', '415-375-9523');

-- INSERTS FOR SOME PATIENTS
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 333495434, 'patient One', '2000-05-06', '87 SE sreet', 'roseville', 'CA', 95913, 1);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 222495474, 'patient Two', '2003-01-21', '654 Main sreet', 'sacramento', 'CA', 95812, 2);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 888495844, 'patient Three', '2015-07-28', '12345 Paula sreet', 'Los Angeles', 'CA', 96413, 3);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 666495441, 'patient Four', '1974-01-05', '67543 Donner sreet', 'Marin', 'CA', 98274, 4);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 368515434, 'patient Five', '2000-05-06', '87 E street', 'roseville', 'CA', 95913, 1);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 222323174, 'patient Six', '2003-01-21', '654 Mai street', 'sacramento', 'CA', 95812, 2);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 888357944, 'patient Seven', '2015-07-28', '12345 Paul street', 'Los Angeles', 'CA', 96413, 3);
insert into patient (id, ssn, name, birthdate, street, city, state, zipcode, primaryid) values (null, 666421221, 'patient Eight', '1974-01-05', '67543 Doner street', 'Marin', 'CA', 98274, 4);


-- INSERTS FOR SOME PRESCRIPTIONS
-- USE WEB FORM TO CREATE A DOCTOR #5 THESE INSERTS ONLY INSERT 4 DOCTORS AND YOUR
-- RX INSERTS WILL FAIL
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('54884', 12, 120, '2021-12-10', '2021-01-01', 4, 4);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('59654', 12, 30, '2020-12-10', '2022-01-01', 1, 7);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('12654', 12, 5, '2019-10-10', '2022-02-05', 4, 5);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('12671', 12, 90, '2022-01-10', '2022-01-10', 2, 3);

-- INSERT PHARMACY_ID FOR COLUMN ADDED LATER ON FILLED PRESCRIPTIONS
update rx set pharmacy_id = 1 where RxID = 12654;
update rx set pharmacy_id = 3 where RxID = 12671;
update rx set pharmacy_id = 3 where RxID = 59184;
update rx set pharmacy_id = 2 where RxID = 59654;
update rx set pharmacy_id = 4 where rxid = 54884;

-- INSERTS FOR SOME UNFILLED PRESCRIPTIONS
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('10023', 9, 10, '2022-02-01', NULL, 2, 1);
Insert Into rx (RxID, _drugID, quantity, dateissued, datefilled, doctor_doctorid, patient_patientid) values ('59473', 12, 300, '2022-02-09', NULL, 5, 6);



