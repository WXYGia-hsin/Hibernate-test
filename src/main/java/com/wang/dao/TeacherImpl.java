package com.wang.dao;

import com.wang.po.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import java.util.Iterator;
import java.util.Set;

public class TeacherImpl implements IteacherDao {
    private Configuration configuration;
    private SessionFactory sessionFactory;
    public TeacherImpl(){
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }
    @Test

    public void add() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Teacher teacher1=new Teacher();
        teacher1.setTeacherId(4);
        teacher1.setTeacherName("Abel");
        Student student1=new Student();
        student1.setStudentId(4);
        student1.setStudentName("王茜宇");
        Student student2=new Student();
        student2.setStudentId(5);
        student2.setStudentName("一班21");
        teacher1.getStudents().add(student1);
        teacher1.getStudents().add(student2);
        session.save(teacher1);
        transaction.commit();
        session.close();

    }
    @Test
    @Override
    public void del() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Teacher teacher1=session.load(Teacher.class,1);
        session.delete(teacher1);
        transaction.commit();
        session.close();

    }
    @Test
    @Override
    public void queryAll() {
        Session session=sessionFactory.openSession();
        Teacher teacher=(Teacher)session.load(Teacher.class,3);
        System.out.println("老师姓名"+teacher.getTeacherName());
        Set<Student> studentSet=teacher.getStudents();
        Iterator<Student> iterator=studentSet.iterator();
        while (iterator.hasNext()){
            System.out.println("学生姓名"+iterator.next().getStudentName());
        }
        session.close();
        }

    }

