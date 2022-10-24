package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;
import peaksoft.util.Util;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
   private  final SessionFactory sessionFactory = HibernateUtil.createsessionFactory();
   private  final EntityManagerFactory entityManagerFactory = HibernateUtil.createsessionFactory();
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        Session session = HibernateUtil.createsessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery("create table userss(" +
                "id serial primary key, " +
                "name varchar(50)," +
                "lastname varchar(50)," +
                "age smallint not null);");
        session.getTransaction().commit();
        session.close();
        System.out.println("create table");
    }
    @Override
    public void dropUsersTable() {
        Session session  = HibernateUtil.createsessionFactory().openSession();
        session.beginTransaction();

        session.createNativeQuery("drop table  userss").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("drop table_no error");
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error saveUsers!!!");
        }
    }
    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List userss= session.createQuery("select u from  User u").getResultList();
        session.getTransaction().commit();
        session.close();
        return userss;
    }
    @Override
    public void cleanUsersTable() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.createNativeQuery("truncate table userss").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
