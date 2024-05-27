package com.awesome.testing.feeder;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.awesome.testing.util.Random.getRandomEmail;
import static com.awesome.testing.util.Random.getRandomString;

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

}
