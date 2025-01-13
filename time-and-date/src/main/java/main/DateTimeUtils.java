package main;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.params.provider.Arguments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.stream.Stream;

import static main.Constants.DateAndTimeFormatConstants.CURRENT_TIME_FORMAT;
import static main.Constants.DateAndTimeFormatConstants.DATE_CUSTOM_FORMAT;
import static main.Constants.DateAndTimeFormatConstants.DATE_TIME_FORMAT;
import static main.Constants.DateConstants.DATE_1_FOR_TEST_DAY;
import static main.Constants.DateConstants.DATE_1_FOR_TEST_MONTH;
import static main.Constants.DateConstants.DATE_1_FOR_TEST_YEAR;
import static main.Constants.DateConstants.DATE_2_FOR_TEST_DAY;
import static main.Constants.DateConstants.DATE_2_FOR_TEST_MONTH;
import static main.Constants.DateConstants.DATE_2_FOR_TEST_YEAR;
import static main.Constants.DateConstants.START_OF_YEAR_DAY;
import static main.Constants.DateConstants.START_OF_YEAR_MONTH;
import static main.Constants.LogMessages.CURRENT_DATE_AND_TIME_LOG;
import static main.Constants.LogMessages.CURRENT_DATE_CUSTOM_FORMAT_LOG;
import static main.Constants.LogMessages.CURRENT_TIME_LOG;
import static main.Constants.LogMessages.DAYS_DIFFERENCE_LOG;
import static main.Constants.LogMessages.DAY_LOG;
import static main.Constants.LogMessages.MONTH_LOG;
import static main.Constants.LogMessages.SET_DATE_LOG;
import static main.Constants.LogMessages.UPDATE_DATE_LOG;
import static main.Constants.LogMessages.WEEKEND_LOG;
import static main.Constants.LogMessages.YEAR_LOG;
import static main.Constants.StringConstants.MOSCOW;
import static main.Constants.StringConstants.SPLIT_DOUBLE_SLASH;
import static main.Constants.StringConstants.TOMSK;
import static main.Constants.StringConstants.VLADIVOSTOK;
import static main.Constants.StringConstants.ZONE_ID_MOSCOW;
import static main.Constants.StringConstants.ZONE_ID_TOMSK;
import static main.Constants.StringConstants.ZONE_ID_VLADIVOSTOK;

@Log4j
public class DateTimeUtils {
    /**
     * Метод для вывода текущей даты и времени.
     */
    public static void printCurrentDateTime() {
        LocalDateTime currentDateTime = getCurrentDateTime();
        String formattedDateTime = formatDateTime(currentDateTime);
        log.info(CURRENT_DATE_AND_TIME_LOG + formattedDateTime);
    }

    /**
     * Метод для получения текущей даты и времени.
     *
     * @return текущая дата и время
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Метод для форматирования даты и времени в строку.
     *
     * @param dateTime дата и время для форматирования
     * @return отформатированная строка с датой и временем
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dateTime.format(formatter);
    }

    /**
     * Метод для вывода текущей даты в формате 'dd.MM.yyyy'.
     */
    public static void printCurrentDateInCustomFormat() {
        LocalDateTime currentDateTime = getCurrentDateTime();
        String formattedDate = formatDateInCustomFormat(currentDateTime);
        log.info(CURRENT_DATE_CUSTOM_FORMAT_LOG + formattedDate);
    }

    /**
     * Метод для форматирования текущей даты в строку 'dd.MM.yyyy'.
     *
     * @param dateTime дата и время для форматирования
     * @return отформатированная строка с датой
     */
    public static String formatDateInCustomFormat(LocalDateTime dateTime) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(DATE_CUSTOM_FORMAT);
        return dateTime.format(customFormatter);
    }

    /**
     * Выводит текущее время в формате 'HH:mm:ss'.
     */
    public static void printCurrentTime() {
        String formattedTime = formatCurrentTime();
        log.info(CURRENT_TIME_LOG + formattedTime);
    }

    /**
     * Предоставляет поток аргументов для тестирования часовых поясов.
     *
     * @return поток {@link Arguments}, где каждый аргумент представляет
     * название часового пояса и соответствующий идентификатор зоны.
     * <p>
     * Предоставляются следующие часовые пояса:
     * <ul>
     * <li>TOMSK - {@code ZONE_ID_TOMSK}</li>
     * <li>MOSCOW - {@code ZONE_ID_MOSCOW}</li>
     * <li>VLADIVOSTOK - {@code ZONE_ID_VLADIVOSTOK}</li>
     * </ul>
     * </p>
     */
    public static Stream<Arguments> timeZonesProvider() {
        return Stream.of(
                Arguments.of(TOMSK, ZONE_ID_TOMSK),
                Arguments.of(MOSCOW, ZONE_ID_MOSCOW),
                Arguments.of(VLADIVOSTOK, ZONE_ID_VLADIVOSTOK)
        );
    }

    /**
     * Форматирует текущее время в строку.
     *
     * @return Текущее время в формате 'HH:mm:ss'.
     */
    public static String formatCurrentTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(CURRENT_TIME_FORMAT);
        return LocalDateTime.now().format(timeFormatter);
    }

    /**
     * Получает текущую дату и время в заданной временной зоне.
     *
     * @param zoneId Идентификатор временной зоны (например, "Asia/Tomsk").
     * @return Текущая дата и время в формате 'yyyy-MM-dd HH:mm:ss z'.
     */
    public static String getCurrentDateTimeInZone(String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return zonedDateTime.format(formatter);
    }

    /**
     * Выводит компоненты текущей даты (день, месяц, год) в формате "dd.MM.yyyy".
     */
    public static void printCurrentDateComponents() {
        // Получаем текущую дату
        LocalDate currentDate = LocalDate.now();
        // Форматируем дату в строку 'dd.MM.yyyy'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_CUSTOM_FORMAT);
        String formattedDate = currentDate.format(formatter);
        // Парсим день, месяц и год
        String[] dateComponents = formattedDate.split(SPLIT_DOUBLE_SLASH);
        int day = Integer.parseInt(dateComponents[0]);
        int year = Integer.parseInt(dateComponents[2]);
        // Получаем название месяца
        String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        // Выводим результаты
        log.info(CURRENT_DATE_CUSTOM_FORMAT_LOG + formattedDate);
        log.info(DAY_LOG + day);
        log.info(MONTH_LOG + monthName);
        log.info(YEAR_LOG + year);
    }

    /**
     * Метод для вычисления разницы в днях между началом года и текущей датой.
     */
    public static void printDaysDifference() {
        // Получаем текущую дату
        LocalDate today = LocalDate.now();
        // Получаем начало года
        LocalDate startOfYear = LocalDate.of(today.getYear(), START_OF_YEAR_DAY, START_OF_YEAR_MONTH);
        // Вычисляем разницу в днях
        long daysDifference = ChronoUnit.DAYS.between(startOfYear, today);
        log.info(String.format(DAYS_DIFFERENCE_LOG, startOfYear, today, daysDifference));
    }

    public static Stream<Arguments> provideDatesForWeekendTest() {
        return Stream.of(
                // Суббота
                Arguments.of(LocalDate.of(DATE_1_FOR_TEST_YEAR, DATE_1_FOR_TEST_MONTH, DATE_1_FOR_TEST_DAY),
                        true),
                // Вторник
                Arguments.of(LocalDate.of(DATE_2_FOR_TEST_YEAR, DATE_2_FOR_TEST_MONTH, DATE_2_FOR_TEST_DAY),
                        false)
        );
    }

    /**
     * Метод для проверки, является ли заданная дата выходным днем (суббота или воскресенье).
     *
     * @param date Дата, которую нужно проверить.
     * @return true, если дата - выходной день, иначе false.
     */
    public static boolean weekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        log.info(String.format(WEEKEND_LOG, date, isWeekend));
        return isWeekend;
    }

    /**
     * Добавляет указанное количество дней к текущей дате и выводит
     * информацию о текущей и измененной дате в лог.
     *
     * @param days количество дней, которое необходимо добавить к текущей дате.
     */
    public static void addDays(int days) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(days);
        log.info(String.format(SET_DATE_LOG, currentDate));
        log.info(String.format(UPDATE_DATE_LOG, newDate));
    }
}