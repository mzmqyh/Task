package com.jnshu.myutils;


import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import com.jnshu.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

import org.apache.log4j.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName ChooseStudentService
 * @Auther: QYH
 * @Date: 2018/12/12 10:53
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class ChooseServer{
    private Logger logger = Logger.getLogger(ChooseServer.class);
    private StudentService studentService;
    public UserService userService;
    private ProfessionService professionService;
    private String address = "rmi://106.15.203.211:";
    //106.15.203.211
    String url;
    static String[] portArray =getPort();

    private static String[] getPort() {
        String[] portArray={"",""};
        int n = new Random().nextInt(2);
        if (n == 0) {
            portArray[0] = "8816";
            portArray[1] = "8817";
        } else {
            portArray[0] = "8817";
            portArray[1] = "8816";
        }
        return portArray;
    }

    public  StudentService getStudentService() throws RemoteException {
        try {
            logger.info("现在尝试使用的StudentService端口号是" + portArray[0] + "\n");
             url = address + portArray[0] + "/studentService";
            studentService = (StudentService) Naming.lookup(url);
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            try {
                logger.info(portArray[0]+",尝试失败，现在尝试使用的StudentService端口号是" + portArray[1] + "\n");
                url = address + portArray[1] + "/studentService";
                studentService = (StudentService) Naming.lookup(url);
            } catch (RuntimeException | MalformedURLException | NotBoundException r) {
                logger.info(portArray[0] +"    "+ portArray[1]+"都失败" + "\n");
                r.printStackTrace();
            }
            e.printStackTrace();
        }
        return studentService;
    }

    public UserService getUserService() throws RemoteException, MalformedURLException, NotBoundException {
        try {
            logger.info("现在尝试使用的 UserService 的端口号是"+portArray[0]+"\n");
             url = address + portArray[0]+"/userService";
             userService= (UserService) Naming.lookup(url);
        } catch (RuntimeException | NotBoundException | MalformedURLException r1){
          try {
              logger.info("端口:"+portArray[0]+"的UserService服务挂了\n"
                      +"现在尝试使用的 UserService 的端口号是"+portArray[1]+"\n");
              url = address+portArray[1]+"/userService";
              userService=(UserService)Naming.lookup(url);
          }catch(RuntimeException r2){
              logger.info("端口:"+portArray[1]+"的服务挂了\n");
              r2.printStackTrace();
          }
          logger.info(portArray[0]+"  "+ portArray[1] +"的服务挂了\n");
          r1.printStackTrace();
        }
        return userService;
    }

    public ProfessionService getProfessionService() throws RemoteException {
        portArray = this.getPort();
        try {
            logger.info("现在使用的 ProfessionService 的端口号是"+portArray[0]+"\n");
            url = address + portArray[0]+"/professionService";
            professionService= (ProfessionService) Naming.lookup(url);
        } catch (RuntimeException | NotBoundException | MalformedURLException r1) {
            try {
                logger.info("现在使用的 ProfessionService 的端口号是"+portArray[1]+"\n");
                url = address+portArray[1]+"/professionService";
                professionService=(ProfessionService) Naming.lookup(url);
            }catch(RuntimeException | RemoteException | MalformedURLException | NotBoundException r2){
                logger.info(portArray[0]+"  "+ portArray[1] +"的服务挂了\n");
                r2.printStackTrace();
            }
            r1.printStackTrace();
        }
        return professionService;
    }
}

