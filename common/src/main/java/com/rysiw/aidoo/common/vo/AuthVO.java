package com.rysiw.aidoo.common.vo;

import lombok.Data;

/**
 * 登陆后返回VO
 * @author Rysiw
 * @date 2022/2/25 13:20
 */
@Data
public class AuthVO {
    private String userName;
    private String token;
}
