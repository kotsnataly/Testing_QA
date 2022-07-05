package deserializer;

import model.User;
import java.io.IOException;
import java.util.Collection;

interface UserDeserializer {
    Collection<User> deserialize(String filename) throws IOException;
}
