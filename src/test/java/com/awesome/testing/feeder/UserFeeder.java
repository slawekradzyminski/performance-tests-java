package com.awesome.testing.feeder;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
public class UserFeeder {

    private static final Faker FAKER = new Faker();
    private static final int MAX_NUMBER_OF_ATTEMPTS = 20;

    public static final Iterator<Map<String, Object>> USER_FEEDER = Stream.generate(UserFeeder::getMap).iterator();

    public static String generateFirstName() {
        return generateValue(() -> FAKER.name().firstName());
    }

    public static String generateLastName() {
        return generateValue(() -> FAKER.name().lastName());
    }

    public static String generateUsername() {
        return generateValue(() -> FAKER.internet().username());
    }

    public static String generatePassword() {
        return generateValue(() -> FAKER.internet().password());
    }

    public static String generateEmail() {
        return generateValue(() -> FAKER.internet().emailAddress());
    }

    private static String generateValue(Supplier<String> generator) {
        String value;
        int attempts = 0;

        do {
            value = generator.get();
            attempts++;
        } while (value.length() < 4 && attempts < MAX_NUMBER_OF_ATTEMPTS);

        if (value.length() < 4) {
            throw new RuntimeException("Failed to generate valid value after 20 attempts");
        }

        return value;
    }

    private static Map<String, Object> getMap() {
        return Map.of(
                "firstName", generateFirstName(),
                "lastName", generateLastName(),
                "username", generateUsername(),
                "password", generatePassword(),
                "email", generateEmail()
        );
    }
}
