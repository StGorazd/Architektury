DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees
(
    id             INT         NOT NULL AUTO_INCREMENT,
    first_name     VARCHAR(45) NOT NULL,
    surname        VARCHAR(45) NOT NULL,
    email          VARCHAR(45) NOT NULL,
    address        VARCHAR(45) NOT NULL,
    age            INT         NOT NULL,
    employee_since DATE        NOT NULL,
    position       INT         NOT NULL,
    salary_bonus   DECIMAL     NOT NULL,
    team_id        INT         NOT NULL
);

DROP TABLE IF EXISTS Departments;
CREATE TABLE Departments
(
    id                    INT         NOT NULL AUTO_INCREMENT,
    name                  VARCHAR(45) NOT NULL,
    head_of_department_id INT         NOT NULL
);

DROP TABLE IF EXISTS Teams;
CREATE TABLE Teams
(
    id             INT NOT NULL AUTO_INCREMENT,
    team_leader_id INT NOT NULL,
    department_id  INT NOT NULL
);

DROP TABLE IF EXISTS Positions;
CREATE TABLE Positions
(
    id            INT         NOT NULL AUTO_INCREMENT,
    department_id INT         NOT NULL,
    name          VARCHAR(45) NOT NULL,
    base_salary   DECIMAL     NOT NULL
);

