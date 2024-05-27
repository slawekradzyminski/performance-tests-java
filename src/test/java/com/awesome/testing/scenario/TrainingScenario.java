package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.UserFeeder.CREDENTIALS_FEEDER;
import static com.awesome.testing.request.DeleteUser.DELETE_USER_REQUEST;
import static com.awesome.testing.request.EditUser.EDIT_USER;
import static com.awesome.testing.request.GetSingleUser.GET_SINGLE_USER_REQUEST;
import static com.awesome.testing.request.GetUsers.GET_USERS_REQUEST;
import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static com.awesome.testing.request.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    /**
     * scope 1 sesji
     */
    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(4)
            .exec(LOGIN_REQUEST)
            .pause(1)
            .exec(GET_USERS_REQUEST)
            .pause(2)
            .exec(GET_SINGLE_USER_REQUEST)
            .pause(2)
            .exec(EDIT_USER)
            .pause(2)
            .exec(DELETE_USER_REQUEST);

}
