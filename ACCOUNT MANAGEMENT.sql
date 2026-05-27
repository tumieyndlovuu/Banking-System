CREATE TABLE Account
(account_id int AUTO_INCREMENT PRIMARY KEY,
customer_id int NOT NULL,
branch_id int NOT NULL,
account_type ENUM('Savings','Checking') NOT NULL,
balance DECIMAL(15,2) DEFAULT 0.00 CHECK (balance >=0),
status ENUM('Active','Closed') DEFAULT 'Active',
FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
FOREIGN KEY (branch_id) REFERENCES Branch (branch_id)
);

INSERT INTO Account(customer_id,branch_id,account_type,balance)
VALUES
(1,1,'Savings',12000.00),
(2,2,'Checking',4000.00),
(3,3,'Savings',20000.00),
(4,4,'Checkings',5000.00),
(5,5,'Savings',15000.00),
(6,6,'Checkings',5000.00),
(7,7,'Checkings',2000.00),
(8,8,'Savings',10000.00),
(9,9,'Checkings',35000.00),
(10,10,'Savings',75000.00),