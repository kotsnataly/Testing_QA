package ru.geekbrains.java4.utils;

import ru.geekbrains.java4.Images;

import java.io.File;
import java.io.IOException;
import java.util.Random;


//в классе UpdateImageTests рандомно берет файл для загрузки.
public class FileEncodingUtilsWithRandPict {

    static int numberOfPictInImages;


    public static String INPUT_IMAGE_FILE_PATH;

    public static byte[] getFileContent() {
        Random randomInt = new Random();
        numberOfPictInImages = randomInt.nextInt(4);
        switch (numberOfPictInImages) {
            case 0:
                INPUT_IMAGE_FILE_PATH = Images.POSITIVE.path;
                break;
            case 1:
                INPUT_IMAGE_FILE_PATH = Images.SMALL.path;
                break;
            case 2:
                INPUT_IMAGE_FILE_PATH = Images.FROGS.path;
                break;
            case 3:
                INPUT_IMAGE_FILE_PATH = Images.SOMEJOKE.path;
                break;
        }

        File inputFile = new File(INPUT_IMAGE_FILE_PATH);

        byte[] fileContent = new byte[0];
        try {
            fileContent = org.apache.commons.io.FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
