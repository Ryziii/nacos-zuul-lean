package com.rysiw.nacoslean.core.dao;

import com.rysiw.nacoslean.common.vo.UserVO;
import com.rysiw.nacoslean.core.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserMapper
 * @author Rysiw
 * @date 2022/2/24 20:34
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserEntity getUserById(String id);

    @Insert("INSERT INTO users(id, name, dob, address, description, password, verification_mode)" +
            "VALUES(#{id}, #{name}, #{dob}, #{address}, #{description}, #{password}, #{verificationMode})")
    void insert(UserEntity userEntity);

    @Update("UPDATE users SET name=#{name}, password=#{password}, dob=#{dob}, address=#{address}, description=#{description} WHERE id=#{id}")
    Long update(UserEntity user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    Long delete(String id);

    @Select("SELECT * FROM users WHERE name = #{name}")
    UserEntity getUserByName(String name);

    @Select("SELECT * FROM users")
    List<UserVO> getAll();
}
