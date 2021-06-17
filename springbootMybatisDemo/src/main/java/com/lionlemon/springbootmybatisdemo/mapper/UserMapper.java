package com.lionlemon.springbootmybatisdemo.mapper;


import com.lionlemon.springbootmybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这是一个mybatis的mapper类===@MapperScan(包名)
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    int addUser(User user);
}
