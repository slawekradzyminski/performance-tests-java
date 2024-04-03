package com.awesome.testing.feeder;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CredentialsFeeder {

    public static Iterator<Map<String, Object>> CREDENTIALS_FEEDER =
            Stream.generate((Supplier<Map<String, Object>>) () -> Map.of(
                    "email", getRandomString() + "@cantest.it",
                    "username", getRandomString(),
                    "password", getRandomString(),
                    "firstName", getRandomString(),
                    "lastName", getRandomString()
                    )
            ).iterator();

    private static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(20);
    }

}
