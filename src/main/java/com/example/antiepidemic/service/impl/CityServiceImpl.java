package com.example.antiepidemic.service.impl;

import com.example.antiepidemic.dao.CityDao;
import com.example.antiepidemic.dao.impl.CityDaoImpl;
import com.example.antiepidemic.domain.City;
import com.example.antiepidemic.service.CityService;

import java.util.List;

/**
 * 城市服务层实现类
 * @author ZCL
 */
public class CityServiceImpl implements CityService {

    private CityDao cityDao = new CityDaoImpl();

    /**
     * 添加城市
     * @param name 城市名
     * @param story 城市相关故事
     * @param image 城市图片
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertCity(String name, String story, Long image, Long inputer) {
        return cityDao.insertCity(name,story,image,inputer) == 1;
    }

    /**
     * 更新城市
     * @param id 城市id
     * @param name 城市名
     * @param story 城市故事
     * @param image 图片
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateCity(Long id, String name, String story, Long image) {
        return cityDao.updateCity(id,name,story,image) == 1;
    }

    /**
     * 删除城市
     * @param id 城市id
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteCity(Long id) {
        return cityDao.deleteCity(id) == 1;
    }

    /**
     * 获取一个城市信息
     * @param id 城市id
     * @return com.example.antiepidemic.domain.City
     */
    @Override
    public City queryOneCity(Long id) {
        return cityDao.queryOneCity(id);
    }

    /**
     * 获取全部城市信息
     * @return java.util.List
     */
    @Override
    public List<City> listCities() {
        return cityDao.listCities();
    }
}
