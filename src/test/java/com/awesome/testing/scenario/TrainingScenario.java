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

/**
 * REJESTRACJA = 60 RPM
 * LOGIN = 60 RPM
 * GET_ALL = 120 RPM
 * GET_SINGLE_USER = 30 RPM
 * EDIT = 20 RPM
 * DELETE = 20 RPM
 */
public class TrainingScenario {

    /**
     * scope 1 sesji:
     * Ilość rejestracja jest taka sama jak ilość logowań.
     * Ilość GET USERS jest 2 razy większa od ilości logowań
     * Ilość Get Single user jest 2 razy mniejsza od ilości logowań
     * Ilość Edycji i Delete jest 3 razy mniejsza od ilości logowań
     */
    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(4)
            .exec(LOGIN_REQUEST)
            .pause(1)
            .repeat(2).on(
                    exec(GET_USERS_REQUEST)
            )
            .randomSwitch().on(
                    percent(50).then(pause(2).exec(GET_SINGLE_USER_REQUEST))
            )
            .randomSwitch().on(
                    percent(33.3).then(pause(2).exec(EDIT_USER))
            )
            .randomSwitch().on(
                    percent(33.3).then(pause(2).exec(DELETE_USER_REQUEST))
            );

}
