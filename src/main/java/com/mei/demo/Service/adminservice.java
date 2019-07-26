package com.mei.demo.Service;


import com.mei.demo.Dao.admindao;
import com.mei.demo.Domain.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class adminservice {

    @Autowired
    private admindao admindao;

    public int login(int id,String password)
    {
        return admindao.login(id,password);
    }

    public String adminnamer(int id)
    {
        return admindao.selectadmin(id);
    }

    public int changepassword(int id,String password)
    {
        return admindao.updateadminpassword(id,password);
    }


}

