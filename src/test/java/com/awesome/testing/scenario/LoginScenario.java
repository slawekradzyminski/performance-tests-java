package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder.Batchable;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.GetUsers.GET_USERS_REQUEST;
import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class LoginScenario {

    public static final Batchable<String> USERS_FEEDER = csv("data/UsersCredentials.csv").circular();

    public static final ScenarioBuilder LOGIN_SCENARIO = scenario("Login scenario")
            .feed(USERS_FEEDER)
            .exec(LOGIN_REQUEST)
            .pause(1)
            .exec(GET_USERS_REQUEST);
}
