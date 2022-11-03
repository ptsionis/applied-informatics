-- 1.5.4
SELECT f.title AS movie
FROM sakila.film_category fc
	INNER JOIN sakila.category c
		ON fc.category_id = c.category_id
	INNER JOIN sakila.film f
		ON fc.film_id = f.film_id
WHERE
	f.rating NOT IN ('R', 'NC-17')
    AND f.length BETWEEN 60 AND 90
    AND f.description REGEXP 'boring|love|documentary'
    AND replacement_cost <= 14
    AND c.name IN ('Travel', 'Family', 'Comedy', 'Classics');
    
-- 1.5.5
SELECT DISTINCT c.name AS categories
FROM sakila.film_actor fa
	INNER JOIN sakila.actor a
		ON fa.actor_id = a.actor_id
	INNER JOIN sakila.film f
		ON fa.film_id = f.film_id
        INNER JOIN sakila.film_category fc
			ON f.film_id = fc.film_id
		INNER JOIN sakila.category c
			ON fc.category_id = c.category_id
WHERE
	a.first_name = 'Julia' AND a.last_name = 'Fawcett';