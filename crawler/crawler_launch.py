# coding=utf-8
from crawlers import *
import crawler_attribute
import time

try:
    while True:
        crawler_163.do()
        crawler_sina.do()
        crawler_qq.do()
        time.sleep(30 * 60 * 1000)
finally:
    crawler_attribute.connection.close()
    print("exit")
