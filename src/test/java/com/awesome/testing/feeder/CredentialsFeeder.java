package com.awesome.testing.feeder;

import net.datafaker.Faker;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CredentialsFeeder {

    private static final Faker FAKER = new Faker(new Locale("pl", "PL"));

    public static final Iterator<Map<String, Object>> CREDENTIALS_FEEDER =
            Stream.generate((Supplier<Map<String, Object>>) () -> Map.of(
                            "firstName", FAKER.name().firstName(),
                            "lastName", FAKER.name().lastName(),
                            "username", FAKER.internet().username(),
                            "password", FAKER.internet().password(),
                            "email", FAKER.internet().emailAddress()
                    )
            ).iterator();

}
