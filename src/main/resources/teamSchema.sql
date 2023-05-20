DROP TABLE IF EXISTS Teams;
CREATE TABLE Teams
(
    id             INT NOT NULL AUTO_INCREMENT,
    team_leader_id INT NOT NULL,
    department_id  INT NOT NULL,
    PRIMARY KEY (id)
);
