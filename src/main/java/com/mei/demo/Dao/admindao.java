package com.mei.demo.Dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface admindao {

    //判断是否登录
    @Select("SELECT count(*) FROM my_admin where id=#{id} and `password`=#{password}")
    public int login(int id,String password);


    @Select("select name from my_admin where id=#{id}")
    public String selectadmin(int id);

    @Update("update  my_admin set PASSWORD = #{password} WHERE id=#{id}")
    public int updateadminpassword(int id,String password);

    @Select("select count(*) from my_admin where phone= #{phone}")
    public int selectphone(String phone);
}
