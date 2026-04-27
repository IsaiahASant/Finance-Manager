CREATE TABLE TRANSACTIONS  (transactionType NOT NULL, amount NOT NULL, reason NOT NULL, id NOT NULL, source NOT NULL); 

INSERT INTO TRANSACTIONS (transactionType, amount, reason, id, source)
VALUES("Grocery", "500", "Needed a lot of food", "5", "person");