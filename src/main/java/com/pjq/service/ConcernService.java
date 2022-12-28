package com.pjq.service;

import com.pjq.pojo.ConcernAction;
import com.pjq.pojo.R;
import org.springframework.stereotype.Service;

@Service
public interface ConcernService {
    R concernOnePeople(ConcernAction concernAction);
    R cancelConcern(ConcernAction concernAction);
}
