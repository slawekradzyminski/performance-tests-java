package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;
import lombok.extern.slf4j.Slf4j;

import static com.awesome.testing.request.DeleteUser.deleteUser;
import static com.awesome.testing.request.GetUsers.GET_USERS_FOR_CLEANUP_SIMULATION;
import static com.awesome.testing.request.Login.ADMIN_LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Represents a single user journey
 */
@Slf4j
public class CleanupScenario {

    @SuppressWarnings("ConstantConditions")
    public static final ScenarioBuilder CLEANUP_SCENARIO = scenario("Training scenario")
            .exec(ADMIN_LOGIN_REQUEST)
            .pause(1)
            .exec(GET_USERS_FOR_CLEANUP_SIMULATION)
            .foreach("#{usernames}", "username").on(
                    doIf(session -> !session.get("username").equals("admin"))
                            .then(
                                    exec(
                                            deleteUser("#{username}")
                                    )
                            )
            );

}
