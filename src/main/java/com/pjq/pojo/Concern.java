package com.pjq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concern  {
    @TableId(type = IdType.AUTO)
    private int id;
    @NonNull
    private int concernerId;
    @NonNull
    private int concernedId;
    @NonNull
    private Date concernTime;
}
