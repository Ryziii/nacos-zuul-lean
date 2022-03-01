package com.rysiw.aidoo.core.controller;

import com.rysiw.aidoo.common.vo.AuthVO;
import com.rysiw.aidoo.common.vo.ResultVO;
import com.rysiw.aidoo.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rysiw
 * @date 2022/2/25 13:17
 */
@Api(tags = "token")
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登陆接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO<AuthVO> getToken(
            @RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "password", required = true) String password){
        return userService.login(username, password);
    }
}
