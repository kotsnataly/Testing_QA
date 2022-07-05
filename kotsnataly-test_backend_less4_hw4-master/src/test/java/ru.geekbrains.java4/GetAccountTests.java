package ru.geekbrains.java4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java4.dto.AccountSettingsClass;
import ru.geekbrains.java4.dto.GetAccountResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class GetAccountTests extends BaseTest {
    static RequestSpecification withoutAuthReqSpec;

    @BeforeAll
    static void createSpecs() {
        withoutAuthReqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "")
                .build();

    }


    @Test
    void getAccountInfoPositiveTest() {
        given()
                .spec(reqSpec)
                .log()
                .all()
                .when()
                .get(Endpoints.GET_ACCOUNT_REQUEST, username)
                .prettyPeek()
                .then()
//                .spec(responseSpecification)
        ;
    }

    @Test
    void getAccountInfoNegativeWithoutAuthTest() {
        given()
                .spec(withoutAuthReqSpec)
                .when()
                .get("https://api.imgur.com/3/account/Shakjamuni")
                .prettyPeek();
    }

    @Test
    void getAccountInfoPositiveWithManyChecksTest() {
        given()
                .headers("Authorization", token)
                .expect()
                .body(CoreMatchers.containsString(username))
                .body("success", is(true))
                .when()
                .get("/account/{username}", username)
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoPositiveWithObjectTest() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getData().getUrl(), equalTo("Shakjamuni"));
    }

    @Test        //1
    void getAccountInfoToVerifyUsernameEquality() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getUrl(), equalTo(username));
    }

    @Test        //2
    void verifyAnswerOnAvatarLink() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getAvatar(), equalTo("https://imgur.com/user/Shakjamuni/avatar?maxwidth=290"));
    }

    @Test        //3
    void getAccountReputationIsNotNullField() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        Assertions.assertNotNull(response.getData().getReputation());
    }

    @Test        //4
    void getAccountReputationMiscasting() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getReputation(), equalTo(0));
        assertThat(response.getData().getReputationName(), equalTo("Neutral"));

    }

    @Test        //5
    void getAccountIdCorrect() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getId(), equalTo("145559589"));
    }

    @Test        //6
    void getAccountAvatarInfoSize() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getAvatar(), containsString("avatar?maxwidth=290"));
    }

    @Test        //7
    void getAccountTimeStamp() {
        GetAccountResponse response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/" + username)
                .then()
                .extract()
                .body()
                .as(GetAccountResponse.class);
        assertThat(response.getData().getCreated(), equalTo(1613651953));
    }
// несколько тестов подвязанных на AccountSettingsClass
    @Test        //8
    void getAccountUserEmail() {
        AccountSettingsClass response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/me/settings")
                .then()
                .extract()
                .body()
                .as(AccountSettingsClass.class);
        assertThat(response.getData().getEmail(),equalTo("vladimir.rumyancev.vr@gmail.com"));
    }

    @Test        //9
    void getAccountCheckSubscription() {
        AccountSettingsClass response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/me/settings")
                .then()
                .extract()
                .body()
                .as(AccountSettingsClass.class);
        assertThat(response.getData().getMessagingEnabled(),equalTo(true));
    }
    @Test        //9
    void getAccountMatureEnabled() {
        AccountSettingsClass response = given()
                .spec(reqSpec)
                .when()
                .get("https://api.imgur.com/3/account/me/settings")
                .then()
                .extract()
                .body()
                .as(AccountSettingsClass.class);
        assertThat(response.getData().getShowMature(),equalTo(true));
    }
}