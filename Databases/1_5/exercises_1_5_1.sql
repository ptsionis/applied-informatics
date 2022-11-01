-- 1.5.1
SELECT c.Name AS country, cl.Language AS language, cl.Percentage AS prc_language
FROM world.countrylanguage cl INNER JOIN world.country c
ON c.Code = cl.CountryCode;

-- 1.5.2
SELECT p.productName AS name, pl.textDescription AS product_line, p.quantityInStock AS stock
FROM classicmodels.products p INNER JOIN classicmodels.productlines pl
ON p.productLine = pl.productLine;

-- 1.5.3
SELECT c.customerName AS customer, c.city AS city, SUM(p.amount) AS total_amount, c.creditLimit AS credit_limit
FROM classicmodels.payments p INNER JOIN classicmodels.customers c
ON p.customerNumber = c.customerNumber
WHERE country IN ('USA', 'France')
GROUP BY c.customerName
ORDER BY credit_limit DESC;