package com.pjq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture  {
    @NonNull
    @TableId(type = IdType.AUTO)
    private int id;
    @NonNull
    @Size(max = 20,min = 1)
    private String name;
    @NonNull
    @Size(max = 100)
    private String fname;
    @NonNull
    private int uid;
    @Size(max = 255)
    private String intro;
    @Size(max = 50)
    private String tags;

    private Date uploadTime;
    @NonNull
    private int clickNum;
}
