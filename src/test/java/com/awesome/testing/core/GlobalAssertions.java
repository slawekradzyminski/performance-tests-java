package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.global;

public class GlobalAssertions {

    public static final List<Assertion> ASSERTIONS = List.of(
            global().responseTime().max().lt(5000),
            global().successfulRequests().percent().is(100d)
    );

}
