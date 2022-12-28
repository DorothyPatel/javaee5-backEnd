package com.pjq.mapper;

import com.pjq.pojo.User;
import com.pjq.pojo.UserChangeInfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    List<User> queryAllUser();
    User queryUser(String username);
    List<User> queryUserVague(String username);
    User queryUserById(int id);
    List<String> queryAllUsername();
    int addUser(User user);
    int updateStatus(@Param("status") int status,@Param("username") String username);
    int updateUser(UserChangeInfor user);
    int updatePassword(@Param("username") String username,@Param("password") String password);
    int updateHeadPhoto(@Param("username") String username,@Param("headphoto") String headphoto);
}
