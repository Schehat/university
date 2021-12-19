CREATE VIEW mr AS SELECT id, title, year, type, votes, rating
FROM moviedb.movie m JOIN moviedb.rating r ON (m.id = r.movie);

SELECT max(votes) as m, year FROM mr
GROUP BY type, year
ORDER BY m DESC;

SELECT * FROM mr JOIN 
    (SELECT year, max(rating) rating FROM mr WHERE type = 'C' GROUP BY year)
X ON (mr.rating = X.rating and mr.year = X.year)
ORDER BY X.year;

WITH SuccessorCTE(asd, abc, dax) AS (
-- Startpunkt 
SELECT f.movie, f.successor, m.title 
FROM moviedb.follows f
JOIN moviedb.movie m ON f.movie = m.id
WHERE movie = 832174 UNION ALL 
-- Rekursive Abfrage 
SELECT f.movie, f.successor, m.title 
FROM moviedb.follows f JOIN moviedb.movie m ON m.id = f.movie
JOIN SuccessorCTE r ON (r.abc = f.movie)
)
SELECT * FROM SuccessorCTE;

SELECT *
FROM moviedb.movie
WHERE title LIKE 'Star Wars';

SELECT * FROM (
SELECT row_number() OVER (PARTITION BY year ORDER BY rating DESC) rn,
mr.* FROM mr )
WHERE rn = 1;

SELECT DISTINCT m.title
FROM moviedb.movie m
LEFT JOIN moviedb.directs d ON m.id = d.movie
WHERE d.director IS NULL;

SELECT sum(b.budget) as summe, min(b.budget) as min, max(b.budget) as max
FROM moviedb.movie m
JOIN moviedb.budget b ON m.id = b.movie
WHERE m.year = 1989 and b.currency_symbol like '%USD%';
--GROUP BY m.year;

SELECT person.id, person.name
FROM moviedb.person 
JOIN moviedb.directs d ON person.id = d.director
JOIN moviedb.plays plays ON person.id = plays.player
-- damit distinct
GROUP BY person.id, person.name;