package com.mei.demo.Dao;


import com.mei.demo.Domain.User;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface userdao {

    String TABLE_NAME="my_user";
    @Select({"select * from my_user"})
    ArrayList<User> SelectAll();



    //通过名字获取
    @Select({"select * from ",TABLE_NAME, "where name like CONCAT('%',#{name},'%')"})
    ArrayList<User> SelectByName(String name);

    @Delete({"Delete from ", TABLE_NAME," where id= #{id}"})
    int DeleteById(int id);

    @Update({"update ",TABLE_NAME," set name= #{name},birth=#{birth},phone=#{phone},address=#{address},photo_url=#{photo_url} where id= #{id}"})
    int updatestore(User user);

    @Update({"update my_user set `status`= (case when `status`='0' then '1' else '0' end )  where id=#{id}"})
    int updatestatus(int id);

    @Select("select count(*) from my_user where to_days(`create_time`) = to_days(now())")
    int todayuser();

    @Select("select count(*) from my_user where cast(create_time as DATE) = DATE_SUB(curdate(),INTERVAL 1 DAY) ")
    int yesterdayuser();

    @Select("select count(*) from `my_user` where date_format(`create_time`, '%Y%m') = date_format(curdate() , '%Y%m')")
    int monthuser();

    @Select("select count(*) from my_user")
    int countuser();

    //批量添加用户
    @InsertProvider(type = Provider.class,method ="batchInsert")
    int batchInsert(List<User> users);

    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<User> users = (List<User>)map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO my_user (id,name,phone,password) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].id},#'{'list[{0}].name}, #'{'list[{0}].phone}, #'{'list[{0}].password})"
            );

            for (int i = 0; i < users.size(); i++) {
                sb.append(mf.format(new Object[]{i}));
                if (i < users.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }
    }

}
