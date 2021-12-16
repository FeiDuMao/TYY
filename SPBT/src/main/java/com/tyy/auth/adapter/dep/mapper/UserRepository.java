package com.tyy.auth.adapter.dep.mapper;

import com.tyy.auth.adapter.dep.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {

    @Select("select * from user where username=#{username}}")
    public User LoadUserByUserName(@Param("username") String username);

    @Insert("insert into user values(#{user})")
    public void save(@Param("user") User user);
}
