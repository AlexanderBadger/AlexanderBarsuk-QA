package main.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class JsonObject {
    @JsonProperty("data")
    private FileData data;

    @Data
    public static class FileData {
        @JsonProperty("ProfileName")
        private String profileName;

        @JsonProperty("Person")
        private Person person;
    }

    @Data
    public static class Person {
        @JsonProperty("masterPersonId")
        private int masterPersonId;

        @JsonProperty("mpioip")
        private String mpioip;

        @JsonProperty("enp")
        private String enp;

        @JsonProperty("birthDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private Date birthDate;

        @JsonProperty("deathDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private Date deathDate;

        @JsonProperty("polId")
        private int polId;

        @JsonProperty("polCd")
        private int polCd;

        @JsonProperty("polSrcId")
        private int polSrcId;

        @JsonProperty("polName")
        private String polName;

        @JsonProperty("polSys")
        private String polSys;

        @JsonProperty("polVers")
        private String polVers;

        @JsonProperty("dn")
        private String dnId;

        @JsonProperty("dnp")
        private String dnpId;

        @JsonProperty("yearBirth")
        private int yearBirth;

        @JsonProperty("planYearDisp")
        private int planYearDisp;

        @JsonProperty("planYearCd")
        private Integer planYearCd;
    }
}