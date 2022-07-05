package ru.geekbrains.java4.utils;

import ru.geekbrains.java4.Images;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class FileEncodingUtils {

    public static String INPUT_IMAGE_FILE_PATH = Images.POSITIVE.path;

    public static byte[] getFileContent() {

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