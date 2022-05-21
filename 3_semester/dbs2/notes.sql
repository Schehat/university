-- 2 - Sortierung & Unterabfragen
CREATE VIEW mr AS SELECT id, title, year, type, votes, rating
FROM moviedb.movie m JOIN moviedb.rating r ON (m.id = r.movie);

SELECT max(votes) as m, year FROM mr
GROUP BY type, year
ORDER BY m DESC;

SELECT
ROW_NUMBER() OVER (ORDER BY Rating DESC) AS rn,
title
FROM mr
WHERE type = 'C';

-- 2 - Maximumsbildung
SELECT * FROM mr JOIN 
    (SELECT year, max(rating) rating FROM mr WHERE type = 'C' GROUP BY year)
X ON (mr.rating = X.rating and mr.year = X.year)
ORDER BY X.year;

-- 2 - hierarchische abfragen
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

-- 2 - analytische Funktionen
SELECT * FROM (
SELECT row_number() OVER (PARTITION BY year ORDER BY rating DESC) rn,
mr.* FROM mr )
WHERE rn = 1;

-- shit ue
SELECT count(DISTINCT m.title)
FROM moviedb.movie m
LEFT JOIN moviedb.directs d ON m.id = d.movie
WHERE d.movie IS NULL;

SELECT count(DISTINCT m.title
FROM moviedb.movie m
WHERE not EXISTS(
            SELECT *
            FROM moviedb.directs 
            WHERE m.id = movie
);

SELECT sum(b.budget) as summe, min(b.budget) as min, max(b.budget) as max
FROM moviedb.movie m
JOIN moviedb.budget b ON m.id = b.movie
WHERE m.year = 1989 and b.currency_symbol like '%USD%'
GROUP BY m.year;

SELECT person.id, person.name
FROM moviedb.person 
JOIN moviedb.directs d ON person.id = d.director
JOIN moviedb.plays plays ON person.id = plays.player
-- damit distinct
GROUP BY person.id, person.name;

SELECT person.id, person.name
FROM moviedb.person person
WHERE person.id IN (
    SELECT d.director
    FROM moviedb.directs d
    FULL JOIN moviedb.plays plays ON d.director = plays.player
    WHERE d.director IS NULL OR plays.player IS NULL
)
OR person.id IN (
    SELECT plays.player
    FROM moviedb.directs d
    FULL JOIN moviedb.plays plays ON d.director = plays.player
    WHERE d.director IS NULL OR plays.player IS NULL
);

DROP TABLE a2;

CREATE TABLE a2 (
    id int,
    wert1 int,
    wert2 int
);

INSERT ALL
   INTO a2 VALUES (1, 3, 2)
   INTO a2 VALUES (2, 5, 8)
   INTO a2 VALUES (3, 4, 10)
   INTO a2 VALUES (4, 1, 1)
   INTO a2 VALUES (5, 2, 8)
   INTO a2 VALUES (6, 5, 4)
   INTO a2 VALUES (7, 4, 9)
   INTO a2 VALUES (8, 4, 9)
   INTO a2 VALUES (9, 4, 6)
   INTO a2 VALUES (10, 2, 8)
SELECT 1 FROM DUAL;

SELECT id, wert1, wert2, 
ROW_NUMBER() OVER (ORDER BY WERT1) as a, 
RANK() OVER (ORDER BY WERT1) as b, 
DENSE_RANK() OVER (ORDER BY WERT1) as c,
ROW_NUMBER() OVER (PARTITION BY WERT1 ORDER BY WERT2) as d,
RANK() OVER (PARTITION BY WERT1 ORDER BY WERT2) as e, 
DENSE_RANK() OVER (PARTITION BY WERT1 ORDER BY WERT2) as f, 
SUM(WERT2) OVER (PARTITION BY WERT1) as g, 
SUM(WERT2) OVER (PARTITION BY WERT1 ORDER BY ID) as h
FROM a2
ORDER BY ID;