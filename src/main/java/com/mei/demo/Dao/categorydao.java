package com.mei.demo.Dao;

import  com.mei.demo.Domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface categorydao {

    @Select("select * from my_category")
    public ArrayList<Category> selectall();

}
