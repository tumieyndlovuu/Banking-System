USE Banking_System;
CREATE TABLE Customer
(customer_id int AUTO_INCREMENT PRIMARY KEY,
first_name varchar(50) NOT NULL;
phone varchr(20),
address varchar(200),
date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO Customer(first_name,last_name,email,phone,address)
VALUES
('Jhon','Doe','JhonDoe@gmail.com','01234567891',123 Main St),
('Lesego','Modise','LesegoMoside@gmail.com','02345678912',45 Oak Ave),
('Bruce','Wayne','BruceWayne@gmail.com','012345678913',78 Web St),
('Thato','Dikana','ThatoDikana@gmail.com','012345678914',98 Rose St),
('Mary','Jane','MaryJane@gmail.com','012345678915',100 Wayne Manor),
('Abakwe','Sedibeng','AbakweSedibeng@gmail.com','012345678916',48 Rubern Ave),
('Bernice','Williams','Bernice@gmail.com','012345678917',456 Stateler Rd),
('Chabe','Modise','ChabeModise@gmail.com','012345678918',34 Cori St St),
('Debra','Mathole','DebraMathole@gmail.com','012345678919',64 Zavier Ave),
('Edward','Van Wyk','EdwardVanWyk@gmail.com','01234567891',100 Staelor Rd),
