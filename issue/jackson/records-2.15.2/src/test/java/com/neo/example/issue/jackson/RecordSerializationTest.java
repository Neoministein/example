package com.neo.example.issue.jackson;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecordSerializationTest {

    record DataObject (
            Integer a,
            Integer b) {}

    @Test
    void testRecordSerialization() throws Exception {
        final ObjectMapper jsonMapper = new JsonMapper();
        final String r = jsonMapper.writeValueAsString(new DataObject(2, 3));
        jsonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        jsonMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        Assertions.assertEquals("{\"a\":2,\"b\":3}", r); // we get {}
    }

    @Test
    void testRecordDeserialization() throws Exception {
        final ObjectMapper mapper = new JsonMapper();

        DataObject expected = new DataObject(2, 3);

        final String r = mapper.writeValueAsString(expected);

        //mapper.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);


        DataObject result = mapper.readValue(r, DataObject.class);

        Assertions.assertEquals(expected, result); // we get {}
    }
}
