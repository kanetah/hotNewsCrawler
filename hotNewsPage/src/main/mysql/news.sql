-- auto-generated definition
CREATE TABLE news
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  src     TEXT          NOT NULL,
  title   VARCHAR(45)   NOT NULL,
  content LONGTEXT      NOT NULL,
  date    DATETIME      NOT NULL,
  type    VARCHAR(1000) NULL,
  rank    INT           NULL,
  CONSTRAINT id_UNIQUE
  UNIQUE (id)
);
CREATE INDEX news_date_index
  ON news (date);
