package com.example.antiepidemic.service;

import com.example.antiepidemic.domain.Image;

import java.util.List;

/**
 * @author ZCL
 */
public interface ImageService {
    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 管理员id
     * @return java.lang.Boolean
     */
    public Boolean insertImage(String name,String path,Integer inputer);

    /**
     * 修改图片
     * @param id 图片id
     * @param name 图片
     * @param path 图片路径
     * @return java.lang.Boolean
     */
    public Boolean updateImage(Integer id,String name,String path);

    /**
     * 删除图片
     * @param id 图片id
     * @return java.lang.Boolean
     */
    public Boolean deleteImage(Integer id);

    /**
     * 获取单个图片
     * @param id 图片id
     * @return com.example.antiepidemic.domain.Image
     */
    public Image queryOneImage(Integer id);

    /**
     * 获取全部图片
     * @return java.util.List
     */
    public List<Image> listAllImage();

}
