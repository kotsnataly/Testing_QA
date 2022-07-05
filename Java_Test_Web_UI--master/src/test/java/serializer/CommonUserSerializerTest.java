package serializer;

import model.User;
import model.UsersList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class CommonUserSerializerTest {

    @Test
    void serializeCsv() throws IOException {
        UsersList usersList = getUsersList();

        // проверка на фактическое создание коллекции
        Assertions.assertNotNull(usersList);

        CsvUserSerializer csvUserSerializer = new CsvUserSerializer();
        csvUserSerializer.serialize(usersList, "usersPack.csv");

        // проверка на существование файла
        Assertions.assertTrue(new File("usersPack.csv").exists());
    }

    @Test
    void serializeJson() throws IOException {
        UsersList usersList = getUsersList();

        // проверка на фактическое создание коллекции
        Assertions.assertNotNull(usersList);

        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        jsonUserSerializer.serialize(usersList, "usersPack.json");

        // проверка на существование файла
        Assertions.assertTrue(new File("usersPack.json").exists());
    }

    @Test
    void serializeXml() throws IOException {
        UsersList usersList = getUsersList();

        // проверка на фактическое создание коллекции
        Assertions.assertNotNull(usersList);

        XmlUserSerializer xmlUserSerializer = new XmlUserSerializer();
        xmlUserSerializer.serialize(usersList, "usersPack.xml");

        // проверка на существование файла
        Assertions.assertTrue(new File("usersPack.xml").exists());
    }

    //Открываем указанный файл и последовательно читаем строки, разбираем каждую в массив String,
// с передачей этих значений String[] -> [0],[1],[2] в конструктор User, далее создается объект UsersList в коллекцию которого добавляются User.
    private UsersList getUsersList() {
        UsersList usersList = new UsersList();
        usersList.setUsers(new ArrayList<User>());
        try (FileInputStream in = new FileInputStream("listOfUsers.txt")) {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String[] newUserInit = scanner.nextLine().split(";");
                User newUserToArrayList = new User();
                newUserToArrayList.setId(Integer.parseInt(newUserInit[0]));
                newUserToArrayList.setName(newUserInit[1]);
                newUserToArrayList.setEmail(newUserInit[2]);
                usersList.getUsers().add(newUserToArrayList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}