package com.awesome.testing.feeder;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static com.awesome.testing.util.RandomUtil.randomString;

public class CredentialsFeeder {

    private static final String GATLING = "gatling";

    public static final Iterator<Map<String, Object>> CREDENTIALS_FEEDER =
            Stream.generate(() -> Map.<String, Object>of(
                    "firstName", GATLING + randomString(8),
                    "lastName", GATLING + randomString(8),
                    "username", GATLING + randomString(8),
                    "password", GATLING + randomString(8),
                    "email", GATLING + randomString(8) + "@gatling.com"
            ))
                    .iterator();

}
