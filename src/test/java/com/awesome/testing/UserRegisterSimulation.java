package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.UserRegisterScenario.USER_REGISTER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

@SuppressWarnings("unused")
public class UserRegisterSimulation extends Simulation {

    {
        setUp(
                USER_REGISTER_SCENARIO.injectOpen(
                        atOnceUsers(50)
                )
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
