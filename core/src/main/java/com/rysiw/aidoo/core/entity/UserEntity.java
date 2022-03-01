package com.rysiw.aidoo.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.annotations.Options;

import java.util.Date;

/**
 * User实体类
 * @author Rysiw
 * @date 2022/2/24 20:27
 */
@Data
public class UserEntity {

    /**
     * 表主键id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

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
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    /**
     * 密码
     */
    private String password;
}
