package main.interfaces;

import main.InnerDto;
import main.InnerEntity;
import main.OuterDto;
import main.OuterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EntityMapper {
    @Mapping(source = "innerEntityList", target = "innerDtoList")
    OuterDto outerEntityToOuterDto(OuterEntity outerEntity);

    InnerDto innerEntityToInnerDto(InnerEntity innerEntity);

    List<InnerDto> innerEntitiesToInnerDtos(List<InnerEntity> innerEntities);
}