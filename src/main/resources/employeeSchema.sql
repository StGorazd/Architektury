DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees(
    id             INT         NOT NULL AUTO_INCREMENT,
    first_name     VARCHAR(45) NOT NULL,
    surname        VARCHAR(45) NOT NULL,
    email          VARCHAR(45) NOT NULL,
    address        VARCHAR(45) NOT NULL,
    age            INT         NOT NULL,
    employee_since DATE        NOT NULL,
    position       INT         NOT NULL,
    salary_bonus   DECIMAL     NOT NULL,
    team_id        INT         NOT NULL,
    PRIMARY KEY (id)
);
