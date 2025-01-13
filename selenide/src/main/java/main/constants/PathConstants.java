package main.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class PathConstants {
    public static final String BASE_URL = "https://stepik.org/catalog";
    public static final String PYTHON_XPATH = "//a[contains(@aria-label,'питон в простых и очень простых задачах')]";
    public static final String LOGIN_BUTTON_XPATH = "//a[text()='Войти']";
    public static final String SEARCH_FIELD_XPATH = "//input[@type='search']";
    public static final String CHECKBOX_FREE_XPATH = "Бесплатные";
    public static final String LOGIN_FIELD_XPATH = "//*[@id='id_login_email']";
    public static final String PASSWORD_FIELD_XPATH = "//*[@id='id_login_password']";
    public static final String LOGIN_FORM_BUTTON_XPATH = "//*[@id='login_form']/button";
    public static final String ALERT_XPATH = "//*[@id='login_form']/ul/li";
    public static final String FIND_BUTTON_XPATH = "button.search-form__submit";
    public static final String VACANCY_XPATH = "//a[text()='Вакансии']";
    public static final String SAVE_XPATH = "//button[text()='Сохранить изменения']";
    public static final String NAVBAR_PROFILE_XPATH = "//button[img[@class='navbar__profile-img']]";
    public static final String SETTINGS_XPATH = "//a[text()='Настройки']";
    public static final String ABOUT_FIELD_XPATH = "//textarea[@rows='7']";
    public static final String POPUP_XPATH = "//div[@id='ember440' and @class='woof-container ember-view']";
    public static final String COURSE_CARD_SELECTOR = "div.catalog-course-cards";
    public static final String ENROLL_BUTTON_XPATH = "//button[text()='Поступить на курс']";
}