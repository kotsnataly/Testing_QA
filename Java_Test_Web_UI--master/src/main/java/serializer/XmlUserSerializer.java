package serializer;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.UsersList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlUserSerializer {

    public void serialize(UsersList usersList, String filename) throws IOException {
        //удаляем файл filename для чистоты тестов
        try {
            Files.delete(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Файла такого нет.");
        }
        XmlMapper mapper = new XmlMapper();
        ObjectWriter objectWriter = mapper.writerFor(UsersList.class);
        File file = new File(filename);
        objectWriter.writeValue(file, usersList);

    }
}
