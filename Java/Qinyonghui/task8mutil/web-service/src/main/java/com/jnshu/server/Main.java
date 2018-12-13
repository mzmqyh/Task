package com.jnshu.server;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;



/**
 * @ClassName Main
 * @Auther: QYH
 * @Date: 2018/12/3 18:07
 * @Description: TODO
 * @Version 1.0
 */

//构建服务端
public class Main {
  public static void main(String[] args) throws MalformedURLException {
        Logger logger = Logger.getLogger(Main.class);
        logger.info("构建服务端................"+"\n");
       //ApplicationContext app =106.15.203.211
        System.setProperty("java.rmi.server.hostname","106.15.203.211");
        ApplicationContext a = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        //StudentService studentService = (StudentService)app.getBean("studentService");
        //logger.info(studentService.findStudentById(10L));
        //ProfessionService professionService = (ProfessionService)app.getBean("professionService");
        //List<Profession> professionList = professionService.getOneByPrimaryKey(10L);
        //logger.info(professionList);*/
        logger.info("构建服务端成功");
    }
}
