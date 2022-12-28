package com.pjq.service.serviceImpl;

import com.pjq.mapper.ConcernMapper;
import com.pjq.mapper.PictureMapper;
import com.pjq.mapper.UserMapper;
import com.pjq.pojo.*;
import com.pjq.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInforServiceImpl implements UserInforService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private ConcernMapper concernMapper;
    @Autowired(required = false)
    private PictureMapper pictureMapper;

    @Override
    public R changeUserInfor(UserChangeInfor user) {
//      前端可以通过userstatusService中的方法去获取到用户的信息，即用户登录了就获得了信息，所以这里就不再
        //把用户信息发送给前端了
//        User user1 = userMapper.queryUser(user.getOldusername());
//        System.out.println(user1.toString());
//        user1.setUsername(user.getNewusername());
//        user1.setIntroduction(user.getIntroduction());
//        user1.setProvince(user.getProvince());
//        user1.setQq(user.getQq());
//        user1.setMobile(user.getMobile());
//        user1.setName(user.getName());
//        user1.setGender(Sex.valueOf(user.getGender()));
//        user1.setEmail(user.getEmail());
//        user1.setCity(user.getCity());
        int i = userMapper.updateUser(user);
        if (i == 1){
            User user1 = userMapper.queryUser(user.getNewusername());
            return R.success("更新用户信息成功",user1);
        }
        else return R.error("用户信息更新失败，请重试");
    }

    @Override
    public R changePassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        int i = userMapper.updatePassword(username, password);
        if (i == 1) return R.success("更新用户密码成功");
        else return R.error("用户密码更新失败，请重试");
    }

    @Override
    public R changeHeadPhoto( PicAcc picAcc) {
        String username = picAcc.getUsername();
        String fileName = picAcc.getFname();
        int i = userMapper.updateHeadPhoto(username, fileName);
        if (i == 1) {
            if (fileName.equals("")) {
                return R.success("用户移除头像成功");
            } else return R.success("更新用户头像成功");
        } else return R.error("用户头像更新失败，请重试");
    }

    @Override
    public R showConcernList(String username) {
        User user = userMapper.queryUser(username);
        List<Integer> concerners = concernMapper.selectUserConcerner(user.getId());
        List<User> users = new ArrayList<>();
        for (int id : concerners) {
            User user1 = userMapper.queryUserById(id);
            users.add(user1);
        }
        return R.success("获取关注对象成功", users);
    }

    @Override
    public R showFanList(String username) {
        User user = userMapper.queryUser(username);
        List<Integer> concerners = concernMapper.selectUserFan(user.getId());
        List<User> users = new ArrayList<>();
        for (int id : concerners) {
            User user1 = userMapper.queryUserById(id);
            users.add(user1);
        }
        return R.success("获取关注列表成功", users);
    }

    @Override
    public R deleteUserPhoto(String fname) {
        int i = pictureMapper.deletePicture(fname);
        if (i == 1) return R.success("删除用户照片成功");
        else return R.error("用户图片删除失败，请重试");
    }
}

