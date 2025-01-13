package main.Constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class LogMessages {
    public static final String OBJECT_MAPPER_SUCCESS_INITIALIZATION_LOG = "Объект ObjectMapper успешно "
            + "инициализирован.";
    public static final String JSON_FILE_SUCCESS_READING_LOG = "JSON файл успешно прочитан из: %s";
    public static final String JSON_OBJECT_TO_RACURS_OBJECT_SUCCESSFUL_TRANSFORM_LOG = "JsonObject успешно преобразован"
            + " в RacursObject.";
    public static final String DATA_OBJECT_SUCCESS_CREATION_LOG = "DataObject успешно создан с profileName: %s";
    public static final String CREATE_INNER_ENTITY_LOG = "Создан %s с полем: %s";
    public static final String CREATE_OUTER_ENTITY_LOG = "Создан OuterEntity с %s InnerEntities";
    public static final String MAPPING_COMPLETED_LOG = "Маппинг OuterEntity в OuterDto завершен";
    public static final String OUTER_DTO_NOT_NULL_LOG = "OuterDTO не равен null";
    public static final String INNER_DTO_LIST_IN_OUTER_DTO_NOT_NULL_LOG = "Список InnerDTO в OuterDto не равен null";
    public static final String INNER_DTO_LIST_VALUE_MEETS_EXPECTATION_LOG = "Размер списка InnerDto "
            + "соответствует ожиданиям: %s";
    public static final String FIRST_VALUE_INNER_DTO_FIELD_LOG = "Первое значение поля InnerDto: %s";
    public static final String SECOND_VALUE_INNER_DTO_FIELD_LOG = "Второе значение поля InnerDto: %s";
    public static final String READ_JSON_FILE_LOG = "Прочитанный JSON: ";
    public static final String TRANSFORMED_OBJECT_LOG = "Преобразованный объект: ";
}