package com.pjq.service.serviceImpl;

import com.pjq.mapper.ConcernMapper;
import com.pjq.mapper.UserMapper;
import com.pjq.pojo.Concern;
import com.pjq.pojo.ConcernAction;
import com.pjq.pojo.R;
import com.pjq.pojo.User;
import com.pjq.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConcernServiceImpl implements ConcernService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private ConcernMapper concernMapper;
    @Override
    public R concernOnePeople(ConcernAction concernAction){
        String username = concernAction.getUsername();
        String concernedName = concernAction.getConcernUsername();
        User user = userMapper.queryUser(username);
        User concernedUser = userMapper.queryUser(concernedName);
        Concern concern = new Concern();
        concern.setConcernerId(user.getId());
        concern.setConcernedId(concernedUser.getId());
        concern.setConcernTime(new Date());
        int i = concernMapper.addConcern(concern);
        if(i == 1) return R.success("关注用户成功！");
        else return R.error("关注用户失败，请重试");
    }

    @Override
    public R cancelConcern(ConcernAction concernAction){
        String username = concernAction.getUsername();
        String concernedName = concernAction.getConcernUsername();
        User user = userMapper.queryUser(username);
        User concernedUser = userMapper.queryUser(concernedName);
        int i = concernMapper.deleteConcern(user.getId(), concernedUser.getId());
        if(i == 1) return R.success("取消关注用户成功！");
        else return R.error("取消关注用户失败，请重试");
    }
}
