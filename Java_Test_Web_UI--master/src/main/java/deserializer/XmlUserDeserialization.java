package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.User;
import model.UsersList;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlUserDeserialization implements UserDeserializer {
    @Override
    public Collection<User> deserialize(String filename) throws IOException {
        XmlMapper objectMapper = new XmlMapper();
        ObjectReader objectReader = objectMapper.readerFor(UsersList.class);
        UsersList u = null;
        u = objectReader.readValue(new File(filename), UsersList.class);
        return u.getUsers();
    }
}
