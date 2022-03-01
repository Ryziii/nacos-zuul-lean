# aidoo-test

## 项目架构
项目采用**nacos**注册中心，**zuul**网关做一个简单Spring Cloud。zuul做鉴权网关过滤流量，token采用**jwt**生成与校验。使用**knife4j**做接口文档输出，结合**mybatis-plus**做user的CRUD。
采用DockerFile部署项目到个人服务器。

## 接口文档
[接口文档地址](https://github.com/Ryziii/aidoo-test/blob/master/%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3/%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3markdown.md)

## demo地址
[http://120.48.9.152:8001](http://120.48.9.152:8001/)

## 可能会用到的东西
在调用api时可能会用到的`token: eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDY3NTEwMDQsImlkIjoiMSJ9.ajzh0yoaGcGf4Yb3Wg3odb1tW2MHOkCVwaPmrl4yyGs`

在login时候可能会用到的`username\password: 小A\123`
