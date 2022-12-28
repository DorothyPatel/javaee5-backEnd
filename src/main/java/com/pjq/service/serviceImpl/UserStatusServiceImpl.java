package com.pjq.service.serviceImpl;

import com.pjq.mapper.UserMapper;
import com.pjq.pojo.R;
import com.pjq.pojo.User;
import com.pjq.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public R login(String username, String password) {
        //根据用户名和密码在数据库中找数据
        //找到了，准予登录；找不到，返回错误提示信息。
        int count = userMapper.selectByUsernameAndPassword(username, password);
        if(count == 1){
            User user = userMapper.queryUser(username);
            int updateStatus = userMapper.updateStatus(1, username);
            System.out.println(user.getIntroduction());
            if(updateStatus == 1)  {
                Date date = new Date();
                Long token = date.getTime();
                return R.success("登录成功！",user,token);
            }
                else return R.error("用户存在但是登录异常,请重试");
        }else {
            return R.error("您的用户名或者密码错误，请重试！");
        }
    }
    @Override
    public R checkUsername(String username){

        User user = userMapper.queryUser(username);
        System.out.println(username);
        System.out.println(1);
//        System.out.println(user.toString());
        if(user == null){
            return R.success("username ok");
        }else{
            return R.error("username dupuliktdd");
        }
    }
    @Override
    public R signUp(User user){
        //反正前后端都会验证数据，先不管
        //用户名查重在之前做完了，所以这一步默认是新的用户名和合法的数据
        //接收由controller封装好的User
        user.setHeadphoto("");
        user.setRegistTime(new Date());
        user.setStatus(0);
        int i = userMapper.addUser(user);
        if(i == 1) return R.success("注册成功，为您跳转到登录界面");
        else return R.error("登录失败，请重新尝试");
    }
    @Override
    public R exitSystem(String username){
        int i = userMapper.updateStatus(0, username);
        if(i == 1) return R.success("退出成功");
            else return R.error("退出异常，请重试");
    }

}
