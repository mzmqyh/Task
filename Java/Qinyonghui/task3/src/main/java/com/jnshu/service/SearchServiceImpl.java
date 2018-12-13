package com.jnshu.service;

import com.jnshu.entity.Art;
import com.jnshu.mapper.ArtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

@Service
public class SearchServiceImpl implements SearchServie{

    @Autowired
    ArtDao artDao;
    @Override
    public List<Art> search(String keyWord) {
        Example example = new Example(Art.class);
        Example.Criteria criteria = example.createCriteria();
        return null;
    }
}
