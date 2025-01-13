import lombok.extern.log4j.Log4j;
import main.DateTimeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static main.Constants.DateConstants.ADD_DAYS;
import static main.Constants.LogMessages.ADD_DAYS_LOG;
import static main.Constants.LogMessages.CURRENT_DATE_AND_TIME_IN_CITY_LOG;
import static main.DateTimeUtils.addDays;
import static main.DateTimeUtils.getCurrentDateTimeInZone;
import static main.DateTimeUtils.printCurrentDateComponents;
import static main.DateTimeUtils.printCurrentDateInCustomFormat;
import static main.DateTimeUtils.printCurrentDateTime;
import static main.DateTimeUtils.printCurrentTime;
import static main.DateTimeUtils.printDaysDifference;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
public class DateTimeTests {
    @Test
    @DisplayName("Задание 1. Напишите программу, которая выводит текущую дату и время.")
    public void currentDateTimeTest() {
        printCurrentDateTime();
    }

    @Test
    @DisplayName("Задание 2. Напишите программу, которая выводит текущую дату в формате 'dd.MM.yyyy'")
    public void customDateTest() {
        printCurrentDateInCustomFormat();
    }

    @Test
    @DisplayName("Задание 3. Напишите программу, которая выводит текущее время в формате 'HH:mm:ss'")
    public void customTimeTest() {
        printCurrentTime();
    }

    @ParameterizedTest
    @MethodSource("main.DateTimeUtils#timeZonesProvider")
    @DisplayName("Задание 4. Напишите программу, которая выводит текущее время в заданных часовых поясах.")
    void currentDateTimeInZonesTest(String timeZoneName, String zoneId) {
        log.info(String.format(CURRENT_DATE_AND_TIME_IN_CITY_LOG, timeZoneName, getCurrentDateTimeInZone(zoneId)));
    }

    @Test
    @DisplayName("Задание 5. Напишите программу, которая парсит строку в формате 'dd.MM.yyyy' "
            + "и выводит день, месяц и год отдельно")
    public void parsingDateTest() {
        printCurrentDateComponents();
    }

    @Test
    @DisplayName("Задание 6. Напишите программу, которая выводит разницу в днях между двумя датами")
    public void differenceBetweenDatesTest() {
        printDaysDifference();
    }

    @ParameterizedTest
    @MethodSource("main.DateTimeUtils#provideDatesForWeekendTest")
    @DisplayName("Задание 7. Проверка, является ли заданная дата выходным днем (суббота или воскресенье)")
    void weekendDateTest(LocalDate date, boolean expected) {
        boolean isWeekend = DateTimeUtils.weekend(date);
        assertEquals(expected, isWeekend);
    }

    @Test
    @DisplayName("Задание 8. Напишите программу, которая прибавляет "
            + "или удаляет заданное количество дней к дате и выводит их на печать")
    public void addOrRemoveDaysTest() {
        log.info(ADD_DAYS_LOG + ADD_DAYS);
        addDays(ADD_DAYS);
    }
}