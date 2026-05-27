CREATE TABLE Transaction
(transaction_id int AUTO_INCREMENT PRIMARY KEY,
account_id int NOT NULL,
type ENUM ('Deposit','Withdrawal','Transfer'),
amount DECIMAL(15.2) NOT NULL CHECK (amount >0),
timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
reference_account_id int NULL,
FOREIGN KEY (account_id) REFERENCES Account(account_id),
FOREIGN key (reference_account_id) REFERENCES Account(account_id)
);

INSERT INTO Transaction(account_id,type,amount,reference_account_id)
VALUES
(1,'Deposit',,NULL),
(2,'Transfer',,NULL),
(3,'Deposit',,NULL),
(4,'Transfer',,NULL),
(5,'Deposit',,NULL),
(6,'Transfer',,NULL),
(7,'Deposit',,NULL),
(8,'Transfer',,NULL),
(9,'DEposit',,NULL)
(10,'Transfer',,NULL);
