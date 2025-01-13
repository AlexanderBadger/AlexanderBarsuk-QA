package main;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

import static main.IntegerConstants.INT_3;
import static main.StringConstants.AVERAGE_SCORE_STRING;
import static main.StringConstants.BIRTH_DATE_STRING;
import static main.StringConstants.DATE_FORMAT;
import static main.StringConstants.EXCEPTION;
import static main.StringConstants.SPACE;

@Getter
public class StudentsInfo {
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Date birthDate;
    private final double averageScore;

    public StudentsInfo(String fullName, Date birthDate, double averageScore) {
        String[] nameParts = fullName.split(SPACE);
        if (nameParts.length == INT_3) {
            this.lastName = nameParts[0];
            this.firstName = nameParts[1];
            this.patronymic = nameParts[2];
        } else {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.birthDate = birthDate;
        this.averageScore = averageScore;
    }

    // Метод для получения полного имени
    public String getFullName() {
        return lastName + SPACE + firstName + SPACE + patronymic;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return lastName + SPACE + firstName + SPACE + patronymic
                + BIRTH_DATE_STRING + dateFormat.format(birthDate)
                + AVERAGE_SCORE_STRING + averageScore;
    }
}