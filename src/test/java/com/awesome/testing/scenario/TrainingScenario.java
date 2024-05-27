package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.CredentialsFeeder.CREDENTIALS_FEEDER;
import static com.awesome.testing.request.GetUsers.GET_ALL_USERS_REQUEST;
import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static com.awesome.testing.request.Register.REGISTER_REQUEST;
import static com.awesome.testing.request.edit.EditUser.EDIT_USER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(5)
            .exec(LOGIN_REQUEST)
            .pause(5)
            .repeat(2).on(
                    exec(GET_ALL_USERS_REQUEST)
            )
            .randomSwitch().on(
                    percent(50.0).then(exec(GET_ALL_USERS_REQUEST))
            )
            .pause(5)
            .randomSwitch().on(
                    percent(50.0).then(exec(EDIT_USER_REQUEST))
            );

}
