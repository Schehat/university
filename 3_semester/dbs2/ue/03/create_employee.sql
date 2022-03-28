DROP TABLE employee;
DROP SEQUENCE employee_seq;

CREATE TABLE employee(
    employee_id NUMBER,
    name VARCHAR(100),
    dept VARCHAR(100),
    CONSTRAINT pk_employee PRIMARY KEY(employee_id)
);

CREATE SEQUENCE employee_seq;

SELECT * 
FROM employee;
commit;