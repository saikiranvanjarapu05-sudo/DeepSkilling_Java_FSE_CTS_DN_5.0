CREATE TABLE employees (
    Emp_Id NUMBER PRIMARY KEY,
   Emp_Name VARCHAR2(50),
    Department VARCHAR2(30),
    salary NUMBER
);

INSERT INTO employees VALUES (1,'Sai','HR',55000);
INSERT INTO employees VALUES (2,'Kiran','Consultancy',45000);
INSERT INTO employees VALUES (3,'Jackie','IT',50000);
INSERT INTO employees VALUES (4,'Sagaram','Finance',60000);

COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    deptName IN VARCHAR2,
    bonusPercent IN NUMBER
)
AS
BEGIN

   UPDATE employees
   SET salary =
       salary + (salary * bonusPercent / 100)
   WHERE Department = deptName;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Bonus Updated Successfully'
   );

END;
/

BEGIN
   UpdateEmployeeBonus('IT',10);
END;
/

SELECT * FROM employees;