package com.rysiw.nacoslean.core.controller;

import com.rysiw.nacoslean.common.utils.ResultUtil;
import com.rysiw.nacoslean.common.vo.ResultVO;
import com.rysiw.nacoslean.common.vo.UserVO;
import com.rysiw.nacoslean.core.entity.UserEntity;
import com.rysiw.nacoslean.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController层，User CRUD RestFul接口
 * @author Rysiw
 * @date 2022/2/24 20:34
 */
@Api(tags = "user")
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation(value = "获取所有用户", httpMethod = "GET")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResultVO<UserEntity> getUsers(){
        return userService.getAll();
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查询用户", httpMethod = "GET")
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResultVO<Object> getUserById(@PathVariable String id){
        UserEntity user = userService.getUserById(id);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        ResultVO result = user == null ?
                ResultUtil.error().buildMessage("无此id用户") :
                ResultUtil.success().buildData(vo);
        return result;
    }

    /**
     * 插入用户
     * @param user
     * @return
     */
    @ApiOperation(value = "插入用户", httpMethod = "POST")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultVO insert(UserEntity user){
        return userService.insertUser(user);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO<Object> updateUser(UserEntity user){
        if(user.getId() == null || user.getId().isEmpty()){
            return ResultUtil.error().buildMessage("请输入id");
        }

        if(userService.update(user)){
            return ResultUtil.success().buildMessage("更新用户成功");
        }else{
            return ResultUtil.error().buildMessage("更新用户失败");
        }
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id删除用户", httpMethod = "DELETE")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResultVO<Object> deleteById(@PathVariable String id){
        return userService.deleteById(id);
    }
}
