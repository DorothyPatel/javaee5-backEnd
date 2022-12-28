package com.pjq.service;

import com.pjq.pojo.PicAcc;
import com.pjq.pojo.R;
import com.pjq.pojo.User;
import com.pjq.pojo.UserChangeInfor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserInforService {
    R changeUserInfor(UserChangeInfor user);
    R changePassword(String username,String password);
    R changeHeadPhoto(PicAcc picAcc);
    R showConcernList(String username);
    R showFanList(String username);
    R deleteUserPhoto(String fname);

}
