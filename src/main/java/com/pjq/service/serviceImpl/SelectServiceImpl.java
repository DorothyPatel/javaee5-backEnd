package com.pjq.service.serviceImpl;

import com.pjq.pojo.*;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import com.pjq.mapper.ConcernMapper;
import com.pjq.mapper.PictureMapper;
import com.pjq.mapper.UserMapper;
import com.pjq.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SelectServiceImpl implements SelectService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private PictureMapper pictureMapper;
    @Autowired(required = false)
    private ConcernMapper concernMapper;
    @Override
    public R selectPictureByTagsForOne(String username, String tag){
        User user = userMapper.queryUser(username);
        List<Picture> pictures = pictureMapper.selectUserPicture(user.getId());
        List<Picture> selPictures = new ArrayList<>();
        for(Picture picture:pictures){
            String tags = picture.getTags();
            String[] alltag = tags.split(";");

            for(String s:alltag){
                if(s.equals(tag)){
                    selPictures.add(picture);
                    break;
                }
            }

        }
        return R.success("含有此tag的图片",selPictures);
    }
    @Override
    public R selectPictureByTagsForAll(String tag){
        List<Picture> pictures = pictureMapper.selectAllPicture();
        List<Picture> selPictures = new ArrayList<>();
        for(Picture picture:pictures){
            String tags = picture.getTags();
            String[] alltag = tags.split(";");

            for(String s:alltag){
                if(s.equals(tag)){
                    selPictures.add(picture);
                    break;
                }
            }

        }
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:selPictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("含有此tag的图片",pictureRets);
    }
    @Override
    public R selectOneInfor(String username){
        username = "%" + username + "%";
        List<User> users = userMapper.queryUserVague(username);
        return R.success("success",users);
    }
    @Override
    public R selectOnePicture(String username){
        User user = userMapper.queryUser(username);
        List<Picture> pictures = pictureMapper.selectUserPicture(user.getId());
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:pictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("success",pictureRets);
    }
    @Override
    public R selectOneConcernPicture(String username){
        username = "%" + username + "%";
        List<User> users = userMapper.queryUserVague(username);
        List<Picture> pictures = new ArrayList<>();
        for(User user:users){
            List<Picture> pictures1 = pictureMapper.selectUserPicture(user.getId());
            pictures.addAll(pictures1);
        }
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:pictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("success",pictureRets);
    }
    @Override
    public R selectOneConcernNum(String username){
        User user = userMapper.queryUser(username);
        int count = concernMapper.countConcernerNum(user.getId());
        return R.success("success",count);
    }
    @Override
    public R selectOneConcernedNum(String username){
        User user = userMapper.queryUser(username);
        System.out.println(user.toString());
        int count = concernMapper.countConcernedNum(user.getId());
        return R.success("success",count);
    }
    @Override
    public R selectPictureByNameVague(String pname) throws DecoderException, UnsupportedEncodingException {
        System.out.println(pname);
        String[] split = pname.split("=");
        pname = split[0];
//        String[] split1 = pname.split("%");
//        String picNames = "";
//        for(String s:split1){
//            picNames += s;
//        }
//        System.out.println(picNames);
//        byte[] bytes = Hex.decodeHex(picNames.toCharArray());
//
//        String picName = new String(bytes,"UTF-8");
        pname = "%" + pname + "%";
        System.out.println(pname);
        List<Picture> pictures = pictureMapper.selectPictureByNameVague(pname);
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:pictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("success",pictureRets);
    }
    @Override
    public R selectMyPictureByNameVague(UserMessage userMessage)  {
        String message = userMessage.getMessage();
        String username = userMessage.getUsername();
        List<Picture> pictures1 = pictureMapper.selectUserPicture(userMapper.queryUser(username).getId());
        List<Picture> pictures = new ArrayList<>();
        for(Picture picture: pictures1){
            if(picture.getName().contains(message)) pictures.add(picture);
        }
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:pictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("success",pictureRets);
    }
    @Override
    public R addPicture(MultipartFile file){
        String fileName;
        if(file.isEmpty()){
            System.out.println("is empty");
            return R.success("accept error");
        }else{
            System.out.println("is full");
            fileName = file.getOriginalFilename();  // 文件名
            System.out.println(fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            System.out.println(suffixName);
            String filePath = "D:\\myCF\\javaEE5-front\\src\\static\\images\\"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = "/temp-rainy/" + fileName;
            System.out.println(filename);
            System.out.println(dest);
            return R.success("accept success",fileName);
        }
    }
    @Override
    public R addPictureInfor(String name,String username,String intro,String tags,String fname){
        Picture picture = new Picture();
        picture.setClickNum(0);
        picture.setUploadTime(new Date());
        picture.setTags(tags);
        picture.setName(name);
        picture.setFname("@/static/images/" + fname);//这个有问题的
        picture.setIntro(intro);
        picture.setUid(userMapper.queryUser(username).getId());
        System.out.println(picture.toString());
        int i = pictureMapper.addPicture(picture);
        if(i == 1)return  R.success("add picture succ!");
        else return R.error("add picture false");
    }
    @Override
    public R selectPictureByTime(){
        List<Picture> pictures = pictureMapper.selectLastedPicture();
        List<PictureRet> pictureRets = new ArrayList<>();
        for(Picture picture:pictures){
            PictureRet pictureRet = new PictureRet();
            pictureRet.setClickNum(picture.getClickNum());
            pictureRet.setFname(picture.getFname());
            pictureRet.setId(picture.getId());
            pictureRet.setIntro(picture.getIntro());
            pictureRet.setName(picture.getName());
            pictureRet.setTags(picture.getTags());
            pictureRet.setUid(picture.getUid());
            pictureRet.setUploadTime(picture.getUploadTime());
            pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
            pictureRets.add(pictureRet);
        }
        return R.success("success",pictureRets);
    }
    @Override
    public R selectPeopleById(int userid){
        User user = userMapper.queryUserById(userid);
        return R.success("success",user.getUsername());
    }

    @Override
    public R selectPeopleConcernPicture(String username){
        List<Integer> integers = concernMapper.selectUserConcerner(userMapper.queryUser(username).getId());
        List<PictureRet> pictureRets = new ArrayList<>();
        for(int i:integers){
            List<Picture> pictures = pictureMapper.selectUserPicture(i);
            for(Picture picture:pictures){
                PictureRet pictureRet = new PictureRet();
                pictureRet.setClickNum(picture.getClickNum());
                pictureRet.setFname(picture.getFname());
                pictureRet.setId(picture.getId());
                pictureRet.setIntro(picture.getIntro());
                pictureRet.setName(picture.getName());
                pictureRet.setTags(picture.getTags());
                pictureRet.setUid(picture.getUid());
                pictureRet.setUploadTime(picture.getUploadTime());
                pictureRet.setUsername(userMapper.queryUserById(picture.getUid()).getUsername());
                pictureRets.add(pictureRet);
            }
        }
        return R.success("success",pictureRets);
    }

    @Override
    public R selectPeopleInfor(UserQueryUserInfo userInfo){
        User user = userMapper.queryUser(userInfo.getQueryUsername());//这里存的是被查找的用户
        System.out.println(user.toString());
        UserQueryUserInfo userInfos = new UserQueryUserInfo();
        userInfos.setQueryUsername(user.getUsername());
        userInfos.setHeadphoto(user.getHeadphoto());
        userInfos.setProvince(user.getProvince());
        userInfos.setCity(user.getCity());
        userInfos.setGender(String.valueOf(user.getGender()));
        userInfos.setIntroduction(user.getIntroduction());
        User user1 = userMapper.queryUser(userInfo.getUsername());//这里存的是用户
        //下面要判断，用户是否关注了被查找的用户
        List<Integer> integers = concernMapper.selectUserConcerner(user1.getId());
        if(integers.contains(user.getId())){
            userInfos.setConcernOrNot("取消关注");
        }else userInfos.setConcernOrNot("点我关注");
        return R.success("success",userInfos);
    }
}
