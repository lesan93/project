package com.lesan.application.dao;

import com.lesan.application.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password) values (#{username},#{password})")
    public int save(User user);

    @Select("select * from user where id=(#{id})")
    public User getUser(int id);
}
