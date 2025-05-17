package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.global;

public class GlobalAssertions {

    public static final List<Assertion> ASSERTIONS = List.of(
            global().responseTime().percentile(99).lt(2000),
            global().successfulRequests().percent().gt(95.0)
    );

}
