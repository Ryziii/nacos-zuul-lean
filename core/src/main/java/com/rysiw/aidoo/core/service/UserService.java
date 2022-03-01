package com.rysiw.aidoo.core.service;

import com.rysiw.aidoo.common.vo.AuthVO;
import com.rysiw.aidoo.common.vo.ResultVO;
import com.rysiw.aidoo.core.entity.UserEntity;

/**
 * @author Rysiw
 * @date 2022/2/24 20:41
 */
public interface UserService {

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    UserEntity getUserById(String id);

    /**
     * 插入用户
     * @param userEntity
     * @return
     */
    ResultVO insertUser(UserEntity userEntity);

    /**
     * 更新用户
     * @param userEntity
     * @return
     */
    Boolean update(UserEntity userEntity);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    ResultVO deleteById(String id);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    UserEntity getUserByUsername(String username);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ResultVO<AuthVO> login(String username, String password);

    /**
     * 获取全部用户
     * @return
     */
    ResultVO getAll();
}
