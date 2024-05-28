package com.awesome.testing.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmailDto {

    String message;
    String subject;
    String to;

}
