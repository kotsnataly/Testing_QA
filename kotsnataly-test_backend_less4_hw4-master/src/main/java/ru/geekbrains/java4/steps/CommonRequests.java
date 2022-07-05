package ru.geekbrains.java4.steps;

import com.github.javafaker.Faker;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;
import ru.geekbrains.java4.dto.PostImageResponse;
import ru.geekbrains.java4.utils.FileEncodingUtils;

import static io.restassured.RestAssured.given;

public class CommonRequests {

    public static PostImageResponse uploadCommonImage(RequestSpecification spec) {
        RequestSpecification multiPart = spec
                .multiPart(
                        new MultiPartSpecBuilder(FileEncodingUtils.getFileContent())
                                .controlName("image")
                                .build());
        return given()
                .spec(multiPart)
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .extract()
                .body()
                .as(PostImageResponse.class);
    }
}
