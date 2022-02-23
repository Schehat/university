DROP TABLE Zootiere;

create table Zootiere(
	tier_id number(8) primary key,
	name varchar(20),
	art varchar(20),
	gewicht number(8) --in kg
);

INSERT INTO Zootiere VALUES(1, 'a', 'Hund', 50);
INSERT INTO Zootiere VALUES(2, 'b', 'Hund', 70);
INSERT INTO Zootiere VALUES(3, 'c', 'Pferd', 100);
INSERT INTO Zootiere VALUES(4, 'd', 'Pferd', 120);
INSERT INTO Zootiere VALUES(5, 'e', 'Elefant', 150);
INSERT INTO Zootiere VALUES(6, 'f', 'Elefant', 180);

--a)
SELECT name
FROM Zootiere
WHERE gewicht > 100;

--b)
SELECT art
FROM Zootiere
GROUP BY art
HAVING avg(gewicht) > 100;

--c)
WITH SQ AS (
    SELECT art
    FROM Zootiere
    GROUP BY art
    HAVING avg(gewicht) > 100
)
SELECT name 
FROM Zootiere
WHERE art IN (SELECT * FROM SQ);

--d
WITH SQ AS (
    SELECT art, AVG(gewicht) OVER (PARTITION BY art) as avg_gewicht
    FROM Zootiere
)
SELECT name 
FROM Zootiere
WHERE art IN (SELECT art FROM SQ WHERE avg_gewicht > 100);

