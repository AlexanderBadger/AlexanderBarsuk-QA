package src.Task_7.Task_7_tableModel;

import static src.Task_7.Task_7_tableModel.Constants.ACCOUNT_ID;

import java.util.Date;

public class Account {
    private final int accountId;
    private String login;
    private String name;
    private boolean isActive = false;
    private boolean isGroup = true;
    private final Date creationDate;

    public Account() {
        this.accountId = ACCOUNT_ID;
        this.login = "User";
        this.creationDate = Constants.CREATION_DATE;
    }

    public int getId() {
        return accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean hasGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String toString() {
        return String.format("Id = %d%n"
                        + "login = %s%n"
                        + "name = %s%n"
                        + "active = %b%n"
                        + "is_group = %b%n"
                        + "creation_date = %s%n",
                accountId, login, name, isActive, isGroup, creationDate);
    }
}