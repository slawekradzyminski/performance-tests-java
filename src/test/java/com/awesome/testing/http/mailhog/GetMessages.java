package com.awesome.testing.http.mailhog;

import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

@Slf4j
public class GetMessages {

    private static final String JSON_PATH_RETURNING_ALL_EMAILS = "$.items[*].Content.Headers.Subject";

    public static HttpRequestActionBuilder checkMessagesCount(String prefix, int count) {
        return http("Get all messages")
                .get("/api/v2/messages?limit=1000") // there is pagination on this endpoint so we want to make sure to return all emails from our tests
                .check(
                        status().is(200),
                        jsonPath(JSON_PATH_RETURNING_ALL_EMAILS).findAll()
                                .transform(subjects -> countTheEmailsStartingFromGivenPrefix(prefix, subjects))
                                .is((long) count)
                );
    }

    private static long countTheEmailsStartingFromGivenPrefix(String prefix, List<String> subjects) {
        return subjects.stream()
                .filter(subject -> subject.contains(prefix))
                .count();
    }
}
