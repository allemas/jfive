package json;

import com.allemas.InvalidJson;
import com.allemas.JFive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class jFiveParser {




    @Test
    public void simpleKeyValueJson() throws InvalidJson {
        var json2 = """
                   {
                      "name": "John",
                    }
                """;

        Object o = JFive.fromString(json2);
        Assertions.assertEquals("{name=John}", o.toString());
    }

    @Test
    public void simpleKeyValueAndStringifyJson() throws InvalidJson {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"isStudent\":false}";
        Object o = JFive.fromString(jsonString);
        Assertions.assertEquals("{name=John, age=30, isStudent=false}", o.toString());
    }

    @Test
    public void parseSimpleString() throws InvalidJson {
        var json = """
                    [{
                       "name": "John",
                       "age": 30,
                       "isStudent": false,
                       "skills": ["Java", "Scala"],
                       "address": {
                         "street": "123 Main St",
                         "city": "Anytown"
                       }
                     }
                     ]
                """;
        Object o = JFive.fromString(json);
    }



}
