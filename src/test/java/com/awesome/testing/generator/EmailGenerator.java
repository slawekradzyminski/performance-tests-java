package com.awesome.testing.generator;

import com.awesome.testing.dto.EmailDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailGenerator {

    private static final Faker FAKER = new Faker(new Locale("pl_PL"));

    public static EmailDto getRandomEmailTo(String to) {
        return EmailDto.builder()
                .subject(FAKER.lorem().sentence())
                .message(FAKER.lorem().sentence(10))
                .to(to)
                .build();
    }

}
