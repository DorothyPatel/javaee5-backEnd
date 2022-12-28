package com.pjq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    @NonNull
//    @TableId(type = IdType.AUTO)
    private int id;
    @NonNull
    @Size(min = 6,max=15)
    private String username;
    @NonNull
    @Size(min = 6,max=15)
    private String password;
    @NonNull
    @Size(min = 6,max=15)
    private String againPassword;
    @Size(max = 12)
    private String name;
    @Size(max = 100)
    private String introduction;
    @NonNull
    private Sex gender;
    @NonNull
    @Size(max = 10)
    private String province;
    @NonNull
    @Size(max = 10)
    private String city;

    @NonNull
    private Date registTime;

    private int type;
    @Email
    private String email;
    @Size(max = 11,min = 11)
    private String mobile;
    @Size(max = 10,min = 6)
    private String qq;
    @NonNull
    private int status;

    private String headphoto;
}
