package com.jnshu.controller;

import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;
import com.jnshu.myutils.ChooseServer;
import com.jnshu.service.ProfessionService;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.RemoteException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    ChooseServer chooseServer;
    private StudentService studentService;
    private ProfessionService professionService;

    @RequestMapping( value = "task-91", method = RequestMethod.GET )
    public ModelAndView firstPage(ModelAndView modelAndView) throws RemoteException {
        studentService=chooseServer.getStudentService();
        long[] studentIds={1L,2L,3L,4L,5L,6L,7L,8L,9L,10L};
        List <Student> studentList = studentService.getStudentByIdIndex(studentIds);
        long onlinCount = studentService.SelectCountByState(true);
        long graduateCount = studentService.SelectCountByState(false);
        modelAndView.addObject("onlinCount", onlinCount);
        modelAndView.addObject("graduateCount", graduateCount);
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("bodyname", "task-91");
        modelAndView.setViewName("myView1");
        return modelAndView;
    }

    @RequestMapping( value = "task-92", method = RequestMethod.GET )
    public ModelAndView secondPage(ModelAndView modelAndView) throws RemoteException {
        studentService=chooseServer.getStudentService();
        //modelAndView.addObject(, );
        modelAndView.addObject("bodyname", "task-92");
        modelAndView.setViewName("myView1");
        return modelAndView;
    }

    @RequestMapping( value = "/u/task-93", method = RequestMethod.GET )
    public ModelAndView thirdPage(ModelAndView modelAndView) throws RemoteException {
        professionService = chooseServer.getProfessionService();
        studentService=chooseServer.getStudentService();
        long count = 0;
        List <Profession> professionList = professionService.getOneByPrimaryKey(10);
        count = studentService.CountSelective("前端工程师", false);
        modelAndView.addObject("professionList", professionList);
        modelAndView.addObject("count", count);
        modelAndView.addObject("bodyname", "task-93");
        modelAndView.setViewName("myView1");
        return modelAndView;
    }
}

