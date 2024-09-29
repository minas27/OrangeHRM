package core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JacksonHelper {
    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonHelper.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);
    }

    public static <T> List<T> deserializeJsonToList(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonHelper.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, new TypeReference<List<T>>() {});
    }
}
