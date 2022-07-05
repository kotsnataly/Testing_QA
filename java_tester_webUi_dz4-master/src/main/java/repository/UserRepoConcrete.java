package repository;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoConcrete implements UserRepository, AutoCloseable {

    Connection connection = getMySqlDataSource("shop").getConnection("root", "000000");
    Statement statement = connection.createStatement();

    public UserRepoConcrete() throws SQLException {
    }

    //создаем таблицу пользователей в БД
    @Override
    public boolean createUsersDatabase() throws SQLException {
        reCreateDataBase(" shop");
        usePointedDbAndCreateTableOfUsers("shop", "users");
        return statement.executeUpdate("INSERT INTO users VALUES " +
                "(DEFAULT, 'Nataliya', 34, 'nata@kots.ru'), " +
                "(DEFAULT, 'Vladimir', 43, 'vova@kots.ru'), " +
                "(DEFAULT, 'Larisa', 79, 'lora@kots.ru'), " +
                "(DEFAULT, 'Lyudmila', 56, 'lyuda@kots.ru'), " +
                "(DEFAULT, 'Sergey', 67, 'serezha@kots.ru'), " +
                "(DEFAULT, 'Alla', 33, 'alla@kots.ru');") > 0 ? true : false;
    }

    //Указываем имя базы в которой создается таболица с записями над которыми проводятся операции.
    private void usePointedDbAndCreateTableOfUsers(String dbName, String tableName) throws SQLException {
        statement.execute("USE " + dbName + ";");
        statement.execute("CREATE TABLE " + tableName +
                "(id SERIAL NOT NULL, " +
                "name VARCHAR(128) NOT NULL, " +
                "age INT NOT NULL, " +
                "email VARCHAR(128) NOT NULL);");
    }


    //(Пересоздание базы данных к которой должно производиться подключение.
    private void reCreateDataBase(String name) throws SQLException {
        statement.execute("DROP DATABASE IF EXISTS " + name + ";");
        statement.execute("CREATE DATABASE " + name + " ");
    }

    //Вернуть список пользователей в виде List
    public List<User> printAllUsers() throws SQLException {
        List<User> usersToPrint = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                usersToPrint.add(new User(rs.getLong("id") + "," + rs.getString("name") + "," + rs.getString("email") + "," + rs.getInt("age")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersToPrint;
    }

    // Возвращает список пользователей с заданным диапазоном возрастов.
    public List<User> printAllByAgeBetween(int min, int max) throws SQLException {
        ArrayList<User> usersByAgeFiltered = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE age BETWEEN ? AND ?");
            ps.setString(1, String.valueOf(min));
            ps.setString(2, String.valueOf(max));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usersByAgeFiltered.add(new User(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email")));
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersByAgeFiltered;
    }

    //Удаление пользователя в БД по заданному имени.
    public boolean deleteUserByName(String nameToDelete) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE name=?");
            ps.setString(1, nameToDelete);
            return ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    //Добавление пользователя по строке в формате имя, возраст, почта. В конструктор User можно присылать как строку через \\s, так и через ','
    public boolean addUserByInitString(String name) throws SQLException {
        String[] initString = name.split("\\s");
        try {
            return statement.executeUpdate("INSERT INTO users VALUE (DEFAULT,'" + initString[0] + "', " + initString[1] + ", '" + initString[2] + "');") > 0 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    //метод подключения к БД
    private MysqlDataSource getMySqlDataSource(String name) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/" + name);
        return mysqlDataSource;
    }

    @Override
    public void close() throws Exception {
        this.close();
    }
}
