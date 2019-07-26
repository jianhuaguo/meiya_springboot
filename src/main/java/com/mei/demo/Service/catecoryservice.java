package com.mei.demo.Service;

import com.mei.demo.Domain.Category;
import com.mei.demo.Dao.categorydao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class catecoryservice {

    @Autowired
    private categorydao categorydao;

    public ArrayList<Category> selectname()
    {
        return categorydao.selectall();
    }

}
