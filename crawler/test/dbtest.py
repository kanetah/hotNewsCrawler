# coding=utf-8
# 导入pymysql的包

import pymysql.cursors

# 获取一个数据库连接，注意如果是UTF-8类型的，需要制定数据库
# port 必须是数字不能为字符串
connection = pymysql.connect(host='localhost', db='hot_news',
                             user='root', password='123456',
                             port=3306, charset='utf8')
try:
    # 获取一个游标
    with connection.cursor() as cursor:
        sql = 'select * from news'
        cout = cursor.execute(sql)
        print("数量： " + str(cout))

        for row in cursor.fetchall():
            print("ID: " + str(row[0]) + '  标题： ' + row[1] + "  内容： " + row[2] + "  时间： " + str(row[3]))
        connection.commit()
finally:
    connection.close()
