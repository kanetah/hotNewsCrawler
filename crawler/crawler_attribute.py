# coding=utf-8
import pymysql.cursors

connection = pymysql.connect(host='localhost', db='hot_news',
                             user='root', password='123456',
                             port=3306, charset='utf8')


insert_news_sql = 'INSERT INTO news(src, title, content, date, type, rank) VALUES (%s, %s, %s, %s, %s, %s)'
update_rank_sql = 'UPDATE news SET rank=%s WHERE src=%s'
insert_crawler_info_sql = 'INSERT INTO crawler_info(start_date, state, message) VALUES (%s, %s, %s)'
update_crawler_info_sql = 'UPDATE crawler_info SET final_date=%s, count=%s WHERE message=%s'
