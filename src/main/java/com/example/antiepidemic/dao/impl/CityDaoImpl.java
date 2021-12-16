package com.example.antiepidemic.dao.impl;

import com.example.antiepidemic.dao.CityDao;
import com.example.antiepidemic.domain.City;
import com.example.antiepidemic.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 城市物理层实现类
 * @author ZCL
 */
public class CityDaoImpl implements CityDao {

    Connection connection = null;

    PreparedStatement statement = null;

    ResultSet resultSet = null;

    /**
     * 添加城市
     * @param name 城市名
     * @param story 城市相关故事
     * @param image 城市图片
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertCity(String name, String story, Long image, Long inputer) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "insert into `tb_city` values (null,?,?,?,?,0,now(),now());";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,story);
            statement.setLong(3,image );
            statement.setLong(4,inputer);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新城市
     * @param id 城市id
     * @param name 城市名
     * @param story 城市故事
     * @param image 图片
     * @return java.lang.Integer
     */
    @Override
    public Integer updateCity(Long id, String name, String story, Long image) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_city`" +
                    " set `name` = ?,`story` = ?,image = ? ,`gmt_update` = now() " +
                    "where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,story);
            statement.setLong(3,image );
            statement.setLong(4,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除城市
     * @param id 城市id
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteCity(Long id) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_city`" +
                    " set `is_delete` = 1 , `gmt_update` = now() " +
                    "where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一个城市
     * @param id 城市id
     * @return com.example.antiepidemic.domain.City
     */
    @Override
    public City queryOneCity(Long id) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "select `id`,`name`,`story`,`image`,`inputer`,`is_delete`,`gmt_create`,`gmt_update` " +
                    "from `tb_city`"+
                    "where id = ?  and `is_delete` = 0";
            statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();
            City city = null;
            if (result.next()){
               city = new City();
               city.setId(result.getLong("id"));
               city.setName(result.getString("name"));
               city.setStory(result.getString("story"));
               city.setImage(result.getLong("image"));
               city.setInputer(result.getLong("inputer"));
               city.setDelete(result.getBoolean("is_delete"));
               city.setGmtCreate(result.getDate("gmt_create"));
               city.setGmtUpdate(result.getDate("gmt_update"));
            }
            DruidUtils.close(resultSet,statement,connection);
            return city;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取全部城市
     * @return java.util.List
     */
    @Override
    public List<City> listCities() {
        try{
            connection = DruidUtils.getConnection();
            String sql = "select `id`,`name`,`story`,`image`,`inputer`,`is_delete`,`gmt_create`,`gmt_update` " +
                    "from `tb_city` where `is_delete` = 0";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<City> cityList = new ArrayList<>();
            while (result.next()){
                City city = new City();
                city.setId(result.getLong("id"));
                city.setName(result.getString("name"));
                city.setStory(result.getString("story"));
                city.setImage(result.getLong("image"));
                city.setInputer(result.getLong("inputer"));
                city.setDelete(result.getBoolean("is_delete"));
                city.setGmtCreate(result.getDate("gmt_create"));
                city.setGmtUpdate(result.getDate("gmt_update"));
                cityList.add(city);
            }
            DruidUtils.close(resultSet,statement,connection);
            return cityList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
