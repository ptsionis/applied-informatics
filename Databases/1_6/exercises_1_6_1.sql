-- 1.6.1
SELECT f.title AS outOfStock_movie, i.store_id AS store
FROM sakila.film f
LEFT JOIN sakila.inventory i
	ON f.film_id = i.film_id
WHERE i.store_id IS NULL;

-- 1.6.2
SELECT f.title AS movie_title, COUNT(i.film_id) AS total_rents
FROM sakila.film f
LEFT JOIN sakila.inventory i
	ON f.film_id = i.film_id
LEFT JOIN sakila.rental r
	ON i.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY COUNT(i.film_id) DESC;