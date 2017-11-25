# coding=utf-8
import requests
from bs4 import BeautifulSoup
from datetime import datetime
import re
import json
from pymysql.err import IntegrityError
import crawler_attribute

url = 'http://news.sina.com.cn/hotnews/'
connection = crawler_attribute.connection
cursor = connection.cursor()
res = requests.get(url)
res.encoding = 'utf-8'
soup = BeautifulSoup(res.text, 'html.parser')
rank_ajax = "http://comment5.news.sina.com.cn/page/info?version=1&format=json&channel=%s&newsid=%s"
re_src = 'http://[\\S]*.sina.com.cn/[\\S]*/[0-9]{4}-[0-9]{2}-[0-9]{2}/[\\S]*.shtml'


def do():
    href = None
    title = None
    rank = None
    db_flag = False
    news_count = 0
    start_date = datetime.now()
    state = 'general info from python'
    message = 'crawler news.sina on ' + str(start_date)
    print(message)
    cursor.execute(crawler_attribute.insert_crawler_info_sql, [str(start_date), state, message])

    for news in soup.select('a'):
        try:
            if re.match(re_src, news['href']) is not None:
                href = news['href']  # !important
                title = news.text  # !important
                news_res = requests.get(href)
                news_res.encoding = 'utf-8'
                news_soup = BeautifulSoup(news_res.text, 'html.parser')
                content = str(news_soup.select('.article-a__content, #artibody')[0])  # !important
                time_source = news_soup.select('.article-a__time, .time-source, #pub_date, .date')[0].text
                match_time = re.search('\d{4}年\d{2}月\d{2}日\s*\d{2}:\d{2}', time_source).group(0)
                match_time = match_time.replace(" ", "")
                news_time = datetime.strptime(match_time, '%Y年%m月%d日%H:%M')  # !important
                type_select = ".article-a__sourcename, .time-source > span, #media_name, .ent-source"
                news_type = news_soup.select(type_select)[0].text.strip()  # !important
                comments = None
                for meta in news_soup.select("[name='sudameta']"):
                    meta_content = meta['content']
                    if meta_content.find("comment_channel") > -1:
                        comments = meta_content.split(";")
                        comments[0] = comments[0][comments[0].find(":") + 1:]
                        comments[1] = comments[1][comments[1].find(":") + 1:]
                        break
                rank = rank_ajax % (comments[0], comments[1])
                rank = json.loads(str(requests.get(rank).content, encoding="utf-8"))
                rank = rank['result']['count']['total']  # !important
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
