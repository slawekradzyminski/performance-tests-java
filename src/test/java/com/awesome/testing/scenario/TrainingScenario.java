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

    public static ScenarioBuilder getTrainingScenario(String appendix) {
        return scenario("Training scenario " + appendix)
                .feed(CREDENTIALS_FEEDER)
                .exec(REGISTER_REQUEST)
                .pause(5)
                .exec(LOGIN_REQUEST)
                .pause(1)
                .repeat(2).on(exec(GET_USERS_REQUEST))
                .pause(2)
                .repeat(3).on(exec(GET_SINGLE_USER_REQUEST))
                .pause(4)
                .randomSwitch().on(
                        percent(50).then(exec(EDIT_USER_REQUEST))
                );
    }

}
