package com.wang.dao;

import com.wang.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StudentQuery implements IQuery{
    private Configuration configuration;
    private SessionFactory sessionFactory;
    public StudentQuery(){
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }

    @Override
    public void simpleQuery() {
        Session session=sessionFactory.openSession();
        List students = session.createQuery("select studentName from Student").list();
        for (Object s:students) {
            System.out.println(s);
        }
    }
    @Test
    @Override
    public void propertyQuery() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("select studentId,studentName from Student ");
        List<Object[]> list = query.list();
        for(Object[] message:list){
            System.out.println(Arrays.toString(message));
        }
    }
    @Test
    @Override
    public void instantiateQuery() {
        Session session=sessionFactory.openSession();
        Iterator iter = session.createQuery("from Student").iterate();
        while (iter.hasNext()) {
            Student student = (Student)iter.next();
            System.out.println(student.getStudentId()+" "+student.getStudentName());
        }
    }

    @Test
    @Override
    public void statisticalQuery() {
        Session session=sessionFactory.openSession();
        List students=session.createQuery("select count(*) from Student").list();
        Long count=(Long)students.get(0);
        System.out.println(count);
    }
    @Test
    @Override
    public void subQuery() {
        Session session=sessionFactory.openSession();
        String hql="select wifename from Wife where id  in  (select id  from Husband  where id =21)";
        Query query= session.createQuery(hql);
        List<String> list = query.list();
        for(String message:list){
            System.out.println(message);
        }
    }
}
