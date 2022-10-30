-- 1.2.1
SELECT SUM(quantityOrdered * priceEach) AS sum_total_price
FROM classicmodels.orderdetails
WHERE orderNumber BETWEEN 10100 AND 10199;

-- 1.2.2
SELECT productName
FROM classicmodels.products
WHERE productLine IN ('Vintage Cars', 'Planes')
	AND productScale IN ('1:18', '1:32', '1:50')
ORDER BY buyPrice DESC
LIMIT 5;

-- 1.2.3
SELECT city, phone, postalCode
FROM classicmodels.offices
WHERE state IS NULL
	AND country IN ('Japan', 'UK');