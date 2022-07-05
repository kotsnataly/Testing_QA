package controller;

import model.User;

import java.io.IOException;

public interface Xeon {
    float totalVaultAmount = 0;

    boolean makeTransaction(User userFrom, User userTo, float amount) throws IOException;

}
