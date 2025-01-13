package main.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import main.interfaces.JsonMapper;
import main.models.JsonObject;
import main.models.RacursObject;

import java.io.File;
import java.io.IOException;

/**
 * Класс для чтения JSON файлов и преобразования их в объекты типа RacursObject.
 */
@Data
public class JsonReader {
    private final ObjectMapper objectMapper;

    /**
     * Конструктор класса JsonReader, инициализирующий ObjectMapper.
     */
    public JsonReader() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Читает JSON файл и преобразует его в объект RacursObject.
     *
     * @param filePath путь к файлу JSON
     * @return объект RacursObject, полученный из JSON файла
     * @throws IOException если возникает ошибка при чтении файла или преобразовании
     */
    public RacursObject readJsonFile(String filePath) throws IOException {
        // Читаем JSON файл в JsonObject
        JsonObject jsonObject = objectMapper.readValue(new File(filePath), JsonObject.class);
        // Преобразуем JsonObject в RacursObject
        return JsonMapper.INSTANCE.jsonObjectToRacursObject(jsonObject);
    }
}