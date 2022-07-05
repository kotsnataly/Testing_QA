package ru.geekbrans.kotsnataly.test_backend_4.less3.uploadimg;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import netscape.javascript.JSObject;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ImageTests extends BaseTest{

    String encodedImage;
    String uploadedImageHashCode;

    @BeforeEach
    void setUp() {
        byte[] fileContent = getFileContentInBase64();
        encodedImage = Base64.getEncoder().encodeToString(fileContent);
    }

    @Test
    @Tag("SkipCleanup")  //таг для пропуска в tearDown
    void getImageSimpleTest() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .statusCode(200);

    }
    @Test
    @Tag("SkipCleanup")  //таг для пропуска в tearDown
    void getUnexistenceImageSimpleTest() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+unexistenceHash)
                .then()
                .statusCode(404);

    }

    @Test
    @Tag("SkipCleanup")
    void getImageJsonCorrectDescription() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.description").equals("Everybody be cool, it is a Yoda");
    }

    @Test
    @Tag("SkipCleanup")
    void getImageSizeIsCorrect() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.width").equals("600");
    }

    @Test
    @Tag("SkipCleanup")
    void isImage() {
        String answer = given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.type");
        Assertions.assertTrue("image/jpeg".equals(answer));
    }


    @Test
    @Tag("SkipCleanup")
    void isSizeOfImageisNotNull() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .body("data.size",is(notNullValue()));
    }

    @Test
    @Tag("SkipCleanup")
    void isDeleteHashPresented() {
        given()
                .headers("Authorization", token)
                .get("https://api.imgur.com/3/image/"+imageHash)
                .then()
                .body("data.deletehash",is(notNullValue()));

    }

    @Test
    @Tag("SkipCleanup")
    void tryingToDeleteBeingAnauthed() {
        given()
                .delete("https://api.imgur.com/3/image/" + imageHash)
                .then()
                .statusCode(401);
        //в постмане возвращает 403, а здесь 401.
    }


    @Test
    @Tag("SkipCleanup")
    void tryingToUploadHugeFile() {
        String answer = given()
                .headers("Authorization", token)
                .header("image", veryBigFile)
                .post("https://api.imgur.com/3/image")
                .then()
                .statusCode(400)
                .extract()
                .response()
                .jsonPath()
                .getString("data.error");
        Assertions.assertTrue("No image data was sent to the upload api".equals(answer));

    }

    @Test
    @Tag("SkipCleanup")
    void tryToPostNonImage() {
        String answer = given()
                .headers("Authorization", token)
                .header("image", nonImage)
                .post("https://api.imgur.com/3/image")
                .then()
                .statusCode(400)
                .extract()
                .jsonPath()
                .getString("data.error");
        Assertions.assertTrue("No image data was sent to the upload api".equals(answer));

    }


    //legacy test
    @Test
    void uploadFileTest() {
        uploadedImageHashCode = given()
                .headers("Authorization", token)
                .multiPart("image", encodedImage)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @AfterEach
    void tearDown(TestInfo testInfo) { //проверка на скиптаг чтобы не выбрасывались эксцепшены.
        if(testInfo.getTags().contains("SkipCleanup")) {
            return;
        }//конец проверки

        given()
                .headers("Authorization", token)
                .when()
                .delete("account/{username}/image/{deleteHash}", username, uploadedImageHashCode)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    private byte[] getFileContentInBase64() {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(Objects.requireNonNull(classLoader.getResource("avatar.png")).getFile());
        byte[] fileContent = new byte[0];
        try {
            fileContent =   FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
