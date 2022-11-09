-- 1.8.1
SELECT cn.name AS country_name, ct.Name AS city,
	ct.Population AS population, "Capital" AS description
FROM world.country cn
LEFT JOIN world.city ct
	ON cn.Capital = ct.ID
UNION
SELECT cn.name AS country_name, ct.name AS city,
	MAX(ct.Population) AS population, "Largest city" AS description
FROM world.country cn
LEFT JOIN world.city ct
	ON cn.Code = ct.CountryCode
GROUP BY cn.Code
ORDER BY 1, 4;