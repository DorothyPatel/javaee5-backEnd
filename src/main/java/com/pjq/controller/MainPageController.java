package com.pjq.controller;

import com.pjq.mapper.PictureMapper;
import com.pjq.pojo.PicAcc;
import com.pjq.pojo.R;
import com.pjq.pojo.UserMessage;
import com.pjq.pojo.UserQueryUserInfo;
import com.pjq.service.SelectService;
import com.pjq.service.UserStatusService;
import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RequestMapping("/main")
@RestController
@CrossOrigin(originPatterns = "*")
public class MainPageController {
    @Autowired(required = false)
    private SelectService selectService;
    @Autowired(required = false)
    private UserStatusService userStatusService;

    @RequestMapping(value = "/exit",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public R exit(@RequestParam(value = "username",required = true) @Valid String username){
        return userStatusService.exitSystem(username);
    }
    //主页面搜索用户
    @RequestMapping(value = "/selectPeopleVague",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public R selectPeopleVague(@RequestParam(value = "username",required = true) @Valid String username){
        return selectService.selectOneInfor(username);
    }
    //主页面搜索用户时，级联展示他的图片
    @PostMapping(value = "/selectPeopleAndItsPicture",produces = "application/json;charset=UTF-8")
    public R selectPeopleAndItsPicture(@RequestBody String username){
        String[] split = username.split("=");
        username = split[0];
        return selectService.selectOnePicture(username);
    }
    @PostMapping(value = "/selectConcernPeopleAndItsPicture",produces = "application/json;charset=UTF-8")
    public R selectConcernPeopleAndItsPicture(@RequestBody String username){
        String[] split = username.split("=");
        username = split[0];
        return selectService.selectOneConcernPicture(username);
    }
    @PostMapping(value = "/selectPeopleById",produces = "application/json;charset=UTF-8")
    public R selectPeopleById(@RequestBody String uid){
        String[] split = uid.split("=");
        uid = split[0];
        int userid = Integer.parseInt(uid);
        return selectService.selectPeopleById(userid);
//        return selectService.selectPeopleById(uid);
    }
    //根据标签查找图片
    @PostMapping(value = "/selectPictureByTag",produces = "application/json;charset=UTF-8")
    public R selectPictureByTag(@RequestBody  String tag){
        String[] split = tag.split("=");
        tag = split[0];
        return selectService.selectPictureByTagsForAll(tag);
    }
    @PostMapping(value = "/selectPeopleConcernPicture",produces = "application/json;charset=UTF-8")
    public R selectPeopleConcernPicture(@RequestBody String username){
        String[] split = username.split("=");
        username = split[0];
        return selectService.selectPeopleConcernPicture(username);
    }
    //根据名称搜索图片
    @PostMapping(value = "/selectPictureByNameVague",produces = "application/json;charset=UTF-8")
    public R selectPictureByNameVague(@RequestBody  String pname, HttpServletRequest req) throws DecoderException, UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        System.out.println(pname);
        return selectService.selectPictureByNameVague(pname);
    }
    @PostMapping(value = "/selectMyPictureByNameVague",produces = "application/json;charset=UTF-8")
    public R selectMyPictureByNameVague(@RequestBody UserMessage userMessage, HttpServletRequest req) throws DecoderException, UnsupportedEncodingException {
        return selectService.selectMyPictureByNameVague(userMessage);
    }
    //根据最近上传顺序来写
    @PostMapping(value = "/selectPictureByTime",produces = "application/json;charset=UTF-8")
    public R selectPictureByTime( ){
        return selectService.selectPictureByTime();
    }

    @PostMapping(value = "/addPicture",produces = "application/json;charset=UTF-8")
    public R addPicture(@RequestBody MultipartFile file, HttpSession session) {
            return selectService.addPicture(file);
        }
    @PostMapping(value = "/addPictureInfor",produces = "application/json;charset=UTF-8")
    public R addPictureInfor(@RequestBody PicAcc picture){
        String name = picture.getPhotoName();
        String tags = picture.getTags();
        String intro = picture.getIntroduction();
        String fname = picture.getFname();
        String username = picture.getUsername();
        System.out.println(name);
        System.out.println(tags);
        System.out.println(intro);
        System.out.println(fname);
        System.out.println(username);
        return selectService.addPictureInfor(name,username,intro,tags,fname);
    }
    @PostMapping(value = "/userQueryOtherUser",produces = "application/json;charset=UTF-8")
    public R selectPictureByNameVague(@RequestBody UserQueryUserInfo userInfo) {
        System.out.println(userInfo.toString());
        return selectService.selectPeopleInfor(userInfo);
    }
}
