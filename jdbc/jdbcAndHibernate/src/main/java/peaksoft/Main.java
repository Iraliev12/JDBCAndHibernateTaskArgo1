package peaksoft;
import peaksoft.dao.UserDaoHibernateImpl;
public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.saveUser("dfsgds","argen", (byte) 32);
        userDaoHibernate.removeUserById(1);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();

    }
}
