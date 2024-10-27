package com.awesome.testing.scenario;

import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.http.HttpRequestActionBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.UserFeeder.USER_FEEDER;
import static com.awesome.testing.http.DeleteUser.DELETE_USER_REQUEST;
import static com.awesome.testing.http.EditUser.EDIT_USER_REQUEST;
import static com.awesome.testing.http.GetSingleUser.GET_SINGLE_USER_REQUEST;
import static com.awesome.testing.http.GetUsers.GET_ALL_USERS_REQUEST;
import static com.awesome.testing.http.Login.LOGIN_REQUEST;
import static com.awesome.testing.http.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST) // 60 rpm - request wobec którego robiliśmy proporcje
            .exitHereIfFailed()
            .pause(Duration.ofSeconds(5))
            .exec(LOGIN_REQUEST)
            .pause(Duration.ofMillis(500))
            .repeat(2).on(exec(GET_ALL_USERS_REQUEST))
            .pause(Duration.ofSeconds(2))
            .randomSwitch().on(runWithProbability(50, GET_SINGLE_USER_REQUEST))
            .pause(Duration.ofSeconds(2))
            .randomSwitch().on(runWithProbability(25, EDIT_USER_REQUEST))
            .pause(Duration.ofSeconds(1), Duration.ofSeconds(2))
            .randomSwitch().on(runWithProbability(25, DELETE_USER_REQUEST));

    private static Choice.WithWeight runWithProbability(int percent, HttpRequestActionBuilder getSingleUserRequest) {
        return percent(percent).then(exec(getSingleUserRequest));
    }
}
