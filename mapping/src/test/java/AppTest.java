import main.steps.EntityMapperSteps;
import main.steps.RacursObjectTestSteps;
import main.models.DataObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static main.Constants.StringConstants.DATA_SOURCE;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
    private final EntityMapperSteps entityMapperSteps = new EntityMapperSteps();
    private final RacursObjectTestSteps racursObjectTestSteps = new RacursObjectTestSteps();

    @Test
    @DisplayName("Тест 1. Проверка чтения JSON и преобразования в объект Racurs.")
    public void testJsonReaderAndMapper() throws IOException {
        // Шаг 1: Инициализация ObjectMapper
        racursObjectTestSteps.initializeObjectMapper();
        // Шаг 2: Чтение JSON файла
        racursObjectTestSteps.readJsonFile(DATA_SOURCE);
        // Шаг 3: Преобразование в RacursObject
        racursObjectTestSteps.convertToRacursObject();
        // Шаг 4: Проверка значений
        racursObjectTestSteps.verifyValues();
    }

    @Test
    @DisplayName("Тест 2. Проверка создания DataObject.")
    public void testCreateDataObject() throws IOException {
        // Шаг 1: Инициализация ObjectMapper
        racursObjectTestSteps.initializeObjectMapper();
        // Шаг 2: Чтение JSON файла
        racursObjectTestSteps.readJsonFile(DATA_SOURCE);
        // Шаг 3: Преобразование в RacursObject
        racursObjectTestSteps.convertToRacursObject();
        // Шаг 4: Создание DataObject
        DataObject dataObject = racursObjectTestSteps.createDataObject();
        // Проверка, что DataObject не null
        assertNotNull(dataObject);
    }

    @Test
    @DisplayName("Тест 3. Проверка инициализации класса OuterEntity и маппинга с помощью"
            + "класса EntityMapper(MupStruct) в класс OuterDto")
    void testOuterEntityToOuterDTO() {
        // Шаг 1: Создаем внутренние сущности и оборачиваем их в OuterEntity
        entityMapperSteps.createInnerEntities();
        // Шаг 2: Маппим созданный OuterEntity в OuterDto
        entityMapperSteps.mapOuterEntityToOuterDto();
        // Шаг 3: Проверяем корректность маппинга, валидируя значения в OuterDto
        entityMapperSteps.validateOuterDto();
    }
}