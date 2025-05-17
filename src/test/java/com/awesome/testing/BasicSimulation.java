package com.awesome.testing;

import io.gatling.javaapi.core.*;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.AwesomeTestingScenario.CUSTOMER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Tutaj mamy część wydajnościową czyli tutaj definiujemy ilu będzie poszczególnych użytkowników
 */
public class BasicSimulation extends Simulation {

    {
        setUp(
                CUSTOMER_SCENARIO.injectOpen(atOnceUsers(6))
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
