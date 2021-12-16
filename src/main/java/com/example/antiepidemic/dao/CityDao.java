package com.example.antiepidemic.dao;

import com.example.antiepidemic.domain.City;

import java.util.List;

/**
 * 城市物理层
 * @author ZCL
 */
public interface CityDao {

    /**
     * 插入城市
     * @param name 城市名
     * @param story 城市相关故事
     * @param image 城市图片
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer insertCity(String name,String story,Long image,Long inputer);

    /**
     * 修改城市
     * @param id 城市id
     * @param name 城市名
     * @param story 城市故事
     * @param image 图片
     * @return java.lang.Integer
     */
    public Integer updateCity(Long id,String name,String story,Long image);

    /**
     * 删除城市
     * @param id 城市id
     * @return java.lang.Integer
     */
    public Integer deleteCity(Long id);

    /**
     * 获取一个城市
     * @param id 城市id
     * @return com.example.antiepidemic.domain.City
     */
    public City queryOneCity(Long id);

    /**
     * 获取全部城市
     * @return java.util.List
     */
    public List<City> listCities();
}
