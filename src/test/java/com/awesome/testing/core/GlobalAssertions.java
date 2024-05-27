package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.global;

public class GlobalAssertions {

    public static final List<Assertion> GLOBAL_ASSERTIONS = List.of(
            global().responseTime().percentile(99).lt(3000),
            global().successfulRequests().percent().gte(99d)
    );

}
