package com.mei.demo.Service;

import com.mei.demo.Dao.licensedao;
import com.mei.demo.Domain.license;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class licenseservice {

    @Autowired
    private licensedao licensedao;

    public ArrayList<license> selectlicense(int status)
    {
        return licensedao.selectlicense(status);
    }

    public int passlicense(int id)
    {
        return licensedao.passlicense(id);
    }

    public int unpasslicense(int id){
        return licensedao.unpasslicense(id);
    }
}
