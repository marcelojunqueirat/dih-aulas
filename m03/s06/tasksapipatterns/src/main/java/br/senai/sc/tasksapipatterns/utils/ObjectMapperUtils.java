package br.senai.sc.tasksapipatterns.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Uso do Singleton para criar um objeto compartilhado por toda a
 * aplicação
 */

public class ObjectMapperUtils {

    private static ObjectMapperUtils objectMapperUtils;
    private final ObjectMapper objectMapper;

    private ObjectMapperUtils() {
        this.objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static ObjectMapperUtils newInstance() {
        if (objectMapperUtils == null) {
            objectMapperUtils = new ObjectMapperUtils();
        }
        return objectMapperUtils;
    }

    public String toJson(Object object) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(object);
    }

    /**
     * <T>: Essa parte da sintaxe indica que o método jsonToObject é genérico e que ele possui um
     * parâmetro de tipo genérico chamado T. Isso permite que o método aceite qualquer tipo como
     * argumento.
     * <p>
     * T: Após o <T>, o T é usado como o tipo de retorno do método. Isso significa que, quando o
     * método é chamado, ele retorna um valor do tipo especificado pelo tipo de T.
     */

    public <T> T toObject(String json, Class<T> classType) throws JsonProcessingException {
        return this.objectMapper.readValue(json, classType);
    }
}
