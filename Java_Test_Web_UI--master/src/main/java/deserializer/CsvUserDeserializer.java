package deserializer;


import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import model.User;
import model.UsersList;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CsvUserDeserializer implements UserDeserializer {

    public Collection<User> deserialize(String filename) throws IOException {
        UsersList userCollection = new UsersList();
        CsvMapper csvMapper = new CsvMapper();
        userCollection.setUsers(new ArrayList<>());

        //Этот способ бросает com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize instance of `model.User` out of START_ARRAY token
//        at [Source: (com.fasterxml.jackson.dataformat.csv.impl.UTF8Reader); line: -1, column: -1]
//        Есть вартант создания объекта путемо обращения ObjReader к String[].class и инстанциирования объекта User через массив строковых значений.
//        ObjectReader objectReader = csvMapper.readerFor(User.class);
//        User toAdd = objectReader.readValue(new File(filename), User.class);
//        userCollection.getUsers().add(toAdd);


//        Такой способ работает, хотя вообще без библиотек получается вариант.
        try (Reader reader = new FileReader(filename)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                User currUser = new User(scanner.nextLine());
                userCollection.getUsers().add(currUser);
            }
        }
        return userCollection.getUsers();
    }
}
