package service;

import dao.StudentDao;
import memcached.StudentMemcached;
import memcached.StudentRedis;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Student;

import java.util.List;
import java.util.logging.LogManager;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    Logger logger = Logger.getLogger("StudentServiceImpl.class");
    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentMemcached studentMemcached;
    @Autowired
    StudentRedis studentRedis;


    @Override
    public long countAll() {
        if (studentRedis.getRed("stuNum") != null) {
            logger.info("获取所有学生red缓存");
            return (long)studentRedis.getRed("stuNum");
        }
        logger.info("获取所有学生数据");
        studentRedis.setRed("stuNum", studentDao.countAll());
        logger.info("添加所有学生red缓存");
        return studentDao.countAll();
    }

    @Override
    public long insertStudent(Student student) {
        long time = System.currentTimeMillis();
        student.setCreateTime(time);
        student.setUpdateTime(time);
        studentDao.insertStudent(student);
        if (studentRedis.getRed("stuNum") != null) {
            logger.info("更新red所有学生缓存");
            studentRedis.setRed("stuNum", studentDao.countAll());
        }
        return student.getId();
    }

    @Override
    public long regStudent(Student student) {
        long time = System.currentTimeMillis();
        student.setCreateTime(time);
        student.setUpdateTime(time);
        if (studentRedis.getRed("stuNum") != null) {
            logger.info("更新red所有学生缓存");
            studentRedis.setRed("stuNum", studentDao.countAll());
        }
        studentDao.regStudent(student);
        return student.getId();
    }

    @Override
    public void deleteAll() {
        studentDao.deleteAll();
    }

    @Override
    public long countJob() {
        if (studentRedis.getRed("jobNum") != null) {
            logger.info("获取red工作数缓存");
            return (long)studentRedis.getRed("jobNum");
        }
        logger.info("获取工作数数据");
        studentRedis.setRed("jobNum", studentDao.countJob());
        return studentDao.countJob();
    }

//    @Override
//    public List<Student> findGood() {
//        if (studentMemcached.getgood("goodstu") != null) {
//            logger.info("获取优秀学员数mem缓存");
//            List<Student> goodlist = studentMemcached.getgood("goodstu");
//            return goodlist;
//        }
//        logger.info("获取优秀学员数数据");
//        List<Student> goodlist = studentDao.findGood();
//        studentMemcached.setgood("goodstu", goodlist);
//
//        return goodlist;
//    }

    @Override
    public List<Student> findGood() {
        if (studentRedis.getRed("goodstu") != null) {
            logger.info("获取优秀学员数red缓存");
            List<Student> goodlist = (List<Student>)studentRedis.getRed("goodstu");
            return goodlist;
        }
        logger.info("获取优秀学员数数据");
        List<Student> goodlist = studentDao.findGood();
        studentRedis.setRed("goodstu", goodlist);

        return goodlist;
    }





    @Override
    public int countCourse(String cour) {
        int courseNum = studentDao.countCourse(cour);
        return courseNum;
    }

    @Override
    public boolean deleteById(long id) {
        return studentDao.deleteById(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        long time = System.currentTimeMillis();
        student.setUpdateTime(time);
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean updateLogin(Student student) {
        long time = System.currentTimeMillis();
        student.setLoginTime(time);
        return studentDao.updateLogin(student);
    }


    @Override
    public Student findById(long id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findLikeName(String name) {
        return studentDao.findLikeName(name);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student signIn(Student student) {
        return studentDao.signIn(student);
    }

//    @Override
//    public boolean findByName(String stuName) {
//        return studentDao.findByName(stuName);
//    }

    @Override
    public Student findByName(String stuName) {
        return studentDao.findByName(stuName);
    }
}

