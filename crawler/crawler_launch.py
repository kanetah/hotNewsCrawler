# coding=utf-8
from crawlers import *
import crawler_attribute

try:
    while True:
        crawler_163.do()
        break
finally:
    crawler_attribute.connection.close()

print("exit")
