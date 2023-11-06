package com.rysiw.nacoslean.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Rysiw
 * @date 2022/2/24 20:46
 */
@AllArgsConstructor
@Getter
public enum RespCode {

    SUCCESS("200","操作成功!"),
    ERROR("501","操作失败!"),
    UNAUTHORIZED("401","没有权限"),
    TOKEN_ALIVE("A0001", "用户token存活，无需重新注册"),
    CANT_FIND_USER("A0002", "未找到用户"),
    PASSWORD_WRONG("A0003", "密码错误"),
    REDIS_ERROR("A0004", "存入redis错误"),
    JWT_PARSE_ERROR("A0005", "JWT解析异常"),
    AUTH_EXPIRED("A0006","认证到期"),
    TOKEN_DONT_MATCH("A0005", "token与用户名不匹配");

    private final String code;
    private final String msg;
}