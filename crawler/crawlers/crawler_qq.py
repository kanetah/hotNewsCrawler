# coding=utf-8
import requests
import urllib.request
from bs4 import BeautifulSoup
from datetime import datetime
import re
import json
from pymysql.err import IntegrityError
import crawler_attribute

url = 'http://news.qq.com/articleList/ranking/'
connection = crawler_attribute.connection
cursor = connection.cursor()
res = requests.get(url)
soup = BeautifulSoup(res.text, 'html.parser')
rank_ajax = "http://coral.qq.com/article/%s/comment?commentid=0&reqnum=1&tag=&callback=mainComment&_=1389623278900"
re_src = '^http://[\\S]*.qq.com/a/[0-9]{8}/[0-9]*.htm'


def do():
    href = None
    title = None
    rank = None
    db_flag = False
    news_count = 0
    start_date = datetime.now()
    state = 'general info from python'
    message = 'crawler news.qq on ' + str(start_date)
    print(message)
    cursor.execute(crawler_attribute.insert_crawler_info_sql, [str(start_date), state, message])

    for news in soup.select('a'):
        try:
            if re.match(re_src, news['href']) is not None:
                href = news['href']  # !important
                news_res = requests.get(href)
                news_soup = BeautifulSoup(news_res.text, 'html.parser')
                title = news_soup.select('.hd > h1')[0].text  # !important
                content = str(news_soup.select('.bd')[0])  # !important #Cnt-Main-Article-QQ, .qq_article
                time_source = news_soup.select('.a_Info > .a_time')[0].text
                match_time = re.search('\d{4}-\d{2}-\d{2} \d{2}:\d{2}', time_source).group(0)
                news_time = datetime.strptime(match_time, '%Y-%m-%d %H:%M')  # !important
                news_type = news_soup.select('.a_Info > .a_catalog')[0].text  # !important
                for script in news_soup.select('script'):
                    cmt_date = re.search('cmt_id = (.+?);', script.text)
                    if cmt_date is not None:
                        cmt_id = cmt_date.group(0).replace('cmt_id = ', '').replace(';', '')
                        rank = rank_ajax % cmt_id
                        rank = urllib.request.urlopen(rank).read()
                        rank = str(rank, encoding="utf-8")
                        rank = rank[rank.find('mainComment(') + 12:rank.rfind(')')]
                        rank = json.loads(rank)
                        rank = rank['data']['total']  # !important
                if rank is None:
                    continue
                args = [href, title, content, news_time, news_type, rank]
                cursor.execute(crawler_attribute.insert_news_sql, args)
                print('commit insert %s' % title)
                db_flag = True
        except IntegrityError:
            cursor.execute(crawler_attribute.update_rank_sql, [rank, href])
            print("update %s rank: %s" % (title, rank))
            db_flag = True
        except Exception:
            continue
        finally:
            if db_flag:
                connection.commit()
                news_count += 1

    cursor.execute(crawler_attribute.update_crawler_info_sql, [str(datetime.now()), news_count, message])
    connection.commit()
    return
