package src.Task_7.Task_7_tableModel;

import java.util.Date;

import static src.Task_7.Task_7_tableModel.Constants.DOMAIN_ID;

public class Domain {
    public final int domainId;
    private String code;
    private String schema;
    private String urn;
    private String name;
    private boolean entity = false;
    private boolean system = true;
    private final Date creationDate;
    private Account creatorId;
    private String description;
    private int groupId;
    private int dataGroupId;

    public Domain(String schema) {
        this.domainId = DOMAIN_ID;
        this.schema = schema;
        this.creationDate = Constants.CREATION_DATE;
    }

    public int getDomainId(int domainId) {
        return domainId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEntity() {
        return entity;
    }

    public void setEntity(boolean entity) {
        this.entity = entity;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Account getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Account creatorId) {
        this.creatorId = creatorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(int dataGroupId) {
        this.dataGroupId = dataGroupId;
    }

    public String toString() {
        return String.format("Id = %d%n"
                        + "code = %s%n"
                        + "schema = %s%n"
                        + "urn = %s%n"
                        + "name = %s%n"
                        + "entity = %b%n"
                        + "system = %b%n"
                        + "creation_date = %s%n"
                        + "creator_id = %d%n"
                        + "description = %s%n"
                        + "group_id = %d%n"
                        + "data_group_id = %d%n",
                domainId, code, schema, urn, name, entity, system, creationDate, creatorId, description, groupId,
                dataGroupId);
    }
}