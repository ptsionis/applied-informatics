-- 1.3.1
SELECT city, COUNT(*) AS customers
FROM classicmodels.customers
WHERE country = 'USA'
GROUP BY city
ORDER BY customers DESC;

-- 1.3.2
SELECT productVendor, SUM(quantityInStock * buyPrice) AS total_price
FROM classicmodels.products
GROUP BY productVendor
HAVING total_price > 2500000
ORDER BY total_price DESC;