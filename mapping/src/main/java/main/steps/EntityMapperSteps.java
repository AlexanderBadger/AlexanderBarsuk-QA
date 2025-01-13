package main.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.InnerEntity;
import main.OuterDto;
import main.OuterEntity;
import main.interfaces.EntityMapper;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

import static main.Constants.LogMessages.CREATE_INNER_ENTITY_LOG;
import static main.Constants.LogMessages.CREATE_OUTER_ENTITY_LOG;
import static main.Constants.LogMessages.FIRST_VALUE_INNER_DTO_FIELD_LOG;
import static main.Constants.LogMessages.INNER_DTO_LIST_IN_OUTER_DTO_NOT_NULL_LOG;
import static main.Constants.LogMessages.INNER_DTO_LIST_VALUE_MEETS_EXPECTATION_LOG;
import static main.Constants.LogMessages.MAPPING_COMPLETED_LOG;
import static main.Constants.LogMessages.OUTER_DTO_NOT_NULL_LOG;
import static main.Constants.LogMessages.SECOND_VALUE_INNER_DTO_FIELD_LOG;
import static main.Constants.StringConstants.APPLE;
import static main.Constants.StringConstants.BANANA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j
public class EntityMapperSteps {
    private final EntityMapper mapper;
    private OuterEntity outerEntity;
    private OuterDto outerDto;

    public EntityMapperSteps() {
        this.mapper = Mappers.getMapper(EntityMapper.class);
    }

    @Step("Создание внутренних сущностей")
    public void createInnerEntities() {
        InnerEntity innerEntity1 = new InnerEntity();
        innerEntity1.setInnerField(BANANA);
        log.info(String.format(CREATE_INNER_ENTITY_LOG, innerEntity1, innerEntity1.getInnerField()));
        InnerEntity innerEntity2 = new InnerEntity();
        innerEntity2.setInnerField(APPLE);
        log.info(String.format(CREATE_INNER_ENTITY_LOG, innerEntity2, innerEntity2.getInnerField()));
        outerEntity = new OuterEntity();
        outerEntity.setInnerEntityList(Arrays.asList(innerEntity1, innerEntity2));
        log.info(String.format(CREATE_OUTER_ENTITY_LOG, outerEntity.getInnerEntityList().size()));
    }

    @Step("Маппинг OuterEntity в OuterDto")
    public void mapOuterEntityToOuterDto() {
        outerDto = mapper.outerEntityToOuterDto(outerEntity);
        log.info(MAPPING_COMPLETED_LOG);
    }

    @Step("Валидация OuterDTO")
    public void validateOuterDto() {
        assertNotNull(outerDto);
        log.info(OUTER_DTO_NOT_NULL_LOG);
        assertNotNull(outerDto.getInnerDtoList());
        log.info(INNER_DTO_LIST_IN_OUTER_DTO_NOT_NULL_LOG);
        assertEquals(2, outerDto.getInnerDtoList().size());
        log.info(String.format(INNER_DTO_LIST_VALUE_MEETS_EXPECTATION_LOG, outerDto.getInnerDtoList().size()));
        assertEquals(BANANA, outerDto.getInnerDtoList().get(0).getInnerField());
        log.info(String.format(FIRST_VALUE_INNER_DTO_FIELD_LOG, outerDto.getInnerDtoList().get(0).getInnerField()));
        assertEquals(APPLE, outerDto.getInnerDtoList().get(1).getInnerField());
        log.info(String.format(SECOND_VALUE_INNER_DTO_FIELD_LOG, outerDto.getInnerDtoList().get(1).getInnerField()));
    }
}