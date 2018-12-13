package com.jnshu;

import com.jnshu.service.ProfessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test
 * @Auther: QYH
 * @Date: 2018/12/6 17:55
 * @Description: TODO
 * @Version 1.0
 */
@ContextConfiguration( locations = "classpath:conf/applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class TestProfession {
    @Autowired
    ProfessionService professionService;
    @Test
    public void  testProfession(){
        System.out.println("5555555555555555555555"+professionService.getOneByPrimaryKey(10L));
    }
}
