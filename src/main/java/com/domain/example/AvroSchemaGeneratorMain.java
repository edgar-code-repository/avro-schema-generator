package com.domain.example;

import com.domain.example.dto.AvroMessageDTO;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

public class AvroSchemaGeneratorMain {

    public static void main(String[] args) throws Exception {

        ReflectData reflectData = ReflectData.get();

        Schema schema = reflectData.getSchema(AvroMessageDTO.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(schema.toString());

        PrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        String strJson = mapper.writer(prettyPrinter).writeValueAsString(json);
        System.out.println(strJson);


    }

}
