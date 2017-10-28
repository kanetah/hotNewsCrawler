DELETE FROM news;
DROP TABLE news;

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
	CONSTRAINT id_UNIQUE
	UNIQUE (id)
);

TRUNCATE TABLE news;
