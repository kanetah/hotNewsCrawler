# coding=utf-8
import requests
from bs4 import BeautifulSoup
from datetime import datetime
import re
import json
from pymysql.err import IntegrityError
import crawler_attribute

url = 'http://news.163.com/rank/'
connection = crawler_attribute.connection
cursor = connection.cursor()
res = requests.get(url)
soup = BeautifulSoup(res.text, 'html.parser')
rank_ajax = "http://comment.news.163.com/api/v1/products/a2869674571f77b5a0867c3d71db5856/threads/%s"
re_src = '^http://\w*\.163\.com/\d{2}/.*$'


def do():
    href = None
    title = None
    rank = None
    db_flag = False
    news_count = 0
    start_date = datetime.now()
    state = 'general info from python'
    message = 'crawler news.163 on ' + str(start_date)
    print(message)
    cursor.execute(crawler_attribute.insert_crawler_info_sql, [str(start_date), state, message])

    for news in soup.select('a'):
        try:
            if re.match(re_src, news['href']) is not None:
                href = news['href']  # !important
                title = news.text  # !important
                news_res = requests.get(href)
                news_soup = BeautifulSoup(news_res.text, 'html.parser')
                content = str(news_soup.select('#endText')[0])  # !important
                time_source = news_soup.select('.post_time_source')[0].text.split('来源:')
                match_time = re.search('\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}', time_source[0]).group(0)
                news_time = datetime.strptime(match_time, '%Y-%m-%d %H:%M:%S')  # !important
                news_type = time_source[1].strip()  # !important
                rank = rank_ajax % href[href.rfind("/") + 1:href.rfind(".")]
                rank = json.loads(str(requests.get(rank).content, encoding="utf-8"))
                rank = rank['cmtAgainst'] + rank['cmtVote'] + rank['rcount']  # !important
                args = [href, title, content, news_time, news_type, rank]
                cursor.execute(crawler_attribute.insert_news_sql, args)
                print('commit insert %s' % title)
                db_flag = True
        except IntegrityError:
            cursor.execute(crawler_attribute.update_rank_sql, [rank, href])
            print("update %s rank: %s" % (title, rank))
            db_flag = True
        except IndexError:
            continue
        except KeyError:
            continue
        finally:
            if db_flag:
                connection.commit()
                news_count += 1

    cursor.execute(crawler_attribute.update_crawler_info_sql, [str(datetime.now()), news_count, message])
    connection.commit()
    return
