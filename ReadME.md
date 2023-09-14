# Employee Management

## Pre-requisites :
    1. Java 11
    2. Mysql 8
    3. Mysql Workbench
    4. InteliJ IDEA (Or any other java compatible IDE)

## Setup :
    1. Create Database using Workbench or mysql query 'CREATE DATABASE testdb'
    2. Go to 'src/main/resources/application.properties' and change username and password
    3. Go to 'src/main/resources/stored_procedures.sql', Copy the sql script and run it on Workbench.
    (This will create Stored_Procedures in the database to be used in APIs)
    4. Run 'src/main/java/com/proviniti/assessment/AssessmentApplication.java'

## APIs :
    1. POST - localhost:8080/api/employee ( Add Employee )
    Payload : 
    {
        "firstName" : "fname",
        "lastName" : "lname",
        "username" : "username",
        "department" :{
            "deptId" : 1
        },
        "manager" : {
            "empId" : 1
        }
    }

    2. GET -  localhost:8080/api/employee/{username}/{managerName}/{departmentName}
    ( To get Employee with given username, manager name and department name )

    3. DELETE - localhost:8080/api/employee/{id}
    ( Delete Employee with given ID )

    4. PUT - localhost:8080/api/employee ( Update Employee )
    Payload : 
    {
        "empId" : 5,
        "firstName" : "fname",
        "lastName" : "lname",
        "username" : "username",
        "department" :{
            "deptId" : 1
        },
        "manager" : {
            "empId" : 1
        }
    }
    
    5. POST - localhost:8080/api/department ( Add department )
    Payload : 
    {
        "name" : "dept_name"
    }

    6. GET - localhost:8080/api/department/all ( Get All Departments )
    
    7. PUT - localhost:8080/api/department
    Payload : 
    {
        "deptId" : 2,
        "name" : "dept_name"
    }
    
