package src.Task_7.Task_7_tableModel;

import java.util.Date;

import static src.Task_7.Task_7_tableModel.Constants.CREATION_DATE;
import static src.Task_7.Task_7_tableModel.Constants.TABLE_MODEL_ID;

public class TableModel {
    private final int id;
    private Domain domain;
    private String baseName;
    private String tableName;
    private String seqName;
    private String source;
    private String code;
    private String urn;
    private String shortName;
    private Date versionDate;
    private String version;
    private final Date creationDate;
    private Date updateDate;
    private Account creator;
    private boolean external = false;
    private boolean privateData = true;
    private boolean latest = false;
    private PublishTypeEnum publishType;
    private boolean published = true;

    public TableModel(String baseName, String tableName, PublishTypeEnum publishType) {
        this.id = TABLE_MODEL_ID;
        this.baseName = baseName;
        this.tableName = tableName;
        this.creationDate = CREATION_DATE;
        this.updateDate = creationDate;
        this.publishType = publishType;
    }

    public int getId() {
        return id;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account getCreator() {
        return creator;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public boolean isExternal() {
        return external;
    }

    public void setPrivateData(boolean privateData) {
        this.privateData = privateData;
    }

    public boolean isPrivateData() {
        return privateData;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public boolean isLatest() {
        return latest;
    }

    public PublishTypeEnum getPublishType() {
        return publishType;
    }

    public void setPublishType(PublishTypeEnum publishType) {
        this.publishType = publishType;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String toString() {
        String domainSchema = domain != null ? domain.getSchema() : "null";
        String creatorName = creator != null ? creator.getLogin() : "null";
        System.out.printf("Id = %d%n"
                        + "domain = %s%n"
                        + "base_name = %s%n"
                        + "table_name = %s%n"
                        + "seq_name = %s%n"
                        + "source = %s%n"
                        + "code = %s%n"
                        + "urn = %s%n"
                        + "short_name = %s%n"
                        + "version_date = %s%n"
                        + "version = %s%n"
                        + "creation_date = %s%n"
                        + "update_date = %s%n"
                        + "creator = %s%n"
                        + "external = %b%n"
                        + "private = %b%n"
                        + "latest = %b%n"
                        + "publish_type = %s%n"
                        + "published = %b%n",
                id, domainSchema, baseName, tableName, seqName, source, code, urn, shortName, versionDate, version,
                creationDate, updateDate, creatorName, external, privateData, latest, publishType, published);
        return "";
    }
}