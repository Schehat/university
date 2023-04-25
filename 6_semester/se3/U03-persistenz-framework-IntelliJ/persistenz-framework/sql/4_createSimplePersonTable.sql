-- ============================================================
--   Sequence: myID
-- ============================================================
CREATE SEQUENCE myID;

-- ============================================================
--   Table: PERSON                                             
-- ============================================================
CREATE TABLE PERSON
(
    PERS_ID     VARCHAR2(30)           NOT NULL,
    NAME        VARCHAR2(20)           NULL    ,
    VORNAME     VARCHAR2(20)           NULL    ,
    GEBURTSTAG  DATE                   NULL    ,
    CONSTRAINT PK_PERSON PRIMARY KEY (PERS_ID)
);
