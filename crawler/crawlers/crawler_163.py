# coding=utf-8
import requests
from bs4 import BeautifulSoup
from datetime import datetime
import re
import json
import crawler_attribute

url = 'http://news.163.com/rank/'
insert_news_sql = crawler_attribute.insert_news_sql
connection = crawler_attribute.connection
cursor = connection.cursor()
res = requests.get(url)
soup = BeautifulSoup(res.text, 'html.parser')
rank_ajax = "http://comment.news.163.com/api/v1/products/a2869674571f77b5a0867c3d71db5856/threads/"


def do():
    for news in soup.select('a'):
        try:
            if re.match('^http://\w*\.163\.com/\d{2}/.*$', news['href']) is not None:
                href = news['href']
                title = news.text
                news_res = requests.get(href)
                news_soup = BeautifulSoup(news_res.text, 'html.parser')
                time_source = news_soup.select('.post_time_source')[0].text.split('来源:')
                content = str(news_soup.select('#endText')[0])
                news_time = datetime.strptime(time_source[0].strip(), '%Y-%m-%d %H:%M:%S')
                news_type = time_source[1].strip()
                rank = rank_ajax + href[href.rfind("/") + 1:href.rfind(".")]
                rank = json.loads(str(requests.get(rank).content, encoding="utf-8"))
                rank = rank['cmtAgainst'] + rank['cmtVote'] + rank['rcount']
                cursor.execute(insert_news_sql, [href, title, content, news_time, news_type, rank])
                connection.commit()
                print('commit insert %s' % title)
        except IndexError:
            continue
    return
