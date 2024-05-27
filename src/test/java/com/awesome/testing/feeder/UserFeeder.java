package com.awesome.testing.feeder;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class UserFeeder {

    public static final Iterator<Map<String, Object>> CREDENTIALS_FEEDER =
            Stream.generate((Supplier<Map<String, Object>>) () -> Map.of(
                            "username", getRandomString(),
                            "password", getRandomString(),
                            "firstName", getRandomString(),
                            "lastName", getRandomString(),
                            "email", getRandomEmail()
                    )
            ).iterator();

    private static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    private static String getRandomEmail() {
        return getRandomString() + "@foo.com";
    }

}
