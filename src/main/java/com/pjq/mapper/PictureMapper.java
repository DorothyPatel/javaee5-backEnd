package com.pjq.mapper;

import com.pjq.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper {
    List<Picture> selectUserPicture(int id);
    List<Picture> selectLastedPicture();
    List<Picture> selectPictureByNameVague(String pname);
    int deletePicture(String fname);
    List<Picture> selectAllPicture();
    int addPicture(Picture picture);

}
