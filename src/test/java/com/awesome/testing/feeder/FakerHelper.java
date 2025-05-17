package com.awesome.testing.feeder;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.function.Supplier;

public class FakerHelper {

    private static final int MAX_ATTEMPTS = 20;

    public static final Faker FAKER = new Faker();

    public static String generateValid(Supplier<String> supplier) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            String value = supplier.get();
            if (value != null && value.length() >= 4) {
                return value;
            }
        }

        return RandomStringUtils.secure().nextAlphabetic(10);
    }

}
