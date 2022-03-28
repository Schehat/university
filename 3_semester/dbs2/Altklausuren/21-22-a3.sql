DROP TABLE mitarbeiter;

create table mitarbeiter (
	id number primary key,
	name varchar(100),
	gehalt number,
	bonus number
);

INSERT INTO mitarbeiter VALUES(1, 'a', 1000, 300);
INSERT INTO mitarbeiter VALUES(2, 'b', 1000, NULL);

SELECT * FROM mitarbeiter;

commit;