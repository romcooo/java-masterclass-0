DROP TABLE IF EXISTS officer;
CREATE TABLE officer
(
  id         INT         NOT NULL AUTO_INCREMENT,
  rank       VARCHAR(20) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);