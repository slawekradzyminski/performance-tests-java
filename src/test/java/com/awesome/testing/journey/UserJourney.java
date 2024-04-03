package com.awesome.testing.journey;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.CredentialsFeeder.CREDENTIALS_FEEDER;
import static com.awesome.testing.http.LoginRequest.LOGIN_REQUEST;
import static com.awesome.testing.http.RegisterRequest.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class UserJourney {

    public static ScenarioBuilder ONE_SESSION_USER_JOURNEY =
            scenario("Training scenario")
                    .feed(CREDENTIALS_FEEDER)
                    .exec(REGISTER_REQUEST)
                    .pause(6)
                    .exec(LOGIN_REQUEST);

}
