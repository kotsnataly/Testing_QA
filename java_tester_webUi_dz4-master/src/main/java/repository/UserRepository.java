package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    boolean createUsersDatabase() throws SQLException;

    List<User> printAllUsers() throws SQLException;

    List<User> printAllByAgeBetween(int min, int max) throws SQLException;

    boolean deleteUserByName(String name) throws SQLException;

    boolean addUserByInitString(String name) throws SQLException;

}
