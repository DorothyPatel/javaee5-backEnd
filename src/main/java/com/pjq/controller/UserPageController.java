package com.pjq.controller;

import com.pjq.pojo.*;
import com.pjq.service.ConcernService;
import com.pjq.service.SelectService;
import com.pjq.service.UserInforService;
import com.pjq.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("/user")
@RestController
@CrossOrigin(originPatterns = "*")
public class UserPageController {
    @Autowired(required = false)
    private ConcernService concernService;
    @Autowired(required = false)
    private SelectService selectService;
    @Autowired(required = false)
    private UserInforService userInforService;
    @Autowired(required = false)
    private UserStatusService userStatusService;

    @RequestMapping(value = "/exit",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public R exit(@RequestParam(value = "username",required = true) @Valid String username){
        return userStatusService.exitSystem(username);
    }

    @PostMapping(value = "/updateInfor",produces = "application/json;charset=UTF-8")
    public R updateInfor(@RequestBody UserChangeInfor user){
        return userInforService.changeUserInfor(user);
    }
    @PostMapping(value = "/updatePassword",produces = "application/json;charset=UTF-8")
    public R updatePassword(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        return userInforService.changePassword(username,password);
    }
    @PostMapping(value = "/updateHeadPhoto",produces = "application/json;charset=UTF-8")
    public R updateHeadPhoto(@RequestBody PicAcc picAcc){
        return userInforService.changeHeadPhoto(picAcc);
    }
    @PostMapping(value = "/showConcernList",produces = "application/json;charset=UTF-8")
    public R showConcernList(@RequestBody  String username){
        String[] split = username.split("=");
        username = split[0];
        return userInforService.showConcernList(username);
    }
    @PostMapping(value = "/showFanList",produces = "application/json;charset=UTF-8")
    public R showFanList(@RequestBody  String username){
        String[] split = username.split("=");
        username = split[0];
        return userInforService.showFanList(username);
    }
    @PostMapping(value = "/deleteUserPhoto",produces = "application/json;charset=UTF-8")
    public R deleteUserPhoto(@RequestParam(value = "fname") @Valid String fname){
        return userInforService.deleteUserPhoto(fname);
    }
    @PostMapping(value = "/concernOnePeople",produces = "application/json;charset=UTF-8")
    public R concernOnePeople(@RequestBody ConcernAction concernAction){
        return concernService.concernOnePeople(concernAction);
    }
    @PostMapping(value = "/cancelConcern",produces = "application/json;charset=UTF-8")
    public R cancelConcern(@RequestBody ConcernAction concernAction){
        return concernService.cancelConcern(concernAction);
    }
    @PostMapping(value = "/selectOneConcernNum",produces = "application/json;charset=UTF-8")
    public R selectOneConcernNum(@RequestBody  String username){
        String[] split = username.split("=");
        username = split[0];
        return selectService.selectOneConcernNum(username);
    }
    @PostMapping(value = "/selectOneConcernedNum")
    public R selectOneConcernedNum(@RequestBody String username){
//        String username = user.getUsername();
        System.out.println(username);
        String[] split = username.split("=");
        username = split[0];
        return selectService.selectOneConcernedNum(username);
    }
    @PostMapping(value = "/selectPictureByTagsForOne",produces = "application/json;charset=UTF-8")
    public R selectPictureByTagsForOne(@RequestParam(value = "username") @Valid String username,
                              @RequestParam(value = "tag") @Valid String tag){
        return selectService.selectPictureByTagsForOne(username,tag);
    }
}
