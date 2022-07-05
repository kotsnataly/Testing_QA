package repository;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class UserRepoConcreteTest {

    @Test
        // проверка работы метода получеаещего список пользователей
    void printAllUsers() throws SQLException {
        UserRepoConcrete userRepoConcrete = new UserRepoConcrete();

        Assertions.assertNotNull(userRepoConcrete.printAllUsers());
        Assertions.assertTrue(userRepoConcrete.printAllUsers().size() > 0);
        System.out.println(userRepoConcrete.printAllUsers());
    }

    @Test
        //проверка работы метода получаешего список пользователей по диапазону возврастов.
    void printAllByAgeBetween() throws SQLException {
        UserRepoConcrete userRepoConcrete = new UserRepoConcrete();
        userRepoConcrete.printAllByAgeBetween(30, 50);
        Assertions.assertEquals(3, userRepoConcrete.printAllByAgeBetween(30, 50).size());
    }

    @Test
        //проверка роботы метода удаляещего запись по указанному имени
    void deleteUserByName() throws SQLException {
        UserRepoConcrete userRepoConcrete = new UserRepoConcrete();

        Assertions.assertTrue(userRepoConcrete.deleteUserByName("Bob"));

    }

    @Test
        //проверка работы метода добавления пользователя в БД по строке , формата "имя возвраст почта"
    void addUserByInitString() throws SQLException {
        UserRepoConcrete userRepoConcrete = new UserRepoConcrete();

        Assertions.assertTrue(userRepoConcrete.addUserByInitString("Bob 32 bob32@gmail.com"));
    }


    @Test
//тест создания и наполнения базы данных
    void createUsersDatabase() throws SQLException {
        UserRepoConcrete userRepoConcrete = new UserRepoConcrete();
        Assertions.assertTrue(userRepoConcrete.createUsersDatabase());


    }

    private List<User> newUsers() {
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("1,Sergey,sergey@gmail.com"));
        userArrayList.add(new User("2,Anna,anna@mail.com"));
        userArrayList.add(new User("3,Petr,petr@mail.com"));
        userArrayList.add(new User("4,Artem,example@gmail.com"));
        userArrayList.add(new User("5,Viktor,viktor@gmail.com"));
        userArrayList.add(new User("6,Mariya,mariya@gmail.com"));

        return userArrayList;
    }
}