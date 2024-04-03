package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;
import java.util.List;

import static com.awesome.testing.config.HttpConfig.HTTP_PROTOCOL;
import static com.awesome.testing.journey.UserJourney.ONE_SESSION_USER_JOURNEY;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    private static final List<Assertion> ASSERTIONS = List.of(
            global().responseTime().max().lt(3000),
            global().successfulRequests().percent().is(100d)
    );

    {

        setUp(ONE_SESSION_USER_JOURNEY
                .injectClosed(
                        constantConcurrentUsers(10).during(Duration.ofSeconds(60)),
                        rampConcurrentUsers(10).to(30).during(Duration.ofSeconds(60))
                )
                .protocols(HTTP_PROTOCOL))
                .assertions(ASSERTIONS);
    }
}
