package main.models;

import lombok.Data;

import java.util.Date;

@Data
public class RacursObject {
    private int masterPersonId;
    private String mpioip;
    private String enp;
    private Date birthDate;
    private Date deathDate;
    private int polId;
    private int polCd;
    private int polSrcId;
    private String polName;
    private String polSys;
    private String polVers;
    private String dnId;
    private String dnpId;
    private int yearBirth;
    private int planYearDisp;
    private int planYearCd;
}