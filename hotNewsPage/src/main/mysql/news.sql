-- auto-generated definition
CREATE TABLE news
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  src     VARCHAR(1000) NOT NULL,
  title   VARCHAR(45)   NOT NULL,
  content LONGTEXT      NOT NULL,
  date    DATETIME      NOT NULL,
  type    VARCHAR(1000) NULL,
  rank    INT           NULL,
  CONSTRAINT id_UNIQUE
  UNIQUE (id),
  CONSTRAINT news_src_uindex
  UNIQUE (src)
);
CREATE INDEX news_date_index
  ON news (date);
