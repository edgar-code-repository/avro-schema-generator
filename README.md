AVRO SCHEMA GENERATOR
--------------------------------------------------------------

An Avro schema is generated from a Java class.

This is achieved by using Jackson and Avro libraries.

Because I'm a lazy programmer and don't enjoy writing schemas!

![Dev](screenshots/garfield.jpg)

--------------------------------------------------------------

**Dependencies in build.gradle file:**

```
    dependencies {
        compile "org.apache.avro:avro:1.8.2"
    
        compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.8.8'
        compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.8.8'
        compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.8.8'
    
    }

```
--------------------------------------------------------------

**Class AvroMessageDTO:**

```

    public class AvroMessageDTO {
    
        private Integer code;
    
        private String message;
    
        private String description;
    
        ... getters
        
        ... and setters
    }

```

--------------------------------------------------------------

**Code that generates the Avro schema from class AvroMessageDTO:**

```
    ReflectData reflectData = ReflectData.get();

    Schema schema = reflectData.getSchema(AvroMessageDTO.class);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode json = mapper.readTree(schema.toString());

    PrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
    String strJson = mapper.writer(prettyPrinter).writeValueAsString(json);
    System.out.println(strJson);
```

--------------------------------------------------------------

**This is the Avro schema generated:**

```
    {
      "type" : "record",
      "name" : "AvroMessageDTO",
      "namespace" : "com.domain.example.dto",
      "fields" : [ 
            { "name" : "code", "type" : "int" }, 
            { "name" : "message", "type" : "string" }, 
            { "name" : "description", "type" : "string" } 
      ]
    }
```


--------------------------------------------------------------

