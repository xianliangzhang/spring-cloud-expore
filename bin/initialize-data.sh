#!/bin/sh

curl 'http://localhost:8110/customer/register?name=dog&email=dog@qq.com'
curl 'http://localhost:8120/product/create?name=robot&cost=1.1&price=0.8'
curl -H "Content-Type:application/json" -X POST -d '{"cid": 1, "items": [{"pid": 1, "count": 2}]}' 'http://localhost:8130/order/submit'