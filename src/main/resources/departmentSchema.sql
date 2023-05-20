DROP TABLE IF EXISTS Departments;
CREATE TABLE Departments
(
    id                    INT         NOT NULL AUTO_INCREMENT,
    name                  VARCHAR(45) NOT NULL,
    head_of_department_id INT         NOT NULL,
    PRIMARY KEY (id)
);