import json
import os   #对文件和文件夹进行操作
import time
import copyheaders  # 请求头格式转换
import pandas ###自动化办公库
import requests ###网络请求库
#import pymysql
from lxml import etree  #解析
from sqlalchemy import create_engine
##获取请求头
headers = copyheaders.headers_raw_to_dict(b"""
Accept: */*
Accept-Encoding: gzip, deflate
Accept-Language: zh-CN,zh;q=0.9
Connection: keep-alive
Cookie: qgqp_b_id=4c1935bf08893047c7613caa5369582a; st_si=48110357495405; st_asi=delete; st_pvi=97399857741419; st_sp=2022-01-10%2015%3A02%3A50; st_inirUrl=https%3A%2F%2Fwww.baidu.com%2Flink; st_sn=2; st_psi=20220331100514360-112200304021-0508503389
Host: api.fund.eastmoney.com
Referer: http://fundf10.eastmoney.com/
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36
""")


def get_out_data():
    ###便利页码
    base_api2 = f'http://api.fund.eastmoney.com/f10/lsjz?callback=jQuery1830646963446901029_1648692346747&fundCode=164206&pageIndex=1&pageSize=20&startDate=&endDate=&_=1648692346760'
    res2 = requests.get(base_api2,headers=headers)
    print(res2)
    # for page in range(1, 61):   # 一共60页，一页50份数据，共有三千左右基金经理
    #     ###构造请求地址
    #     base_api = f'http://api.fund.eastmoney.com/f10/lsjz?callback=jQuery1830646963446901029_1648692346747&fundCode=164206&pageIndex=1&pageSize=20&startDate=&endDate=&_=1648692346760'
    #     ###发起网络请求
    #     res = requests.get(
    #         base_api, headers=headers
    #     )   #请求网页
    #     time.sleep(1)
    #     ###获取列表数据
    #     found_list = json.loads(res.text.split("{data:")[-1].split(",record")[0])
    #     print(f"当前页码：{page} 列表数：{len(found_list)}")
        # ###便利列表数据，提取其中的字段值
        # for tr in found_list:
        #     saveitem = {}

        #     saveitem['姓名主页'] = tr[0]
        #     saveitem["姓名"] = tr[1]
        #     saveitem["公司"] = tr[3]
        #     saveitem["现任基金"] =tr[5]
        #     saveitem["从业时长"] = tr[6]
        #     saveitem["任职资产规模"] = tr[-2]
        #     saveitem["现任汇报"] = tr[-1]

        #     print(saveitem)
        #     ###将网页上每一行的数据保存到本地临时文件
        #     with open("temp.txt", "a", encoding='utf-8') as ff:
        #         ff.write(json.dumps(saveitem))
        #         ff.write('\n')


def download_id(item):
    ###构造详情页的请求地址
    base_api = f'http://fund.eastmoney.com/manager/{item.get("姓名主页")}.html'
    ###发起详情页网络请求
    res = requests.get(base_api, headers=headers)
    ###将html字符串转换成xml对象，方便xpath语法提取其中的字段值
    res_ele = etree.HTML(res.content.decode("utf-8"))
    ###获取业绩列表数据
    li_list = res_ele.xpath(".//div[@class='content_out']/div[2]/table/tbody/tr")
    print(f"当前长度：{len(li_list)} link： {base_api}")

    ###便利列表中的每一行，取出对应的值
    for itecm in li_list:
        ###浅拷贝一级页面值
        saveinfo = item.copy()
        saveinfo["基金代码"] = ''.join(itecm.xpath("./td[1]//text()")).strip()
        saveinfo["基金名称"] = ''.join(itecm.xpath("./td[2]//text()")).strip()
        saveinfo["基金类型"] = ''.join(itecm.xpath("./td[3]//text()")).strip()
        saveinfo["近三月"] = ''.join(itecm.xpath("./td[4]//text()")).strip()
        saveinfo["同类排名"] = ''.join(itecm.xpath("./td[5]//text()")).strip()
        saveinfo["近六月"] = ''.join(itecm.xpath("./td[6]//text()")).strip()
        saveinfo["同类排名2"] = ''.join(itecm.xpath("./td[7]//text()")).strip()
        saveinfo["近一年"] = ''.join(itecm.xpath("./td[8]//text()")).strip()
        saveinfo["同类排名3"] = ''.join(itecm.xpath("./td[9]//text()")).strip()
        saveinfo["近两年"] = ''.join(itecm.xpath("./td[10]//text()")).strip()
        saveinfo["同类排名4"] = ''.join(itecm.xpath("./td[11]//text()")).strip()
        saveinfo["今年来"] = ''.join(itecm.xpath("./td[12]//text()")).strip()
        saveinfo["同类排名5"] = ''.join(itecm.xpath("./td[13]//text()")).strip()
        ###打印日志
        print(saveinfo)

        #写入本地临时文件final.txt
        with open("final.txt", "a",encoding='utf-8') as ff:
            ff.write(json.dumps(saveinfo))
            ff.write('\n')



def get_inner_data():
    with open("temp.txt", 'r', encoding='utf-8') as ff:
        jdata = [json.loads(i.strip()) for i in ff.readlines()]
    for item in jdata:
        try:
            download_id(item)
        except Exception as e:
            print(f"网络异常：{e}")
            time.sleep(4)


if  __name__ == '__main__':

    # ##获取基金经理列表数据
    get_out_data()
    # #获取每个基金经理的业绩数据
    # get_inner_data()


    ###判断下载的txt文件是否存在，将其转换成excel格式
    if os.path.exists("final.txt"):
        ##打开文件
        file_obj = open("final.txt")
        ###读取数据
        file = [json.loads(i.strip()) for i in file_obj.readlines()]
        ##关闭文件
        file_obj.close()
        ##将列表数据转换成dataframe
        pd_ = pandas.DataFrame(file)
        ###转换格式导出
        engine = create_engine('mysql+pymysql://root:252781@localhost:3306/基金经理_data?charset=utf8')
        pd_.to_sql("基金经理.sql",engine)
        ###删除临时文件
        os.remove("final.txt")

    if os.path.exists("temp.txt"):
        ##删除临时文件
        os.remove("temp.txt")
