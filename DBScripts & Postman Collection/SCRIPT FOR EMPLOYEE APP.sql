create database EmployeeDB
use EmployeeDB;
drop table project;
drop table company;
drop table employee;
select * from employee;
create table project(
project_id INT primary key,
project_title varchar(100),
project_desc varchar(500)
);
create table company(
company_id INT primary key,
company_name varchar(50) not null,
company_addr varchar(200) not null 
);
create table employee(
employee_id INT primary key,
employee_fname varchar(15),
employee_mname varchar(15),
employee_lname varchar(15),
employee_dob DATE,
employee_curr_addr varchar(200),
employee_perm_addr varchar(200),
employee_email_id varchar(80) not null,
employee_contact_no varchar(15) not null,
project_id INT REFERENCES project,
company_id INT REFERENCES company,
);
insert into project values (301,'BREAD FINANCIAL MOBILE APPLICATION','Bread Financial Mobile Application is card service–based application that provides users with secure digital card management, seamless transactions, and reward tracking. It enables easy integration with banking services, supports instant payments, maintains transaction history, and ensures data security with encryption, offering a reliable and user-friendly financial platform');
insert into project values (302,'BREAD FINANCIAL WEB APPLICATION','Bread Financial Web Application is card service–based application that provides users with secure digital card management, seamless transactions, and reward tracking. It enables easy integration with banking services, supports instant payments, maintains transaction history, and ensures data security with encryption, offering a reliable and user-friendly financial platform');
insert into company values (101,'Bread Financial Holdings','Karle hub, Nagavara, Bengaluru, Karnataka, India');
insert into employee values
(836521,'Jatindra','Nath','Mishra','2000-03-26','','Surya Nagar, Balangir, Odisha (767001)','jatindra.mishra.32@gmail.com','+918637250822',301,101);
insert into employee values
(836531,'Divyanshu',null,'Gupta','2001-02-28','','UttarPradesh (560087)','divyanshugupta@gmail.com','+9198635838633',301,101);
insert into employee values
(836536,'Tilak',null,'Rana','2002-05-28','','Jhansi, UttarPradesh (560677)','tilakrana@gmail.com','+9198642526533',302,101);

CREATE PROCEDURE sp_create_employee
    @employee_id INT,
    @employee_fname VARCHAR(15),
    @employee_mname VARCHAR(15) = NULL,
    @employee_lname VARCHAR(15),
    @employee_dob DATE,
    @employee_curr_addr VARCHAR(200),
    @employee_perm_addr VARCHAR(200),
    @employee_email_id VARCHAR(80),
    @employee_contact_no VARCHAR(15),
    @project_id INT,
    @company_id INT
AS
BEGIN
    INSERT INTO employee (
        employee_id, employee_fname, employee_mname, employee_lname,
        employee_dob, employee_curr_addr, employee_perm_addr,
        employee_email_id, employee_contact_no, project_id, company_id
    )
    VALUES (
        @employee_id, @employee_fname, @employee_mname, @employee_lname,
        @employee_dob, @employee_curr_addr, @employee_perm_addr,
        @employee_email_id, @employee_contact_no, @project_id, @company_id
    );
    select * from employee where employee_id = @employee_id;
END;
GO

CREATE PROCEDURE sp_get_employees
AS
BEGIN
    SELECT * FROM employee;
END;
GO
CREATE PROCEDURE sp_get_employee
    @employee_id INT = NULL
AS
BEGIN
    IF @employee_id IS NULL
        SELECT * FROM employee;
    ELSE
        SELECT * FROM employee WHERE employee_id = @employee_id;
END;
GO
CREATE PROCEDURE sp_get_employees_by_projectid
    @project_id INT = NULL
AS
BEGIN
    IF @project_id IS NULL
        SELECT * FROM employee;
    ELSE
        SELECT * FROM employee WHERE project_id = @project_id;
END;
GO
CREATE PROCEDURE sp_update_employee
    @employee_id INT,
    @employee_fname VARCHAR(15) = NULL,
    @employee_mname VARCHAR(15) = NULL,
    @employee_lname VARCHAR(15) = NULL,
    @employee_dob DATE = NULL,
    @employee_curr_addr VARCHAR(200) = NULL,
    @employee_perm_addr VARCHAR(200) = NULL,
    @employee_email_id VARCHAR(80) = NULL,
    @employee_contact_no VARCHAR(15) = NULL,
    @project_id INT = NULL,
    @company_id INT = NULL
AS
BEGIN
    UPDATE employee
    SET
        employee_fname = ISNULL(@employee_fname, employee_fname),
        employee_mname = ISNULL(@employee_mname, employee_mname),
        employee_lname = ISNULL(@employee_lname, employee_lname),
        employee_dob = ISNULL(@employee_dob, employee_dob),
        employee_curr_addr = ISNULL(@employee_curr_addr, employee_curr_addr),
        employee_perm_addr = ISNULL(@employee_perm_addr, employee_perm_addr),
        employee_email_id = ISNULL(@employee_email_id, employee_email_id),
        employee_contact_no = ISNULL(@employee_contact_no, employee_contact_no),
        project_id = ISNULL(@project_id, project_id),
        company_id = ISNULL(@company_id, company_id)
    WHERE employee_id = @employee_id;
    select * from employee where employee_id = @employee_id;
END;
GO
CREATE PROCEDURE sp_delete_employee
    @employee_id INT,
    @isdeleted  INT OUT
AS
BEGIN
    DELETE FROM employee WHERE employee_id = @employee_id;
    SET @isdeleted = @@ROWCOUNT;
END;
GO


select * from employee
update employee set employee_id = 521 where employee_id = 836521;
update employee set employee_id = 531 where employee_id = 836531;
update employee set employee_id = 536 where employee_id = 836536;