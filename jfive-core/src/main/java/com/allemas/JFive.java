package com.allemas;

import com.allemas.parser.JsonParser;

public class JFive {

    public static Object fromString(String json) throws InvalidJson {
        if (json == null || json.trim().isEmpty()) {
            throw new InvalidJson("JSON string cannot be null or empty");
        }

        return JsonParser.parse(json);
    }
}
