Create Table teams(
    team_id number primary key,
    team_name varchar(100),
    liga_name varchar(100),
    Punkte number,
    Tordifferenz number
);

INSERT INTO teams VALUES(1, 'a', 'A', 30, 2);
INSERT INTO teams VALUES(2, 'b', 'A', 35, 5);
INSERT INTO teams VALUES(3, 'c', 'A', 41, 10);
INSERT INTO teams VALUES(4, 'd', 'B', 39, 3);
INSERT INTO teams VALUES(5, 'e', 'B', 45, 8);
INSERT INTO teams VALUES(6, 'f', 'B', 50, 12);
INSERT INTO teams VALUES(7, 'g', 'C', 45, 9);
INSERT INTO teams VALUES(8, 'h', 'C', 52, 13);
INSERT INTO teams VALUES(9, 'j', 'C', 59, 20);

--a
SELECT * 
FROM teams 
WHERE Punkte > 40;

--b
SELECT COUNT(*), liga_name
FROM teams
GROUP BY liga_name;
