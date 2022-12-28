package com.pjq.service;

import com.pjq.pojo.R;
import com.pjq.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserStatusService {
    R login(String username, String password);
    R signUp(User user);
    R checkUsername(String username);
    R exitSystem(String username);
}
