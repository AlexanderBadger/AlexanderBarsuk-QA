package main;

import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.GregorianCalendar;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class StudentsInfoConstants {
    // Студент 1
    public static final String STUDENT_1_NAME = "Иванов Иван Иванович";
    public static final Calendar STUDENT_1_BIRTH_DATE = new GregorianCalendar(
            2000, Calendar.MARCH, 15
    );
    public static final double STUDENT_1_AVERAGE_SCORE = 4.5;
    // Студент 2
    public static final String STUDENT_2_NAME = "Петров Петр Петрович";
    public static final Calendar STUDENT_2_BIRTH_DATE = new GregorianCalendar(
            1999, Calendar.JULY, 22
    );
    public static final double STUDENT_2_AVERAGE_SCORE = 3.8;
    // Студент 3
    public static final String STUDENT_3_NAME = "Сидорова Анна Сергеевна";
    public static final Calendar STUDENT_3_BIRTH_DATE = new GregorianCalendar(
            2001, Calendar.NOVEMBER, 10
    );
    public static final double STUDENT_3_AVERAGE_SCORE = 4.9;
    // Студент 4
    public static final String STUDENT_4_NAME = "Кузнецова Анна Викторовна";
    public static final Calendar STUDENT_4_BIRTH_DATE = new GregorianCalendar(
            2000, Calendar.FEBRUARY, 5
    );
    public static final double STUDENT_4_AVERAGE_SCORE = 4.2;
    // Студент 5
    public static final String STUDENT_5_NAME = "Николаев Николай Николаевич";
    public static final Calendar STUDENT_5_BIRTH_DATE = new GregorianCalendar(
            1998, Calendar.AUGUST, 30
    );
    public static final double STUDENT_5_AVERAGE_SCORE = 3.5;
}