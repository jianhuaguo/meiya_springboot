package com.mei.demo.Service.impl;

import com.github.pagehelper.PageHelper;
import com.mei.demo.Service.storeservice_in;
import com.mei.demo.Domain.Store;
import com.mei.demo.Dao.storedao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class storeservice {

    @Autowired
    private storedao storedao;

    public int insertstore(Store store)
    {
        return storedao.addStore(store);
    }

    @Transactional
    public int update(Store store)
    {
        return storedao.updatestore(store);
    }

    public int delete(int id)
    {
        return storedao.DeleteById(id);
    }



    public ArrayList<Store> selectAll()
    {


        return storedao.SelectAll();
    }
    public int updatestatus(int id)
    {
        return storedao.updatestatus(id);
    }
    public ArrayList<Store> selectbyname(String name)
    {
        return storedao.SelectByName(name);
    }
    public Store selectbyid(int id)
    {
        return storedao.SelectById(id);
    }
    public int monthstore()
    {
        return storedao.monthstore();
    }
    public int freestore()
    {
        return storedao.freestore();
    }
    public int unfreestore()
    {
        return storedao.unfreestore();
    }
    public int countstore()
    {
        return storedao.countstore();
    }

    public int selectcountbyid(int id){
        return storedao.selectcountbyid(id);
    }
}
