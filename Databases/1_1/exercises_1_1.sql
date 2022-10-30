-- 1.1.1
SELECT customerName, contactFirstName, contactLastName
FROM classicmodels.customers;

-- 1.1.2
SELECT CONCAT(contactFirstName, " ", contactLastName) AS contact_person
FROM classicmodels.customers;

-- 1.1.3
SELECT DISTINCT country
FROM classicmodels.customers;

-- 1.1.4
SELECT
	AVG(creditLimit) AS average_credit_limit,
    MIN(creditLimit) AS min_credit_limit,
    MAX(creditLimit) AS max_credit_limit
FROM classicmodels.customers;