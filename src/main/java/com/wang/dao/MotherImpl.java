package com.wang.dao;

import com.wang.po.Children;
import com.wang.po.Mother;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import java.util.Iterator;
import java.util.Set;

public class MotherImpl implements ImotherDao {
    private Configuration configuration;
    private SessionFactory sessionFactory;
    public MotherImpl(){
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }
    @Test
    @Override
    public void add() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Mother mother=new Mother();
        mother.setId(4);
        mother.setMothername("Mary");
        Children children1=new Children();
        Children children2=new Children();
        children1.setChildId(4);
        children1.setChildname("John");
        children1.setMother(mother);
        mother.getChildren().add(children1);
        children2.setChildId(21);
        children2.setChildname("王茜宇");
        children2.setMother(mother);
        mother.getChildren().add(children2);
        session.save(mother);
        transaction.commit();
        session.close();
        }
    @Test
    @Override
    public void del() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Mother mother=(Mother)session.load(Mother.class,3);
        session.delete(mother);
        transaction.commit();
        session.close();

    }
    @Test
    @Override
    public void queryAll() {
        Session session=sessionFactory.openSession();
        Mother mother=(Mother)session.load(Mother.class,1);
        System.out.println(mother.getMothername());
        Set<Children> childrenSet=mother.getChildren();
        Iterator<Children> iterator=childrenSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getChildname());
            }
        session.close();

    }
}
