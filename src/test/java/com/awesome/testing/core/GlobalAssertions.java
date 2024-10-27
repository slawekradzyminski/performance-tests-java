package com.awesome.testing.core;

import io.gatling.javaapi.core.Assertion;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;

public class GlobalAssertions {

    public static final List<Assertion> ASSERTIONS = List.of(
            details("Login request").responseTime().percentile(99d).lte(2000),
            forAll().responseTime().percentile(99d).lt(5000),
            forAll().failedRequests().percent().lte(98d),
            global().successfulRequests().percent().gte(98d)
    );

}
