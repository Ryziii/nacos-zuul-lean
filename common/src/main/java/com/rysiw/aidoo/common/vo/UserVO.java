package com.rysiw.aidoo.common.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * User返回VO，隐去敏感信息
 * @author Rysiw
 * @date 2022/3/1 22:55
 */
@Data
public class UserVO {


    /**
     * 用户名
     */
    private String name;

    /**
     * 用户生日
     */
    private Date dob;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 创建日期
     */
    private Date createdAt;

}
