
SELECT * FROM customer WHERE first_name = 'Modise';

UPDATE customer SET phone = '0734567890' WHERE customer_id =2;

DELETE FROM customer WHERE customer_id = 7;


SELECT * FROM account WHERE Account_type = 'Savings';

UPDATE account SET Current_balance = 9000.00 WHERE account_id = 4;

DELETE from account WHERE account_id = 5;


SELECT * FROM Transaction WHERE amount> 1000;

UPDATE Transaction SET amount = 2500.00 WHERE transaction_id = 9;

DELETE FROM Transaction WHERE transaction_id = 8;


SELECT * FROM Balance WHERE Current_balance > 10000;

UPDATE Balance SET Current_balance = 12000.00 WHERE balance_id =6

DELETE FROM customer WHERE customer_id = 4;
