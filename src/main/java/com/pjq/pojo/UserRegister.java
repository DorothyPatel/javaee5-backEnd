package com.pjq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {
    private String username;
    private String password;
    private String againPassword;
    private String gender;
    private String province;
    private String city;
    private String name;
    private String email;
    private String qq;
    private String mobile;
    private String introduction;
}
