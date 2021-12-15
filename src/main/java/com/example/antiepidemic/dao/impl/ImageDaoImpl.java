package com.example.antiepidemic.dao.impl;

import com.example.antiepidemic.dao.ImageDao;
import com.example.antiepidemic.domain.Image;
import com.example.antiepidemic.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片物理层实现类
 * @author ZCL
 */
public class ImageDaoImpl implements ImageDao {

    Connection connection = null;

    PreparedStatement statement = null;

    ResultSet resultSet = null;

    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 管理员id
     * @return java.lang.Integer
     */
    @Override
    public Integer insertImage(String name, String path, Integer inputer) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "insert into `tb_image` values (null,?,?,?,0,now(),now());";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,path);
            statement.setInt(3,inputer);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新图片
     * @param id 图片id
     * @param name 图片名
     * @param path 图片路径
     * @return java.lang.Integer
     */
    @Override
    public Integer updateImage(Integer id, String name, String path) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_image` " +
                    "set `name` = ? ,`path` = ?,`gmt_update` = now() where `id` = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,path);
            statement.setInt(3,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除图片
     * @param id 图片id
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteImage(Integer id) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "update `tb_image` " +
                    "set `is_delete` = 1,`gmt_update` = now() where `id` = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            Integer result = statement.executeUpdate();
            DruidUtils.close(resultSet,statement,connection);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取单个图片
     * @param id 图片id
     * @return com.example.antiepidemic.domain.Image
     */
    @Override
    public Image queryOneImage(Integer id) {
        try{
            connection = DruidUtils.getConnection();
            String sql = "select `id`,`name`,`path`,`is_delete`,`inputer`,`gmt_create`,`gmt_update` " +
                    "from `tb_image`" +
                    "where  id = ? " +
                    "and `is_delete` = 0";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            Image image = null;
            while(resultSet.next()){
                image = new Image();
                image.setId(resultSet.getLong("id"));
                image.setName(resultSet.getString("name"));
                image.setPath(resultSet.getString("path"));
                image.setInputer(resultSet.getLong("inputer"));
                image.setDelete(resultSet.getBoolean("is_delete"));
                image.setGmtCreate(resultSet.getDate("gmt_create"));
                image.setGmtUpdate(resultSet.getDate("gmt_update"));
            }
            DruidUtils.close(resultSet,statement,connection);
            return image;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取全部图片
     * @return java.util.List
     */
    @Override
    public List<Image> listAllImage() {
        try{
            connection = DruidUtils.getConnection();
            String sql = "select `id`,`name`,`path`,`is_delete`,`inputer`,`gmt_create`,`gmt_update` " +
                    "from `tb_image`" +
                    "where `is_delete` = 0";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Image> imageList = new ArrayList<>();
            while (resultSet.next()){
                Image image = new Image();
                image.setId(resultSet.getLong("id"));
                image.setName(resultSet.getString("name"));
                image.setPath(resultSet.getString("path"));
                image.setInputer(resultSet.getLong("inputer"));
                image.setDelete(resultSet.getBoolean("is_delete"));
                image.setGmtCreate(resultSet.getDate("gmt_create"));
                image.setGmtUpdate(resultSet.getDate("gmt_update"));
                imageList.add(image);
            }
            DruidUtils.close(resultSet,statement,connection);
            return imageList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
