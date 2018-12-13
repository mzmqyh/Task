package com.jnshu.mapper;

import com.jnshu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<Student> {

    Student findById(Long id);

    long batchSave(List <Student> student4List);

    List <Student> getStudentByPage(int startRow, int endRow);
    List<Student> getStudentByIdIndex(@Param( "p1" ) long[] studentIds);
}