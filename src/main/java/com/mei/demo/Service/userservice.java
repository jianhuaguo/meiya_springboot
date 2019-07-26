package com.mei.demo.Service;

import com.mei.demo.Dao.userdao;
import com.mei.demo.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userservice {

    @Autowired
    private userdao userdao;

    public ArrayList<User> selectall()
    {
        return userdao.SelectAll();
    }

    public ArrayList<User> selectbyname(String name)
    {
        return userdao.SelectByName(name);
    }
    public int updateuser(User user)
    {
        return userdao.updatestore(user);
    }

    public int updatestatu(int id)
    {
        return userdao.updatestatus(id);
    }

    public int todayuser()
    {
        return userdao.todayuser();
    }

    public int yesterdayuser()
    {
        return userdao.yesterdayuser();
    }

    public int monthuser()
    {
        return userdao.monthuser();
    }

    public int countuser()
    {
        return userdao.countuser();
    }

    public int batchinsert(List<User> users)
    {
        return userdao.batchInsert(users);
    }
}
