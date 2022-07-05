package ru.geekbrains.java4;

public enum Images {
    POSITIVE("src/test/resources/avatar.jpg"),
    TOO_BIG("src/test/resources/Frontal.jpg"),
    ZERO_SIZE("src/test/resources/zero_size.jpg"),
    SMALL("src/test/resources/Flowers.jpg"),
    SOMEJOKE("src/test/resources/somejoke.png"),
    FROGS("src/test/resources/frogs.jpeg");

    public final String path;

    Images(String path) {
        this.path = path;
    }
}
