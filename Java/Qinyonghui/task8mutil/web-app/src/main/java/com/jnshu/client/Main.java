//package com.jnshu.client;

import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;
import com.jnshu.entity.User;
import com.jnshu.myutils.SwitchService;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;
import com.jnshu.entity.User;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName Main
 * @Auther: QYH
 * @Date: 2018/12/3 18:07
 * @Description: TODO
 * @Version 1.0
 */

//构建客户端
//public class Main {
//    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(Main.class);
//        ProfessionService professionService=(ProfessionService) SwitchService.switchBean().getBean("professionService");
//      List<Profession> professionList = professionService.getOneByPrimaryKey(10L);
//      logger.info("server professionlist=============="+professionList);


//      ApplicationContext app=new ClassPathXmlApplicationContext("conf/applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
//        StudentService studentService = (StudentService) app.getBean("studentService");
//        Student student = studentService.findStudentById(1L);
//        logger.info("server student================"+student);
//        User user = userService.findByName("qinyonghui");
//        logger.info("server user================"+user);

 // }
//
//   //
////        try {
////            Registry registry = LocateRegistry.getRegistry("106.15.203.211",10199);
////            //Registry registry = LocateRegistry.getRegistry("106.15.203.211",10199);
////            UserHandler userHandler = (UserHandler) registry.lookup("user");
////           // UserHandler userHandler1 = (UserHandler) Naming.lookup("rmi://localhost:1099/user");
////           int count = userHandler.getUserCount();
////           String name = userHandler.getUserName(1);
////           logger.info("name====:"+name+"\n");
////           logger.info("count====:"+count+"\r\n");
////           logger.info("user====:"+userHandler.getUserByName("qinyonghui").toString()+"\r\n");
////        } catch (RemoteException | NotBoundException e) {
////            e.printStackTrace();
////        }
  // }
//}
