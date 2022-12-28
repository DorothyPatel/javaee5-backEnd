package com.pjq.service;

import com.pjq.pojo.R;
import com.pjq.pojo.UserMessage;
import com.pjq.pojo.UserQueryUserInfo;
import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@Service
public interface SelectService {
    R selectPictureByTagsForOne(String username, String tag);
    R selectPictureByTagsForAll(String tag);
    R selectOneInfor(String username);//主页面，查找他人时，展示他人的用户信息，这里是模糊查找
    R selectOnePicture(String username);//主页面，查找他人时，展示他人的图片信息
    R selectOneConcernPicture(String username);
    R selectOneConcernNum(String username);//查找一个人关注的个数
    R selectOneConcernedNum(String username);//查找一个人粉丝的个数
    R selectPictureByNameVague(String pname) throws DecoderException, UnsupportedEncodingException;
    R selectMyPictureByNameVague(UserMessage userMessage) throws DecoderException, UnsupportedEncodingException;
    R addPicture(MultipartFile file);
    R addPictureInfor(String name, String username, String intro, String tags,String fname);//前端把处理好的tags写成一个串发过来吧
    R selectPictureByTime();
    R selectPeopleById(int userid);
    R selectPeopleConcernPicture(String username);
    R selectPeopleInfor(UserQueryUserInfo userInfo);
}
