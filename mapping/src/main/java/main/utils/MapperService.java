package main.utils;

import lombok.Data;
import main.interfaces.JsonMapper;
import main.models.JsonObject;
import main.models.RacursObject;

/**
 * Сервис для преобразования объектов JsonObject в объекты RacursObject.
 */
@Data
public class MapperService {
    private final JsonMapper mapper;

    /**
     * Преобразует объект JsonObject в объект RacursObject.
     *
     * @param jsonObject объект JsonObject, который нужно преобразовать
     * @return объект RacursObject, полученный из переданного JsonObject
     * @throws IllegalArgumentException если переданный jsonObject равен null
     */
    public RacursObject mapJsonObjectToRacurs(JsonObject jsonObject) {
        if (jsonObject == null) {
            throw new IllegalArgumentException("JsonObject cannot be null");
        }
        return mapper.jsonObjectToRacursObject(jsonObject);
    }
}