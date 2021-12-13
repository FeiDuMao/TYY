package com.tyy.adapter.dep.mapper;

import com.tyy.adapter.dep.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    @Select("select *from user where username=#{username}")
    public User LoadUserByUserName(@Param("username")String username);

}
