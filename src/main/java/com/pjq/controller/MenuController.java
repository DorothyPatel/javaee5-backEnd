package com.pjq.controller;

import com.pjq.pojo.Menu;
import com.pjq.pojo.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class MenuController {
    @PostMapping("/menus")
    public R returnMenu(){
        Menu child11 = new Menu();
        child11.setAuthname("主页");
        child11.setChildren(null);
        child11.setId(101);
        child11.setOrder(0);
        child11.setPath("home");
        Menu child12 = new Menu();
        child12.setAuthname("上传照片");
        child12.setChildren(null);
        child12.setId(102);
        child12.setOrder(0);
        child12.setPath("uploadPictures");
        List<Menu> father1child = new ArrayList<>();
        father1child.add(child11);
        father1child.add(child12);
        Menu father1 = new Menu();
        father1.setAuthname("项目主页");
        father1.setChildren(father1child);
        father1.setOrder(1);
        father1.setPath("home");
        father1.setId(100);
        //
        Menu child21 = new Menu();
        child21.setAuthname("个人主页");
        child21.setChildren(null);
        child21.setId(201);
        child21.setOrder(0);
        child21.setPath("myhome");
//        Menu child22 = new Menu();
//        child22.setAuthname("他人主页");
//        child22.setChildren(null);
//        child22.setId(202);
//        child22.setOrder(0);
//        child22.setPath("otherhome");
        List<Menu> father2child = new ArrayList<>();
        father2child.add(child21);
//        father2child.add(child22);
        Menu father2 = new Menu();
        father2.setAuthname("用户主页");
        father2.setChildren(father2child);
        father2.setId(200);
        father2.setOrder(2);
        father2.setPath("myhome");
        //
        Menu child31 = new Menu();
        child31.setAuthname("修改密码");
        child31.setChildren(null);
        child31.setId(301);
        child31.setOrder(0);
        child31.setPath("update");
        Menu child32 = new Menu();
        child32.setAuthname("修改信息");
        child32.setChildren(null);
        child32.setId(302);
        child32.setOrder(0);
        child32.setPath("updateInfor");
        Menu child33 = new Menu();
        child33.setAuthname("修改头像");
        child33.setChildren(null);
        child33.setId(303);
        child33.setOrder(0);
        child33.setPath("updateHead");
        List<Menu> father3child = new ArrayList<>();
        father3child.add(child31);
        father3child.add(child32);
        father3child.add(child33);
        Menu father3 = new Menu();
        father3.setAuthname("个人信息维护");
        father3.setChildren(father3child);
        father3.setId(300);
        father3.setOrder(3);
        father3.setPath("update");
        //
        for(Menu menu: father3child){
            System.out.println(menu);
        }
        List<Menu> grand = new ArrayList<>();
        grand.add(father1);
        grand.add(father2);
        grand.add(father3);
        return R.success("this is my project menu",grand);
    }
}
