package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.core.HttpConfig.WS_HTTP_PROTOCOL;
import static com.awesome.testing.scenario.UserRegisterScenario.USER_REGISTER_SCENARIO;
import static com.awesome.testing.scenario.WebSocketScenario.WEB_SOCKET_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

@SuppressWarnings("unused")
public class WebSocketSimulation extends Simulation {

    {
        setUp(
                WEB_SOCKET_SCENARIO.injectOpen(
                        atOnceUsers(1)
                )
        )
                .protocols(WS_HTTP_PROTOCOL)
                .assertions(ASSERTIONS);
    }
}
