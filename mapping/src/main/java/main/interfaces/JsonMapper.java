package main.interfaces;

import main.models.JsonObject;
import main.models.RacursObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonMapper {
    JsonMapper INSTANCE = Mappers.getMapper(JsonMapper.class);
    @Mapping(source = "data.person.masterPersonId", target = "masterPersonId")
    @Mapping(source = "data.person.mpioip", target = "mpioip")
    @Mapping(source = "data.person.enp", target = "enp")
    @Mapping(source = "data.person.birthDate", target = "birthDate")
    @Mapping(source = "data.person.deathDate", target = "deathDate")
    @Mapping(source = "data.person.polId", target = "polId")
    @Mapping(source = "data.person.polCd", target = "polCd")
    @Mapping(source = "data.person.polSrcId", target = "polSrcId")
    @Mapping(source = "data.person.polName", target = "polName")
    @Mapping(source = "data.person.polSys", target = "polSys")
    @Mapping(source = "data.person.polVers", target = "polVers")
    @Mapping(source = "data.person.dnId", target = "dnId")
    @Mapping(source = "data.person.dnpId", target = "dnpId")
    @Mapping(source = "data.person.yearBirth", target = "yearBirth")
    @Mapping(source = "data.person.planYearDisp", target = "planYearDisp")
    @Mapping(source = "data.person.planYearCd", target = "planYearCd")
    RacursObject jsonObjectToRacursObject(JsonObject jsonObject);
}