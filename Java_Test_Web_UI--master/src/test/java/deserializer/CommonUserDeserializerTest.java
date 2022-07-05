package deserializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CommonUserDeserializerTest {

    @Test
    void deserializeCsv() throws IOException {
        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();

        //в тествовом файле 10 строк, т.е. 10 User, все ли попали в коллекцию.
        Assertions.assertTrue(csvUserDeserializer.deserialize("usersPack.csv").size() == 10);

        //проверяем , возвращается ли коллекция
        Assertions.assertTrue(csvUserDeserializer.deserialize("usersPack.csv") != null);
    }

    @Test
    void deserializeJson() throws IOException {
        JsonUserDeserializer jsonUserDeserializer = new JsonUserDeserializer();

        //в тествовом файле 10 строк, т.е. 10 User, все ли попали в коллекцию.
        Assertions.assertTrue(jsonUserDeserializer.deserialize("usersPack.json").size() == 10);

        //проверяем , возвращается ли коллекция
        Assertions.assertTrue(jsonUserDeserializer.deserialize("usersPack.json") != null);
    }

    @Test
    void deserializeXml() throws IOException {
        XmlUserDeserialization xmlUserDeserialization = new XmlUserDeserialization();
        //в тествовом файле 10 строк, т.е. 10 User, все ли попали в коллекцию.
        Assertions.assertTrue(xmlUserDeserialization.deserialize("usersPack.xml").size() == 10);

        //проверяем , возвращается ли коллекция
        Assertions.assertTrue(xmlUserDeserialization.deserialize("usersPack.xml") != null);
    }
}
