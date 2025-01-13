package main.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.interfaces.JsonMapper;
import main.models.DataObject;
import main.models.JsonObject;
import main.models.RacursObject;

import java.io.File;
import java.io.IOException;

import static main.Constants.LogMessages.DATA_OBJECT_SUCCESS_CREATION_LOG;
import static main.Constants.LogMessages.JSON_FILE_SUCCESS_READING_LOG;
import static main.Constants.LogMessages.JSON_OBJECT_TO_RACURS_OBJECT_SUCCESSFUL_TRANSFORM_LOG;
import static main.Constants.LogMessages.OBJECT_MAPPER_SUCCESS_INITIALIZATION_LOG;
import static main.Constants.LogMessages.READ_JSON_FILE_LOG;
import static main.Constants.LogMessages.TRANSFORMED_OBJECT_LOG;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
public class RacursObjectTestSteps {

    private ObjectMapper objectMapper;
    private JsonObject jsonObject;
    private RacursObject racursObject;

    @Step("Инициализация ObjectMapper")
    public void initializeObjectMapper() {
        objectMapper = new ObjectMapper();
        log.info(OBJECT_MAPPER_SUCCESS_INITIALIZATION_LOG);
    }

    @Step("Чтение JSON файла и преобразование его в JsonObject")
    public void readJsonFile(String filePath) throws IOException {
        jsonObject = objectMapper.readValue(new File(filePath), JsonObject.class);
        log.info(String.format(JSON_FILE_SUCCESS_READING_LOG, filePath));
        log.info(READ_JSON_FILE_LOG + jsonObject);
    }

    @Step("Преобразование JsonObject в RacursObject")
    public void convertToRacursObject() {
        racursObject = JsonMapper.INSTANCE.jsonObjectToRacursObject(jsonObject);
        log.info(JSON_OBJECT_TO_RACURS_OBJECT_SUCCESSFUL_TRANSFORM_LOG);
        log.info(TRANSFORMED_OBJECT_LOG + racursObject);
    }

    @Step("Проверка значений между JsonObject и RacursObject")
    public void verifyValues() {
        assertEquals(jsonObject.getData().getPerson().getMasterPersonId(), racursObject.getMasterPersonId());
        assertEquals(jsonObject.getData().getPerson().getMpioip(), racursObject.getMpioip());
        assertEquals(jsonObject.getData().getPerson().getEnp(), racursObject.getEnp());
        assertEquals(jsonObject.getData().getPerson().getBirthDate(), racursObject.getBirthDate());
        assertEquals(jsonObject.getData().getPerson().getDeathDate(), racursObject.getDeathDate());
        assertEquals(jsonObject.getData().getPerson().getPolId(), racursObject.getPolId());
        assertEquals(jsonObject.getData().getPerson().getPolCd(), racursObject.getPolCd());
        assertEquals(jsonObject.getData().getPerson().getPolSrcId(), racursObject.getPolSrcId());
        assertEquals(jsonObject.getData().getPerson().getPolName(), racursObject.getPolName());
        assertEquals(jsonObject.getData().getPerson().getPolSys(), racursObject.getPolSys());
        assertEquals(jsonObject.getData().getPerson().getPolVers(), racursObject.getPolVers());
        assertEquals(jsonObject.getData().getPerson().getDnId(), racursObject.getDnId());
        assertEquals(jsonObject.getData().getPerson().getDnpId(), racursObject.getDnpId());
        assertEquals(jsonObject.getData().getPerson().getYearBirth(), racursObject.getYearBirth());
        assertEquals(jsonObject.getData().getPerson().getPlanYearDisp(), racursObject.getPlanYearDisp());
        assertEquals(jsonObject.getData().getPerson().getPlanYearCd(), racursObject.getPlanYearCd());
    }

    @Step("Создание DataObject из RacursObject и ProfileName.")
    public DataObject createDataObject() {
        JsonObject.FileData fileData = jsonObject.getData();
        String profileName = fileData.getProfileName();
        DataObject dataObject = new DataObject();
        dataObject.setProfileName(profileName);
        dataObject.setRacursObject(racursObject);
        log.info(String.format(DATA_OBJECT_SUCCESS_CREATION_LOG, profileName));
        return dataObject;
    }
}