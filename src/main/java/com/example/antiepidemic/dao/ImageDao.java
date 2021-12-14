package com.example.antiepidemic.dao;

import com.example.antiepidemic.domain.Image;

import java.util.List;

public interface ImageDao {

    public Integer insertImage(String name,String path,Integer inputer);

    public Integer updateImage(String id,String name,String path);

    public Integer deleteImage(String id);

    public Image queryOneImage(String id);

    public List<Image> listAllImage();

}
