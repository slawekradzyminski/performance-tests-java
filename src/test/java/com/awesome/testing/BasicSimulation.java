package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.AdminScenario.ADMIN_SCENARIO;
import static com.awesome.testing.scenario.AwesomeTestingScenario.CUSTOMER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Tutaj mamy część wydajnościową czyli tutaj definiujemy ilu będzie poszczególnych użytkowników
 */
@SuppressWarnings("unused")
public class BasicSimulation extends Simulation {

    // 60 rpm = 1 rps
    private static final int DESIRED_RPM = 60;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int DESIRED_RPS = 1; // DESIRED_RPM / SECONDS_IN_MINUTE

    {
        setUp(
                CUSTOMER_SCENARIO.injectOpen(
                        rampUsersPerSec(0).to(DESIRED_RPS).during(Duration.ofMinutes(5)).randomized(), // ramp up
                        constantUsersPerSec(DESIRED_RPS).during(Duration.ofMinutes(10)).randomized(), // peak traffic
                        rampUsersPerSec(DESIRED_RPS).to(0).during(Duration.ofMinutes(5)).randomized() // ramp down
                ),
                ADMIN_SCENARIO.injectOpen(
                        rampUsersPerSec(0).to(DESIRED_RPS).during(Duration.ofMinutes(5)).randomized(), // ramp up
                        constantUsersPerSec(DESIRED_RPS).during(Duration.ofMinutes(10)).randomized(), // peak traffic
                        rampUsersPerSec(DESIRED_RPS).to(0).during(Duration.ofMinutes(5)).randomized() // ramp down
                )
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
