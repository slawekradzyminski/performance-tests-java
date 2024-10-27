package com.awesome.testing.core;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

}
