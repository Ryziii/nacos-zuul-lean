package com.rysiw.aidoo.core.service.impl;

import com.rysiw.aidoo.common.constant.RespCode;
import com.rysiw.aidoo.common.constant.SecurityConstants;
import com.rysiw.aidoo.common.constant.enums.VerificationModeEnum;
import com.rysiw.aidoo.common.utils.AuthUtil;
import com.rysiw.aidoo.common.utils.JwtUtil;
import com.rysiw.aidoo.common.utils.ResultUtil;
import com.rysiw.aidoo.common.vo.AuthVO;
import com.rysiw.aidoo.common.vo.ResultVO;
import com.rysiw.aidoo.common.vo.UserVO;
import com.rysiw.aidoo.core.dao.UserMapper;
import com.rysiw.aidoo.core.entity.UserEntity;
import com.rysiw.aidoo.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * UserService实现类
 * @author Rysiw
 * @date 2022/2/24 20:42
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(String id) {
        UserEntity user = userMapper.getUserById(id);
        log.info("通过id：{}查找用户，查找结果：{}",id, user);
        return user;
    }

    @Override
    public ResultVO insertUser(UserEntity userEntity) {
        try {
            if(userEntity.getName() == null){
                return ResultUtil.error().buildMessage("请输入用户名！");
            }
            userEntity.setPassword( AuthUtil.getEncryptPassword(userEntity.getName(), userEntity.getPassword()) );
            log.info("插入用户{}", userEntity);
            String id = userEntity.getId();
            if (id != null) {
                UserEntity user = getUserById(id);
                if (user != null) {
                    log.info("插入用户失败，用户已存在");
                    return ResultUtil.error().buildMessage("创建用户失败，用户已存在！");
                }
            }
            userEntity.setVerificationMode(VerificationModeEnum.PASSWORD);
            userEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
            userEntity.setCreatedAt(new Date());
            userMapper.insert(userEntity);
            return ResultUtil.success().buildMessage("创建用户成功! ");
        }catch (Exception e){
            log.error("插入用户失败,插入数据:{}",userEntity,e);
            return ResultUtil.error().buildMessage("创建用户失败!");
        }
    }

    @Override
    public Boolean update(UserEntity userEntity) {
        userEntity.setPassword( AuthUtil.getEncryptPassword(userEntity.getName(), userEntity.getPassword()) );
        Long res = userMapper.update(userEntity);
        return res != 0;
    }

    @Override
    public ResultVO deleteById(String id) {
        try {
            return userMapper.delete(id) == 0 ?
                    ResultUtil.error().buildMessage("删除失败，无影响行数。") :
                    ResultUtil.success().buildMessage("删除成功！");
        }catch (Exception e){
            log.error("删除用户失败",e);
            return ResultUtil.custom(RespCode.ERROR.getCode(),"删除失败！", e.getLocalizedMessage());
        }
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        try{
            return userMapper.getUserByName(username);
        }catch (Exception e){
            log.error("查询用户失败，用户名：{}", username, e);
            return null;
        }
    }

    @Override
    public ResultVO<AuthVO> login(String username, String password) {
        
        try {
            UserEntity user = userMapper.getUserByName(username);
            if (user == null) {
                return ResultUtil.error().buildMessage("用户不存在，请检查输入信息！");
            }
            String encryptPwd = AuthUtil.getEncryptPassword(username, password);
            if (!user.getPassword().equals(encryptPwd)) {
                return ResultUtil.error().buildMessage("用户名密码错误，请检查输入！");
            }

            //构建token
            AuthVO vo = new AuthVO();
            String token = JwtUtil.buildJwtToken(new Date(new Date().getTime() + SecurityConstants.EXPIRATION7DAYS * 1000), user.getId());
            vo.setToken(token);
            vo.setUserName(username);
            return ResultUtil.success(vo);
        }catch (Exception e){
            log.error("登陆用户失败", e);
            return ResultUtil.error().buildMessage("登陆失败");
        }
    }

    @Override
    public ResultVO getAll() {
        List<UserVO> list = userMapper.getAll();
        if(list == null){
            return ResultUtil.success().buildMessage("无user数据");
        }
        else{
            return ResultUtil.success().buildData(list);
        }
    }

}
