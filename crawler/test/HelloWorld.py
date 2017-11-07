import requests
from bs4 import BeautifulSoup
import pymysql.cursors
from datetime import datetime
import re

connection = pymysql.connect(host='localhost', db='hot_news',
                             user='root', password='123456',
                             port=3306, charset='utf8')
insert_news_sql = 'INSERT INTO news(src, title, content, date, type) VALUES (%s, %s, %s, %s, %s)'

# url = 'http://news.sina.com.cn/china/'
# res = requests.get(url)
# res.encoding = 'UTF-8'
# soup = BeautifulSoup(res.text, 'html.parser')
# try:
#     with connection.cursor() as cursor:
#         for news in soup.select('.news-item'):
#             h2 = news.select('h2')
#             if len(h2) > 0:
#                 time = news.select('.time')[0].text
#                 title = h2[0].text
#                 href = h2[0].select('a')[0]['href']
#                 news_res = requests.get(href)
#                 news_res.encoding = 'UTF-8'
#                 news_soup = BeautifulSoup(news_res.text, 'html.parser')
#                 content = news_soup.select('#artibody')[0]
#                 sql = 'INSERT INTO news(title, content, date, type) VALUES (%s, %s, %s, %s)'
#                 cursor.execute(sql, [title, str(content), datetime.strptime('2017-' + time, '%Y-%m月%d日 %H:%M'), '时事'])
#                 print('insert %s' % title)
#         connection.commit()
# finally:
#     connection.close()

url = 'http://news.163.com/rank/'
res = requests.get(url)
soup = BeautifulSoup(res.text, 'html.parser')
try:
    with connection.cursor() as cursor:
        for news in soup.select('a'):
            try:
                if re.match('^http://\w*\.163\.com/\d{2}/.*$', news['href']) is not None:
                    href = news['href']
                    title = news.text
                    news_res = requests.get(href)
                    news_soup = BeautifulSoup(news_res.text, 'html.parser')
                    time_source = news_soup.select('.post_time_source')[0].text
                    time_source = time_source.split('来源:')
                    news_time = time_source[0].strip()
                    news_type = time_source[1].strip()
                    content = news_soup.select('#endText')[0]
                    news_time = datetime.strptime(news_time, '%Y-%m-%d %H:%M:%S')
                    cursor.execute(insert_news_sql, [href, title, str(content), news_time, news_type])
                    print('insert %s' % title)
            except IndexError:
                continue
    connection.commit()
finally:
    connection.close()
