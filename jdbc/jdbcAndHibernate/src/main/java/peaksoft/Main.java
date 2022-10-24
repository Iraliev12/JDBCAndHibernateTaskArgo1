package peaksoft;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.createUsersTable();

    }
}
