package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.UserFeeder.USER_FEEDER;
import static com.awesome.testing.http.EditUser.EDIT_USER_REQUEST;
import static com.awesome.testing.http.GetSingleUser.GET_SINGLE_USER_REQUEST;
import static com.awesome.testing.http.GetUsers.GET_ALL_USERS_REQUEST;
import static com.awesome.testing.http.Login.LOGIN_REQUEST;
import static com.awesome.testing.http.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST)
            .exitHereIfFailed()
            .pause(Duration.ofSeconds(5))
            .exec(LOGIN_REQUEST)
            .pause(Duration.ofMillis(500))
            .exec(GET_ALL_USERS_REQUEST)
            .pause(Duration.ofSeconds(2))
            .exec(GET_SINGLE_USER_REQUEST)
            .pause(Duration.ofSeconds(2))
            .exec(EDIT_USER_REQUEST);

}
