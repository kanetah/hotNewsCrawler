-- auto-generated definition
CREATE TABLE comment
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  user_id INT  NOT NULL,
  news_id INT  NOT NULL,
  content TEXT NOT NULL,
  CONSTRAINT user_foreign
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT news_foreign
  FOREIGN KEY (news_id) REFERENCES news (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
CREATE INDEX comment_foreign_idx
  ON comment (user_id);
CREATE INDEX news_foreign_idx
  ON comment (news_id);
