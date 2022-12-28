package com.pjq.mapper;

import com.pjq.pojo.Concern;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface ConcernMapper {
    List<Integer> selectUserConcerner(int id);
    List<Integer> selectUserFan(int id);
    int addConcern(Concern concern);
    int deleteConcern(@Param("concernerid") int concernerid, @Param("concernedid") int concernedid);
    int countConcernerNum(int id);
    int countConcernedNum(int id);
}
