# Aidoo Test


**简介**:Aidoo Test


**HOST**:http://120.48.9.152:8001/


**联系人**:


**Version**:1.0.0


**接口路径**:/v3/api-docs?group=1.0版本


[TOC]






# token


## 登陆接口


**接口地址**:`/token/login`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|username|username|query|true|string||
|password|password|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«AuthVO»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||AuthVO|AuthVO|
|&emsp;&emsp;token||string||
|&emsp;&emsp;userName||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {
		"token": "",
		"userName": ""
	},
	"msg": ""
}
```


# user


## 通过id删除用户


**接口地址**:`/api/v1/user/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"msg": ""
}
```


## 获取所有用户


**接口地址**:`/api/v1/user/getAll`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«UserEntity»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||UserEntity|UserEntity|
|&emsp;&emsp;address||string||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;description||string||
|&emsp;&emsp;dob||string(date-time)||
|&emsp;&emsp;id||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {
		"address": "",
		"createdAt": "",
		"description": "",
		"dob": "",
		"id": "",
		"name": "",
		"password": ""
	},
	"msg": ""
}
```


## 插入用户


**接口地址**:`/api/v1/user/insert`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|address||query|false|string||
|createdAt||query|false|string(date-time)||
|description||query|false|string||
|dob||query|false|string(date-time)||
|id||query|false|string||
|name||query|false|string||
|password||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"msg": ""
}
```


## 更新用户


**接口地址**:`/api/v1/user/update`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|address||query|false|string||
|createdAt||query|false|string(date-time)||
|description||query|false|string||
|dob||query|false|string(date-time)||
|id||query|false|string||
|name||query|false|string||
|password||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"msg": ""
}
```


## 通过id查询用户


**接口地址**:`/api/v1/user/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||string||
|data||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": "",
	"data": {},
	"msg": ""
}
```