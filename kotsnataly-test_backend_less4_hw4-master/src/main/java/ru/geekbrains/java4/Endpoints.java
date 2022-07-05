package ru.geekbrains.java4;

public class Endpoints {
    public static final String GET_ACCOUNT_REQUEST = "/account/{username}";
    public static final String POST_IMAGE_REQUEST = "/image";
    public static final String GET_IMAGE_REQUEST = "/image/";
    public static final String DELETE_IMAGE_REQUEST = "/account/{username}/image/{deleteHash}";
    public static final String UPDATE_IMAGE_REQUEST = "image/{{imageHash}}";
    public static final String FAVORITE_IMAGE_REQUEST = "/image/{{imageHash}}/favorite";

}
