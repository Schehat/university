-- 20/21 a3
DROP TABLE fahrrad;
DROP TABLE kunde;

CREATE TABLE kunde(
    kunde_id NUMBER,
    CONSTRAINT pk_kunde primary key (kunde_id)
);

CREATE TABLE fahrrad (
    fahrrad_id NUMBER,
    kunde_id NUMBER,
    CONSTRAINT pk_fahrrad primary key (fahrrad_id),
    CONSTRAINT fk_kunde_id foreign key (kunde_id) references kunde(kunde_id)
);

INSERT INTO kunde VALUES(1);
INSERT INTO kunde VALUES(2);
INSERT INTO fahrrad VALUES(1, 1);
INSERT INTO fahrrad VALUES(2, NULL);

commit;

SELECT * FROM fahrrad;
SELECT * FROM kunde;