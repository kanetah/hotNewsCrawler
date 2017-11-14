-- auto-generated definition
CREATE TABLE user
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  name     VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  CONSTRAINT id_UNIQUE
  UNIQUE (id),
  CONSTRAINT name_UNIQUE
  UNIQUE (name)
);
