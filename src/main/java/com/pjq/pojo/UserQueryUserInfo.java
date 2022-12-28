package com.pjq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryUserInfo {
    private String username;
    private String queryUsername;
    private String headphoto;
    private String province;
    private String city;
    private String gender;
    private String introduction;
    private String concernOrNot;
}
