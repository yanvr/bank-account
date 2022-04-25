package com.letscode.bankaccount.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

public class GenerateAccountNumber {

    static final int QUANTITY_ACCOUNT_NUMBER = 6;

    private GenerateAccountNumber() {}

    public static String execute() {
        StringBuilder accountNumber = new StringBuilder();

        Random random = null;

        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < QUANTITY_ACCOUNT_NUMBER; i++) {
            accountNumber.append(Objects.requireNonNull(random).nextInt(10));
        }

        return accountNumber.toString();
    }
}
