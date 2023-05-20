DROP TABLE IF EXISTS Positions;
CREATE TABLE Positions
(
    id            INT         NOT NULL AUTO_INCREMENT,
    department_id INT         NOT NULL,
    name          VARCHAR(45) NOT NULL,
    base_salary   DECIMAL     NOT NULL,
    PRIMARY KEY (id)
);