package serializer;

import model.UsersList;
import java.io.IOException;

public interface UserSerializer {
     void serialize(UsersList usersList, String filename) throws IOException;
}
