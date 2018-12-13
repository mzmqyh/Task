package com.jnshu.myutils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * @ClassName SwitchService
 * @Auther: QYH
 * @Date: 2018/12/6 21:16
 * @Description: TODO
 * @Version 1.0
 */

public class SwitchService {
    public static ApplicationContext switchBean() {
        ApplicationContext applicationContext;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i==1){
            try {
                applicationContext = new ClassPathXmlApplicationContext("conf/client1.xml");
            } catch (RuntimeException e) {
                applicationContext = new ClassPathXmlApplicationContext("conf/client2.xml");
                e.printStackTrace();
            }
        }else{
            try {
               applicationContext = new ClassPathXmlApplicationContext("conf/client1.xml");
           } catch (RuntimeException e) {
                applicationContext = new ClassPathXmlApplicationContext("conf/client2.xml");
                e.printStackTrace();
           }
       }
        return applicationContext;
    }
}
