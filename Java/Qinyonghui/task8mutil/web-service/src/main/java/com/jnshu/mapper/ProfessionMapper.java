package com.jnshu.mapper;

import com.jnshu.entity.Profession;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProfessionMapper extends Mapper <Profession> {
    List<Profession> getOneByPrimaryKey(long id);
}