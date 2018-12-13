package com.jnshu;

import com.jnshu.myutils.ChooseServer;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @ClassName TestTuscany
 * @Auther: QYH
 * @Date: 2018/12/12 23:05
 * @Description: TODO
 * @Version 1.0
 */
@ContextConfiguration( locations = "classpath:conf/applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class TestTuscany {
    @Autowired
    ChooseServer chooseServer;
    @Test
    public void testChooseServer() throws RemoteException, MalformedURLException, NotBoundException {
        Logger logger = Logger.getLogger(TestTuscany.class);
        StudentService studentService  = chooseServer.getStudentService();
        logger.info("服务端Tuscany RMI StudentService测试：\n"+studentService.findStudentById(10L));
        UserService userService = chooseServer.getUserService();
        logger.info("服务端Tuscany RMI StudentService测试：\n"+userService.selectUser("root1"));
        ProfessionService preofessionService =chooseServer.getProfessionService();
        logger.info("服务端Tuscany RMI StudentService测试：\n"+preofessionService.getOneByPrimaryKey(10L));

    }
}
