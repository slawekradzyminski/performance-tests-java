package com.awesome.testing.feeder;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static com.awesome.testing.feeder.FakerHelper.FAKER;
import static com.awesome.testing.feeder.FakerHelper.generateValid;

@Slf4j
public class UserGenerator {

    private static Map<String, Object> generateUserData() {
        Map<String, Object> userDetails = Map.of(
                "username", generateValid(() -> FAKER.internet().username()),
                "password", FAKER.internet().password(),
                "email", FAKER.internet().emailAddress(),
                "firstName", generateValid(() -> FAKER.name().firstName()),
                "lastName", generateValid(() -> FAKER.name().lastName())
        );
        log.info("Generated user {}", userDetails);
        return userDetails;
    }

    public static final Iterator<Map<String, Object>> USER_FEEDER =
            Stream.generate(UserGenerator::generateUserData).iterator();
}
