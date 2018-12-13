package com.jnshu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * @ClassName Listener
 * @Auther: QYH
 * @Date: 2018/12/11 20:05
 * @Description: TODO
 * @Version 1.0
 */
public class Listener implements ServletContextListener {
    Logger logger = Logger.getLogger(Listener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.setProperty("java.rmi.server.hostname", "106.15.203.211");
        logger.info("服务端开始启动..........");
        Node node = NodeFactory.getInstance().createNode("conf/tuscany.composite");
        node.start();
        logger.info("服务端启动结束");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
