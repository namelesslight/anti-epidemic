package com.example.antiepidemic.service.impl;

import com.example.antiepidemic.dao.ImageDao;
import com.example.antiepidemic.dao.impl.ImageDaoImpl;
import com.example.antiepidemic.domain.Image;
import com.example.antiepidemic.service.ImageService;


import java.util.List;

/**
 * 图片服务层实现类
 * @author ZCL
 */
public class ImageServiceImpl implements ImageService {

    ImageDao imageDao = new ImageDaoImpl();

    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 管理员id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertImage(String name, String path, Integer inputer) {
        return imageDao.insertImage(name,path,inputer) == 1;
    }

    /**
     * 更新图片
     * @param id 图片id
     * @param name 图片
     * @param path 图片路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateImage(Integer id, String name, String path) {
        return imageDao.updateImage(id,name,path) == 1;
    }

    /**
     * 删除图片
     * @param id 图片id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteImage(Integer id) {
        return imageDao.deleteImage(id) == 1;
    }

    /**
     * 获取单个图片数据
     * @param id 图片id
     * @return com.example.antiepidemic.domain.Image
     */
    @Override
    public Image queryOneImage(Integer id) {
        return imageDao.queryOneImage(id);
    }

    /**
     * 获取全部图片数据
     * @return java.util.List
     */
    @Override
    public List<Image> listAllImage() {
        return imageDao.listAllImage();
    }
}
