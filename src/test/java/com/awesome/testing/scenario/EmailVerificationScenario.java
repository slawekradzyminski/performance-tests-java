package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.awesome.testing.http.mailhog.GetMessages.checkMessagesCount;
import static io.gatling.javaapi.core.CoreDsl.*;

@Slf4j
public class EmailVerificationScenario {

    private static String SCENARIO_PREFIX = "";

    static {
        try {
            SCENARIO_PREFIX = Files.readString(Paths.get("prefix.txt")).trim();
            log.info("Loaded scenario prefix from file: {}", SCENARIO_PREFIX);
        } catch (IOException e) {
            log.warn("Failed to read prefix.txt. Using default '{}'", SCENARIO_PREFIX, e);
        }
    }

    public static ScenarioBuilder EMAIL_VERIFICATION_SCENARIO = scenario("Email verification scenario")
            .exec(checkMessagesCount(SCENARIO_PREFIX, 3));

}
