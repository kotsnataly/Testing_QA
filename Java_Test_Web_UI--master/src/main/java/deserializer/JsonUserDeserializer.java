package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import model.User;
import model.UsersList;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonUserDeserializer implements UserDeserializer{
    public Collection<User> deserialize(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerFor(UsersList.class);
        UsersList u = null;
        u = objectReader.readValue(new File(filename), UsersList.class);
        return u.getUsers();
    }
}
