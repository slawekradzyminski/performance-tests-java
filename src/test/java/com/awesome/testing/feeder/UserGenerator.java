package com.awesome.testing.feeder;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class UserGenerator {

    private static final Faker FAKER = new Faker();
    private static final int MAX_ATTEMPTS = 20;

    private static String generateValid(FakerSupplier supplier) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            String value = supplier.get();
            if (value != null && value.length() >= 4) {
                return value;
            }
        }

        return RandomStringUtils.secure().nextAlphabetic(10);
    }

    interface FakerSupplier {
        String get();
    }

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
