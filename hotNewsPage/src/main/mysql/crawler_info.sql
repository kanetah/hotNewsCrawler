-- auto-generated definition
CREATE TABLE crawler_info
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  start_date DATETIME      NOT NULL,
  final_date DATETIME      NULL,
  count      INT           NULL,
  state      VARCHAR(45)   NOT NULL,
  message    VARCHAR(1000) NOT NULL
);
