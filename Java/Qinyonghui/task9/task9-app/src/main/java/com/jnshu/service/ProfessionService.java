package com.jnshu.service;

import com.jnshu.entity.Profession;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;
@Remotable
public interface ProfessionService {
    List <Profession> getOneByPrimaryKey(long id);
}
