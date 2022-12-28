package com.pjq.controller;

import com.pjq.pojo.R;
import com.pjq.pojo.Sex;
import com.pjq.pojo.User;
import com.pjq.pojo.UserRegister;
import com.pjq.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequestMapping("/register")
@RestController
@CrossOrigin(originPatterns = "*")
public class RegisterPageController {
    @Autowired(required = false)
    private UserStatusService userStatusService;


    @RequestMapping(value = "/checkUsername" ,method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public R checkUsername(@RequestBody  String username){
        System.out.println("in the register contoller");
        String[] split = username.split("=");
        username = split[0];
        System.out.println(username);
        return userStatusService.checkUsername(username);
    }

    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public R userRegister(@RequestBody UserRegister user, HttpSession session){
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        user1.setIntroduction(user.getIntroduction());
        user1.setGender(Sex.valueOf(user.getGender()));
        user1.setProvince(user.getProvince());
        user1.setCity(user.getCity());
        user1.setEmail(user.getEmail());
        user1.setMobile(user.getMobile());
        user1.setQq(user.getQq());
        return userStatusService.signUp(user1);
    }
}
