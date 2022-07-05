package ru.geekbrains.java4;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java4.dto.ImageClass;
import ru.geekbrains.java4.dto.PostImageResponse;
import ru.geekbrains.java4.steps.CommonRequests;

import static io.restassured.RestAssured.given;
import static ru.geekbrains.java4.steps.CommonRequests.uploadCommonImage;

@Slf4j
public class GetImageTests extends BaseTest {
    static RequestSpecification withoutAuthReqSpec;
    static RequestSpecification withAuthReqSpec;

    String deletehash;
    String imgid;

    @BeforeAll
    static void createSpecs() {
        withoutAuthReqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "")
                .build();
        withAuthReqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .log(LogDetail.ALL)
                .build();

    }

//    @BeforeEach
//    void setUp() {
//        CommonRequests cr = new CommonRequests("SMALL");
//        PostImageResponse pr = cr.uploadCommonImage(withAuthReqSpec);
//        deletehash = pr.getData().getDeletehash();
//        imgid = pr.getData().getId();
//    }

    @Test
    void getImageInfoPositiveTest() {
        given()
                .spec(withAuthReqSpec)
                .log()
                .all()
                .when()
                .get(Endpoints.GET_IMAGE_REQUEST, imgid)
                .prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
        //1
    void getImageCorrectDeleteHashLength() {
        ImageClass response = given()
                .spec(withAuthReqSpec)
                .when()
                .get(Endpoints.GET_IMAGE_REQUEST, imgid)
                .then()
                .spec(responseSpecification)
                .extract().as(ImageClass.class);
        assert (response.getData().getDeletehash().length() == 15);
    }

    @Test
        //2
    void notAdvertismentImage() {
        ImageClass response = given()
                .spec(withAuthReqSpec)
                .when()
                .get(Endpoints.GET_IMAGE_REQUEST, imgid)
                .then()
                .spec(responseSpecification)
                .extract().as(ImageClass.class);
        assert (response.getData().getIsAd() == false);
    }


    @Test
        //3
    void isImage() {
        ImageClass response = given()
                .spec(withAuthReqSpec)
                .when()
                .get(Endpoints.GET_IMAGE_REQUEST, imgid)
                .then()
                .spec(responseSpecification)
                .extract().as(ImageClass.class);
        assert (response.getData().getType().equals("image/jpeg"));
    }


    @AfterEach
    @Step("Удалить файл после теста")
    void tearDown() {
        given()
                .spec(withAuthReqSpec)
                .when()
                .delete(Endpoints.DELETE_IMAGE_REQUEST, username, deletehash)
                .prettyPeek()
                .then()
                .statusCode(200);

    }
}
