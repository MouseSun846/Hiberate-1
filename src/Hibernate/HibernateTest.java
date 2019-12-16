package Hibernate;
import static myprint.Print.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Date;

public class HibernateTest {

    @Test
    public void test(){

        //1.����һ��SessionFactory����
        SessionFactory sessionFactory = null;
        //1) ���� Configuration ���󣺶�ӦHiberate�Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
        Configuration configuration = new Configuration().configure();
        //Hiberate���κ����úͷ�����Ҫ�ڸö�����ע��������Ч
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //2.����һ��Session����
        Session session = sessionFactory.openSession();
        //3.��������
        Transaction transaction = session.beginTransaction();
        //4.ִ�б���Ĳ���
//        News news = new News("Java","MouseSun",new Date(new Date().getTime()));
//        session.save(news);
        News news = (News) session.get(News.class,1);
        println(news);
        //5.�ύ����
        transaction.commit();
        //6.�ر�Session
        session.close();
        //7.�ر�SessionFactory����
        sessionFactory.close();

    }
}
