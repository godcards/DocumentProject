package com.yu.dao;

import com.yu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select user_name from user where user_id=#{userId}")
    User SelectUserById(int userId);

    @Select("select user_name, password from user where user_name=#{userName}")
    User SelectUserByName(String userName);

    @Select("select nick_name from user where user_name=#{userName}")
    String SelectNickName(String userName);

    @Insert("insert into user(user_name,password,nick_name) values(#{userName},#{password},#{nickName})")
    int InsertUser(User user);
}
