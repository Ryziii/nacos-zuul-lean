# nacos-zuul-lean

## 项目架构
项目采用**nacos**注册中心，**zuul**网关做一个简单Spring Cloud。zuul做鉴权网关过滤流量，token采用**jwt**生成与校验。使用**knife4j**做接口文档输出，结合**mybatis-plus**做user的CRUD。
采用DockerFile部署项目到个人服务器。

## 接口文档
[接口文档地址](./API_doc.md)

## demo地址
~~[http://120.48.9.152:8001](http://120.48.9.152:8001/)~~
(服务器到期,项目中所有地址已无法访问)

可结合接口文档使用postman调用RestfulApi检验

## 可能会用到的东西
在调用api时可能会用到的`token: eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDY3NTEwMDQsImlkIjoiMSJ9.ajzh0yoaGcGf4Yb3Wg3odb1tW2MHOkCVwaPmrl4yyGs`

在login时候可能会用到的`username\password: 小A\123`
