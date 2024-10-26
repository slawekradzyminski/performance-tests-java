package com.awesome.testing.feeder;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
public class UserFeeder {

    private static final Faker FAKER = new Faker();
    private static final int MAX_NUMBER_OF_ATTEMPTS = 20;

    public static final Iterator<Map<String, Object>> USER_FEEDER = Stream.generate(() -> {
        Map<String, Object> userData;
        int attempts = 0;

        while (attempts < MAX_NUMBER_OF_ATTEMPTS) {
            userData = generateValues();

            if (checkValues(userData)) {
                return userData;
            } else {
                log.info("Attempt {} failed for generated data: {}", attempts + 1, userData);
                attempts++;
            }
        }

        throw new RuntimeException("Failed to generate valid user data after 20 attempts");
    }).iterator();

    private static boolean checkValues(Map<String, Object> userData) {
        return userData.values().stream()
                .allMatch(value -> value.toString().length() >= 4);
    }

    private static Map<String, Object> generateValues() {
        return Map.of(
                "firstName", FAKER.name().firstName(),
                "lastName", FAKER.name().lastName(),
                "username", FAKER.internet().username(),
                "password", FAKER.internet().password(),
                "email", FAKER.internet().emailAddress()
        );
    }


}
