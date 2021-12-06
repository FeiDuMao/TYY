package com.example.spbt.mapper;

import com.example.spbt.domain.AuthorizedUser;
import com.example.spbt.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Select("select username,password " +
            "from user " +
            "where username=#{username}")
    public User loadUserByUsername(@Param("username") String username);

    public void UpdateUser();


    @Insert("insert into user" +
            "values()")
    public void registerUser(AuthorizedUser user);
}
