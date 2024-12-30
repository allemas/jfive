package com.allemas.parser;

import com.allemas.InvalidJson;

import java.util.*;

public class JsonParser {

    public static Object parse(String inputString) throws InvalidJson {
        String input = inputString.trim();
        if (input.startsWith("{") && input.endsWith("}")) {
            return parseObj(input);
        } else if (input.startsWith("[") && input.endsWith("]")) {
            return parseArray(input);
        }
        throw new InvalidJson();
    }


    public static Object subArray(String array) {
        var begin = array.indexOf("[");
        var end = array.indexOf("]");


        System.out.println(array.substring(begin + 1, end));
        return  null;

    }


    public static Object parseObj(String inputString) throws InvalidJson {
        Map<String, Object> result = new HashMap<String, Object>();

        String content = inputString.trim().substring(1, inputString.length() - 1).trim();
        subArray(content);


        String[] pairs = content.split(",");


        for (String pair : pairs) {
            String[] splitedPair = pair.trim().split(":");


            if (splitedPair.length != 2) throw new InvalidJson();

            String key = splitedPair[0].trim().replace("\"", "");
            Object value = cleanupValue(splitedPair[1].trim());
            result.put(key, value);
        }

        return result;
    }

    public static List<Object> parseArray(String inputString) throws InvalidJson {
        List<Object> parsedArray = new ArrayList<>();
        String content = inputString.substring(1, inputString.length() - 1).trim();
        parsedArray.add(parseObj(content));

/**        String[] pairs = content.split("}");
 for (String pair : pairs) {

 parsedArray.add();
 }*/
        return parsedArray;
    }


    private static Object cleanupValue(String value) throws InvalidJson {

        if (value.startsWith("\"") && value.endsWith("\"")) value = value.substring(1, value.length() - 1);
        else if ("true".equals(value) || "false".equals(value)) return Boolean.parseBoolean(value);
        else if ("null".equals(value)) return null;
        else {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                try {
                    return Double.parseDouble(value);
                } catch (NumberFormatException e2) {
                    throw new InvalidJson("Error during parsing");
                }
            }

        }

        return value;


    }


}
