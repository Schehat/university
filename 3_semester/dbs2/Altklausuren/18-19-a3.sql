--a)
CREATE TABLE Moebelstueck (
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100)
);

CREATE TABLE Tisch(
    id NUMBER primary key,
    flaeche NUMBER,
    foreign key (id) references Moebelstueck(id)
);

CREATE TABLE Schrank(
    id NUMBER primary key,
    volumen NUMBER,
    foreign key (id) references Moebelstueck(id)
);

DROP TABLE Tisch;
DROP TABLE Schrank;
DROP TABLE Moebelstueck;

--b)
CREATE TABLE Moebelstueck (
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100)
);

CREATE TABLE Tisch(
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100),
    flaeche NUMBER
);

CREATE TABLE Schrank(
    id NUMBER primary key,
    name VARCHAR(100),
    stil VARCHAR(100),
    volumen NUMBER
);

