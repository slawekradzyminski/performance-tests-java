package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.global;

public class FunctionalAssertions {

    public static final List<Assertion> ASSERTIONS = List.of(
            global().responseTime().max().lt(3000),
            global().successfulRequests().percent().is(100d)
    );

}
