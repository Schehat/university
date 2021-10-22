DROP TABLE Genre;
DROP TABLE Movie;
DROP TABLE MvoieCharacter;
DROP TABLE Person;

CREATE TABLE Genre (
    GenreID INTEGER,
    Genre VARCHAR(100),
    CONSTRAINT pk_genre PRIMARY KEY (GenreID)
);

CREATE TABLE Movie (
    MovieID INTEGER,
    Title VARCHAR(100),
    Year INTEGER,
    Type CHAR(1),
    CONSTRAINT pk_movie PRIMARY KEY (MovieID)
);

CREATE TABLE hasGenre(
    GenreID INTEGER,
    MovieID INTEGER,
    CONSTRAINT fk_to_genre FOREIGN KEY (GenreID) REFERENCES Genre(GenreID),
    CONSTRAINT fk_to_movie FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    CONSTRAINT pk_has_genre PRIMARY KEY (GenreID, MovieID)
);

CREATE TABLE MovieCharacter (
    MovCharID INTEGER,
    MovieID INTEGER,
    PersonID INTEGER,
    Character VARCHAR(100),
    Alias VARCHAR(100),
    Position INTEGER,
    CONSTRAINT fk_to_movie FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    CONSTRAINT fk_to_person FOREIGN KEY (PersonID) REFERENCES Person(PersonID),
    CONSTRAINT pk_mov_char PRIMARY KEY (MovCharID)
);

CREATE TABLE Person (
    PersonID INTEGER,
    Name VARCHAR(100),
    Sex CHAR(1),
    CONSTRAINT pk_person PRIMARY KEY (PersonID)
);

commit;