package peaksoft.service;

import org.hibernate.Session;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class HibarnateServiceImpl implements UserService {
    private  final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name,lastName,age);
    }
    public void removeUserById(long id) {
userDaoHibernate.removeUserById(id);
    }
    public List<User> getAllUsers() {
        userDaoHibernate.getAllUsers();
        return  null;
    }
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
