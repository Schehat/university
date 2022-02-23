-- 20/21 a3
DROP TABLE Ausleihungen;
DROP TABLE Kunde;
DROP TABLE Fahrrad;

CREATE TABLE Kunde(
    kunde_id NUMBER,
    CONSTRAINT pk_kunde primary key (kunde_id)
);

CREATE TABLE Fahrrad (
    rad_id NUMBER,
    CONSTRAINT pk_rad primary key (rad_id)
);

CREATE TABLE Ausleihungen(
    kunde_id NUMBER,
    rad_id NUMBER,
    CONSTRAINT pk_kunde_rad primary key (kunde_id, rad_id),
    CONSTRAINT fk_kunde_id FOREIGN KEY (kunde_id) REFERENCES Kunde(kunde_id),
    CONSTRAINT fk_rad_id FOREIGN KEY (rad_id) REFERENCES Fahrrad(rad_id)
);

INSERT INTO kunde VALUES(1);
INSERT INTO kunde VALUES(2);
INSERT INTO fahrrad VALUES(1);
INSERT INTO fahrrad VALUES(2);
INSERT INTO Ausleihungen VALUES(1, 1);

commit;

SELECT * FROM Ausleihungen;