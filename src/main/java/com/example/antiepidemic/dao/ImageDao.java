package com.example.antiepidemic.dao;

import com.example.antiepidemic.domain.Image;

import java.util.List;

/**
 * 图片物理层
 * @author ZCL
 */
public interface ImageDao {
    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 管理员id
     * @return java.lang.Integer
     */
    public Integer insertImage(String name,String path,Integer inputer);

    /**
     * 修改图片
     * @param id 图片id
     * @param name 图片名
     * @param path 图片路径
     * @return java.lang.Integer
     */
    public Integer updateImage(Integer id,String name,String path);

    /**
     * 删除图片
     * @param id 图片id
     * @return java.lang.Integer
     */
    public Integer deleteImage(Integer id);

    /**
     * 查询单个图片
     * @param id 图片id
     * @return com.example.antiepidemic.domain.Image
     */
    public Image queryOneImage(Integer id);

    /**
     * 查询多个图片
     * @return java.util.List
     */
    public List<Image> listAllImage();

}
