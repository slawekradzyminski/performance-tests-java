package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.global;

public class AssertionsConfig {

    public static final List<Assertion> HARD_ASSERTIONS = List.of(
            global().responseTime().percentile(98).lt(2000),
            global().successfulRequests().percent().gte(98d)
    );

}
