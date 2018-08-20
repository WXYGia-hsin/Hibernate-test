package com.wang.dao;

import com.wang.po.Husband;
import com.wang.po.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;


public class WifedaoImpl implements IwifeDao {
    private Configuration configuration;
    private SessionFactory sessionFactory;
    public WifedaoImpl(){
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
        }
    @Test
    public void add() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Wife wife=new Wife();
        wife.setId(3);
        wife.setWifename("Rose");
        Husband husband=new Husband();
        husband.setId(3);
        husband.setHusbandname("Jake");
        wife.setHusband(husband);
        husband.setWife(wife);
        session.save(wife);
        transaction.commit();
        session.close();
        }
    @Test
    public void del() {
     Session session=sessionFactory.openSession();
     Transaction transaction=session.getTransaction();
     transaction.begin();
     Wife wife=session.load(Wife.class,2);
     session.delete(wife);
     transaction.commit();
     session.close();
    }
    @Test
    public void queryAll() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Wife ");
        List<Wife> list=query.list();
        for (Wife wife:list) {
            System.out.println(wife.getId()+"--"+wife.getWifename());
            System.out.println(wife.getHusband().getId()+"--"+wife.getHusband().getHusbandname());
        }
        session.close();
        }
}
