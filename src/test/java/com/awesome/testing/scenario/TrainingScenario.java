package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.CredentialsFeeder.CREDENTIALS_FEEDER;
import static com.awesome.testing.request.EditUser.EDIT_USER_REQUEST;
import static com.awesome.testing.request.GetSingleUser.GET_SINGLE_USER_REQUEST;
import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static com.awesome.testing.request.Register.REGISTER_REQUEST;
import static com.awesome.testing.request.GetUsers.GET_USERS_REQUEST; // Added import for GET_USERS_REQUEST
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Represents a single user journey
 */
public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(REGISTER_REQUEST) //
            .pause(5)
            .exec(LOGIN_REQUEST) // 120 rpm / 2 rps
            .pause(1) 
            .repeat(2).on(exec(GET_USERS_REQUEST)) // 240 rpm / 4 rps
            .pause(2)
            .repeat(3).on(exec(GET_SINGLE_USER_REQUEST)) // 360 rpm / 6 rps
            .pause(4)
            .randomSwitch().on(
                    percent(50).then(exec(EDIT_USER_REQUEST)) // 60 rpm / 1 rps
            );

}
