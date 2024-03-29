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

        //1.创建一个SessionFactory对象
        SessionFactory sessionFactory = null;
        //1) 创建 Configuration 对象：对应Hiberate的基本配置信息和对象关系映射信息
        Configuration configuration = new Configuration().configure();
        //Hiberate的任何配置和服务都需要在该对象中注册后才能有效
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //2.创建一个Session对象
        Session session = sessionFactory.openSession();
        //3.开启事务
        Transaction transaction = session.beginTransaction();
        //4.执行保存的操作
//        News news = new News("Java","MouseSun",new Date(new Date().getTime()));
//        session.save(news);
        News news = (News) session.get(News.class,1);
        println(news);
        //5.提交事务
        transaction.commit();
        //6.关闭Session
        session.close();
        //7.关闭SessionFactory对象
        sessionFactory.close();

    }
}
