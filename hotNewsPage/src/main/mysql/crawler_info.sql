-- auto-generated definition
CREATE TABLE crawler_info
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  start_date DATE        NOT NULL,
  final_date DATE        NULL,
  count      INT         NULL,
  state      VARCHAR(45) NOT NULL,
  message    VARCHAR(45) NOT NULL
);
