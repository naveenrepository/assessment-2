USE testdb;

DELIMITER $$

CREATE PROCEDURE SAVE_EMPLOYEE(IN firstName VARCHAR(20), IN lastName VARCHAR(20),
                                 IN username VARCHAR(20), IN department_dept_id INTEGER, IN manager_id INTEGER)
BEGIN
    INSERT INTO Employee (first_name, last_name, username, department_dept_id, manager_id)
    VALUES (firstName, lastName,username, department_dept_id, manager_id);
END $$

CREATE PROCEDURE GET_EMPLOYEE (IN username VARCHAR(20), IN manager_id INTEGER, IN department_id INTEGER)
BEGIN
select e.emp_id from employee e
where e.username = username AND e.manager_id = manager_id AND e.department_dept_id = department_id;
END $$

CREATE PROCEDURE DELETE_EMPLOYEE_BY_ID(IN id INTEGER(20))
BEGIN
DELETE FROM employee e where e.emp_id=id;
END $$

CREATE PROCEDURE UPDATE_EMPLOYEE_BY_ID(IN id INTEGER(20),IN first_name VARCHAR(255),
IN last_name VARCHAR(255),IN user_name VARCHAR(255),IN dept_id INTEGER(20),IN manager_id INTEGER(20))
BEGIN
UPDATE employee e
SET e.first_name = first_name, e.last_name = last_name, e.username = user_name, e.department_dept_id = dept_Id,e.manager_id = manager_id
WHERE e.emp_id = id;
END $$

CREATE PROCEDURE ADD_DEPARTMENT(IN department_name VARCHAR(255))
BEGIN
insert into Department(name)
values (department_name);
END $$

CREATE PROCEDURE DEPARTMENTS()
BEGIN
select * from department;
END $$

CREATE PROCEDURE UPDATE_DEPARTMENT_BY_ID(IN dept_Id INTEGER(20),IN department_name VARCHAR(255))
BEGIN
UPDATE department d
SET d.name = department_name
WHERE d.dept_id = dept_Id ;
END $$

DELIMITER ;