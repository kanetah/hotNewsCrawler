# coding=utf-8
import pymysql.cursors

connection = pymysql.connect(host='localhost', db='hot_news',
                             user='root', password='123456',
                             port=3306, charset='utf8')
insert_news_sql = 'INSERT INTO news(src, title, content, date, type, rank) VALUES (%s, %s, %s, %s, %s, %s)'
