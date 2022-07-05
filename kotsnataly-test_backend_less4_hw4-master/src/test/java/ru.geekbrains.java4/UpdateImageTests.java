package ru.geekbrains.java4;

import io.qameta.allure.Step;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import ru.geekbrains.java4.dto.ImageClass;
import ru.geekbrains.java4.utils.FileEncodingUtilsWithRandPict;

import java.util.Calendar;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static ru.geekbrains.java4.GetImageTests.withAuthReqSpec;

public class UpdateImageTests extends BaseTest {
    String yodaHash = "HHtVazd";
    String imgHash;
    String imgDeleteHash;
    private String deleteHash;
    MultiPartSpecification multiPartSpec;
    RequestSpecification updateReqSpec, updateYodaReqSpec;

    @BeforeAll
    static void createSpecs() {

        withAuthReqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .log(LogDetail.ALL)
                .build();

    }

    @BeforeEach
    void setUp() {
        byte[] fileContent = FileEncodingUtilsWithRandPict.getFileContent();
        multiPartSpec = new MultiPartSpecBuilder(fileContent)
                .controlName("image")
                .build();
        updateReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "updating info of image")
                .formParam("description", "updated info on" + Calendar.getInstance().getTime());

    }

    @Test // просто обновление title и description
    @Tag("SkipCleanup")
    void updateImgTest() {
        updateYodaReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "This is Yooooooddaaaa!!!!!!")
                .formParam("description", "updated info on" + Calendar.getInstance().getTime());
        given()
                .spec(updateYodaReqSpec)
                .log()
                .all()
                .expect()
                .body("success", is(true))
                .when()
                .post(baseURI + "/image/" + yodaHash);
    }

    @Test // добавляем в favorite
    @Tag("SkipCleanup")
    void makeFavorite() {
        updateYodaReqSpec = reqSpec.multiPart(multiPartSpec)
                .formParam("title", "This is Yooooooddaaaa!!!!!!")
                .formParam("description", "updated info on" + Calendar.getInstance().getTime());
        given()
                .spec(updateYodaReqSpec)
                .log()
                .all()
                .expect()
                .body("success", is(true))
                .when()
                .post(baseURI + "/image/" + yodaHash + "/favorite");

        // создаем POJO из респонса и проверяем что favorite = true
        ImageClass yoda = given()
                .spec(withAuthReqSpec)
                .log()
                .all()
                .when()
                .get(Endpoints.GET_IMAGE_REQUEST + yodaHash)
                .as(ImageClass.class);

        Assertions.assertTrue(yoda.getData().getFavorite());
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
                .delete("/account/{username}/image/{deleteHash}", username, imgDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);

    }
}
