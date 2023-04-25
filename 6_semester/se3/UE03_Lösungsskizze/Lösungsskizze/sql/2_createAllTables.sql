-- ============================================================
--   Sequence: myID
-- ============================================================
CREATE SEQUENCE myID
  START WITH 1
  INCREMENT BY 1;

-- ============================================================
--   Table: PERSON                                             
-- ============================================================
create table PERSON
(
    PERS_ID     VARCHAR2(30)           not null,
    NAME        VARCHAR2(20)           null    ,
    VORNAME     VARCHAR2(20)           null    ,
    GEBURTSTAG  DATE                   null    ,
    constraint PK_PERSON primary key (PERS_ID)
);

-- ============================================================
--   Table: ADRESSE                                            
-- ============================================================
create table ADRESSE
(
    ADR_ID      VARCHAR2(30)           not null,
    ZIP         INTEGER                null    ,
    ORT         VARCHAR2(21)           null    ,
    STRASSE     VARCHAR2(25)           null    ,
    constraint PK_ADRESSE primary key (ADR_ID)
);

-- ============================================================
--   Table: WOHNT_IN                                           
-- ============================================================
create table WOHNT_IN
(
    PERS_ID     VARCHAR2(30)           not null,
    ADR_ID      VARCHAR2(30)           not null,
    constraint PK_WOHNT_IN primary key (PERS_ID, ADR_ID)
);

-- ============================================================
--   Index: WOHNT_IN_FK2                                       
-- ============================================================
create index WOHNT_IN_FK2 on WOHNT_IN (PERS_ID asc);

-- ============================================================
--   Index: WOHNT_IN_FK                                        
-- ============================================================
create index WOHNT_IN_FK on WOHNT_IN (ADR_ID asc);

alter table WOHNT_IN
    add constraint FK_WOHNT_IN_WOHNT_IN_PERSON foreign key  (PERS_ID)
       references PERSON (PERS_ID);

alter table WOHNT_IN
    add constraint FK_WOHNT_IN_WOHNT_IN_ADRESSE foreign key  (ADR_ID)
       references ADRESSE (ADR_ID);

