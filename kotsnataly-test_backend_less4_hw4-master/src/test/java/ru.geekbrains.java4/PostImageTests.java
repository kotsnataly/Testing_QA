package ru.geekbrains.java4;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import ru.geekbrains.java4.dto.ImgurPostErrorResponse;
import ru.geekbrains.java4.dto.PostErrorResponse;
import ru.geekbrains.java4.utils.FileEncodingUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@Feature("")
public class PostImageTests extends BaseTest {

    static final String INPUT_IMAGE_FILE_PATH = "avatar.jpg";
    private String deleteHash;
    MultiPartSpecification multiPartSpec;
    RequestSpecification uploadReqSpec;

    @Test
    void uploadFileTest() {

        byte[] fileContent = FileEncodingUtils.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(fileContent)
                .controlName("image")
                .build();
        uploadReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "")
                .formParam("description", "");

        deleteHash = given()
                .spec(uploadReqSpec)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post(Endpoints.POST_IMAGE_REQUEST)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test //1 проверка на то что большой файл загрузить не даст ( больше 10мб)
    @Tag("SkipCleanup")
    void tryToLoadBigFile() {
        FileEncodingUtils.INPUT_IMAGE_FILE_PATH = Images.TOO_BIG.path;
        byte[] bigJpg = FileEncodingUtils.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(bigJpg)
                .controlName("image")
                .build();
        uploadReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "Some picture")
                .formParam("description", "size > 10mb");


        given()
                .spec(uploadReqSpec)
                .expect()
                .body("success", is(false))
                .body("data.id", is(null));
    }

    @Test //2 проверка на то что нулевой размер тоже не загрузит и также Json с ImgurException с несколькими ассертами.
    @Tag("SkipCleanup")
    void tryToLoadZeroFile() {
        FileEncodingUtils.INPUT_IMAGE_FILE_PATH = Images.ZERO_SIZE.path;
        byte[] bigJpg = FileEncodingUtils.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(bigJpg)
                .controlName("image")
                .build();
        uploadReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "empty")
                .formParam("description", "zero size");


        ImgurPostErrorResponse iper = given()
                .spec(uploadReqSpec)
                .expect()
                .body("success", is(false))
                .when()
                .post(Endpoints.POST_IMAGE_REQUEST)
                .prettyPeek()
                .then()
                .extract()
                .response().as(ImgurPostErrorResponse.class);
        Assertions.assertTrue(iper.getData().request.equals("/3/image"));
        Assertions.assertTrue(iper.getData().getErrorDetails().getCode()==1003);
        Assertions.assertTrue(iper.getData().getErrorDetails().getMessage().equals("File type invalid (1)"));
        Assertions.assertTrue(iper.getData().getErrorDetails().getType().equals("ImgurException"));
    }

    @Test //3 обычный файл
    void tryToLoadUsualFilе() {
        FileEncodingUtils.INPUT_IMAGE_FILE_PATH = Images.SMALL.path;
        byte[] bigJpg = FileEncodingUtils.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(bigJpg)
                .controlName("image")
                .build();
        uploadReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "Some picture")
                .formParam("description", "usual size");


        deleteHash = given()
                .spec(uploadReqSpec)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post(Endpoints.POST_IMAGE_REQUEST)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test //4 проверка работы с Json ответом на большой файл.
    @Tag("SkipCleanup")
    void bigFileJsonResponseCheck() {
        FileEncodingUtils.INPUT_IMAGE_FILE_PATH = Images.TOO_BIG.path;
        byte[] bigJpg = FileEncodingUtils.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(bigJpg)
                .controlName("image")
                .build();
        uploadReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "Some picture")
                .formParam("description", "size > 10mb");


        PostErrorResponse per = given()
                .spec(uploadReqSpec)
                .expect()
                .body("success", is(false))
                .when()
                .post(Endpoints.POST_IMAGE_REQUEST)
                .prettyPeek()
                .then()
                .extract()
                .response().as(PostErrorResponse.class);
        Assertions.assertTrue("File is over the size limit".equals(per.getData().error));
    }


    @AfterEach
    @Step("Удалить файл после теста")
    void tearDown(TestInfo testInfo) {//проверка на скиптаг чтобы не выбрасывались эксцепшены.
        if (testInfo.getTags().contains("SkipCleanup")) {
            return;
        }//конец проверки
        given()
                .headers("Authorization", token)
                .when()
                .delete("/account/{username}/image/{deleteHash}", username, deleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);

    }
}
