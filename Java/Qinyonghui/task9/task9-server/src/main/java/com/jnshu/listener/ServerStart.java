package com.jnshu.listener;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @ClassName ServerStart
 * @Auther: QYH
 * @Date: 2018/12/11 20:38
 * @Description: TODO
 * @Version 1.0
 */
public class ServerStart {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Logger logger = Logger.getLogger(Listener.class);
       // System.setProperty("java.rmi.server.hostname", "106.14.4.157");
        logger.info("服务端开始启动..........");
        Node node = NodeFactory.getInstance().createNode("conf/tuscany.composite");
        node.start();
        logger.info("服务端启动结束");
       // StudentService studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8816/student");
        //logger.info("服务端Tuscany RMI测试："+studentService.findStudentById(10L));
    }
}
