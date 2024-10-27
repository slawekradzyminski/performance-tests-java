package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import java.util.List;

import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.RegisterScenario.REGISTER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

@SuppressWarnings("unused")
public class RegisterSimulation extends Simulation {

    {
        setUp(
                REGISTER_SCENARIO.injectOpen(
                        atOnceUsers(2000)
                )
        )
                .protocols(HTTP_CONFIG)
                .assertions(List.of(
                        global().successfulRequests().percent().is(100d)
                ));
    }
}
