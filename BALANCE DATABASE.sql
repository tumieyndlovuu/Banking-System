USE banking_system;

CREATE TABLE Balance(
    Balance_id int AUTO_INCREMENT PRIMARY KEY,
    Account_id int NOT NULL,
    Account_Number VARCHAR(20) NOT NULL,
    Current_balance DECIMAL(15,2),
    Account_holder_name VARCHAR(100) NOT NULL,
    Account_type VARCHAR(50),
    

    FOREIGN KEY(Account_id) REFERENCES account(Account_id)
);

INSERT INTO Balance(Account_id,Current_balance,Account_type)
VALUES(
    101, 5000.00,'Savings'),
    102, 3200.00,'Savings'),
    103, 15000.66,'Savings'),
    104, 890.00,'Savings'),
    105, 6700.20,'Savings'),
