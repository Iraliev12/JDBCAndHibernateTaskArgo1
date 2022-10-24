package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    public UserDaoJdbcImpl() {
    }
    public void createUsersTable() {
        String query = "create table if not exists users1(" +
                "id serial primary key, " +
                "name varchar(50) not null," +
                "lastname varchar(50) not null," +
                "age smallint not null);";
        try (Connection conn = Util.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String droptable = "drop table if exists users1;";
        try (Connection connection = Util.connect();
             Statement stat = connection.createStatement();) {

            stat.executeUpdate(droptable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String tableinsert = "insert into users1(name,lastname,age)values (?,?,?);";//error
        try (Connection connection1 = Util.connect();
             PreparedStatement statement = connection1.prepareStatement(tableinsert)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeUserById(long id) {
        String sql = "delete from users1 where id = ?;";
        try (Connection connection = Util.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<User> getAllUsers() throws SQLException {
        String sql = "select * from users1";

        try (Connection connection = Util.connect();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException();
        }
    }
    public void cleanUsersTable() {
        String sql = "truncate table users1;";
        try(Connection connection = Util.connect();
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}