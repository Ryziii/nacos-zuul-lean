## 登陆接口


**接口地址**:`/token/login`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:  通过用户名与密码获取token签名


**请求参数**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| username | username | query    | true     | string   |        |
| password | password | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema           |
| ------ | ------------ | ---------------- |
| 200    | OK           | ResultVO«AuthVO» |
| 201    | Created      |                  |
| 401    | Unauthorized |                  |
| 403    | Forbidden    |                  |
| 404    | Not Found    |                  |


**响应参数**:


| 参数名称             | 参数说明 | 类型   | schema |
| -------------------- | -------- | ------ | ------ |
| code                 |          | string |        |
| data                 |          | AuthVO | AuthVO |
| &emsp;&emsp;token    |          | string |        |
| &emsp;&emsp;userName |          | string |        |
| msg                  |          | string |        |


**响应示例**:
```json
{
	"code": "",
	"data": {
		"token": "",
		"userName": ""
	},
	"msg": ""
}
```