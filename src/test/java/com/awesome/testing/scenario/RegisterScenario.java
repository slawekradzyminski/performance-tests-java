package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.UserFeeder.USER_FEEDER;
import static com.awesome.testing.http.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class RegisterScenario {

    public static final ScenarioBuilder REGISTER_SCENARIO = scenario("Register scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST);

}
