package com.pjq.controller;
import com.pjq.pojo.R;
import com.pjq.pojo.User;
import com.pjq.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
@CrossOrigin(originPatterns = "*")
public class LoginPageController {
    @Autowired(required = false)
    private UserStatusService userStatusService;

    @PostMapping("/user")
    public R userLogin(@RequestBody User user, HttpSession session){
        System.out.println(user.toString());
        String password = user.getPassword();
        String username = user.getName();
        System.out.println(password);
        System.out.println(username);
        return userStatusService.login(username, password);
    }

}
