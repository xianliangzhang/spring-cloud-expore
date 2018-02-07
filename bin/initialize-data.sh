#!/bin/sh

curl 'http://localhost:8010/customer/register?name=dog&email=dog@qq.com'
curl 'http://localhost:8010/customer/register?name=cat&email=cat@qq.com'
curl 'http://localhost:8010/customer/register?name=mule&email=mule@qq.com'
curl 'http://localhost:8010/customer/register?name=duck&email=duck@qq.com'

curl 'http://localhost:8020/product/create?name=robot&sellingPrice=1.1&originalPrice=0.8'
curl 'http://localhost:8020/product/create?name=iphone&sellingPrice=8.3&originalPrice=4.6='
curl 'http://localhost:8020/product/create?name=mac&sellingPrice=4.1&originalPrice=1.8'

curl -H "Content-Type:application/json" -X POST -d '{"cid": 1, "items": [{"pid": 1, "count": 2}]}' 'http://localhost:8030/order/submit'