package ru.geekbrans.kotsnataly.test_backend_4.less3.uploadimg;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class BaseTest {
    protected static Properties prop = new Properties();
    protected static String token;
    protected static String username;
    protected static String imageHash;
    protected static String unexistenceHash;
    protected static String veryBigFile;
    protected static String nonImage;
    protected static Map<String, String> headers = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        loadProperties();
        token = prop.getProperty("token");
        headers.put("Authorization", token);
        imageHash = prop.getProperty("imageHash");
        unexistenceHash = prop.getProperty("unexistenceHash");
        veryBigFile = prop.getProperty("veryBigFile");
        nonImage = prop.getProperty("nonImage");
        RestAssured.baseURI = prop.getProperty("base.url");
        username = prop.getProperty("username");
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    private static void loadProperties() {
        try {
            prop.load(new FileInputStream("src/test/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
