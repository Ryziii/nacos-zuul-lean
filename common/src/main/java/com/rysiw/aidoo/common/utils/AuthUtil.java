package com.rysiw.aidoo.common.utils;

import cn.hutool.crypto.SecureUtil;

/**
 * Auth工具类
 * @author Rysiw
 * @date 2022/2/25 14:05
 */
public class AuthUtil {

    /**
     * 返回User盐
     * @param username
     * @return
     */
    private static String getUserSalt(String username){
        String[] salts = {"AA","II","DD","OO"};
        int hash = username.hashCode();
        return salts[Math.abs(hash % 4)];
    }

    /**
     * 用"用户名盐+密码"给密码加密
     * @param username
     * @param password
     * @return
     */
    public static String getEncryptPassword(String username, String password){
        String passwordWithSalt = password + getUserSalt(username);
        return SecureUtil.md5(passwordWithSalt);
    }
}
