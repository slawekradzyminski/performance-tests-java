package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.CredentialsFeeder.CREDENTIALS_FEEDER;
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
            .exec(REGISTER_REQUEST)
            .pause(5)
            .exec(LOGIN_REQUEST)
            .pause(1) 
            .exec(GET_USERS_REQUEST)
            .pause(2)
            .exec(GET_SINGLE_USER_REQUEST);

}
