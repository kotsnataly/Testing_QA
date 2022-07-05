package serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;
import model.UsersList;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class CsvUserSerializer {
    public void serialize(UsersList usersList, String filename) throws IOException {
//удаляем файл filename для чистоты тестов
        try {
            Files.delete(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Файл " + filename + " не существует.");
        }
        CsvMapper mapper = new CsvMapper();
        mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        mapper.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
        CsvSchema schema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("name")
                .addColumn("email").build();


//Этот способ не работает так как CsvMapper не подерживает работы с вложенными объектами, их надо парсить отдельно.
//        CsvSchema schema = CsvSchema.builder()
//                .addColumn("users")
//                .build();
//        ObjectWriter objectWriter = mapper.writer(schema);
//        objectWriter.writeValue(new File(filename), usersList);

        ObjectWriter objectWriter = mapper.writer(schema);
        Collection<User> userCollection = usersList.getUsers();
        try (FileWriter file = new FileWriter(filename, true)) {
            for (User u : userCollection) {
                objectWriter.writeValue(file, u);
            }
        }
    }
}
