package main;

import lombok.extern.log4j.Log4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static main.IntegerConstants.INT_1;
import static main.LogMessages.EMPTY_LIST_LOG;
import static main.LogMessages.LAUNCH_STUDENTS_COUNT_LOG;
import static main.LogMessages.SEARCH_MAX_AVERAGE_SCORE_LOG;
import static main.LogMessages.SEARCH_YOUNGEST_STUDENT_LOG;
import static main.LogMessages.SORT_FINISH_LOG;
import static main.LogMessages.START_SORT_STUDENTS_LOG;
import static main.LogMessages.STUDENTS_COUNT_LOG;
import static main.LogMessages.STUDENT_WITH_MAX_AVERAGE_SCORE_LOG;
import static main.LogMessages.SUCCESS_SEARCH_YOUNGEST_STUDENT_LOG;
import static main.LogMessages.WITHDRAWAL_OF_UNIQUE_NAME_LOG;

@Log4j
public class StudentUtils {
    private final List<StudentsInfo> students;

    public StudentUtils(List<StudentsInfo> students) {
        this.students = students;
    }

    /**
     * Отсортировать и вывести студентов по дате рождения.
     *
     */
    public List<StudentsInfo> printStudentsSortedByBirthDate() {
        if (students == null) {
            log.info(EMPTY_LIST_LOG);
            return Collections.emptyList();
        }
        log.info(START_SORT_STUDENTS_LOG);
        List<StudentsInfo> sortedStudents = students.stream()
                .sorted(Comparator.comparing(StudentsInfo::getBirthDate))
                .collect(Collectors.toList());
        log.info(SORT_FINISH_LOG + sortedStudents);
        return sortedStudents;
    }

    /**
     * Найти студента с максимальным средним баллом.
     *
     * @return студент с максимальным средним баллом или null, если список студентов пуст.
     */
    public StudentsInfo findStudentWithMaxAverageScore() {
        log.info(SEARCH_MAX_AVERAGE_SCORE_LOG);
        StudentsInfo maxStudent = students.stream()
                .max(Comparator.comparing(StudentsInfo::getAverageScore))
                .orElse(null);
        if (maxStudent != null) {
            log.info(String.format(STUDENT_WITH_MAX_AVERAGE_SCORE_LOG, maxStudent));
        } else {
            log.error(EMPTY_LIST_LOG);
        }
        return maxStudent;
    }

    /**
     * Найти самого молодого студента.
     *
     * @return самый молодой студент или null, если список студентов пуст.
     */
    public StudentsInfo findYoungestStudent() {
        log.info(SEARCH_YOUNGEST_STUDENT_LOG);
        StudentsInfo youngestStudent = students.stream()
                .max(Comparator.comparing(StudentsInfo::getBirthDate))
                .orElse(null);
        if (youngestStudent != null) {
            log.info(String.format(SUCCESS_SEARCH_YOUNGEST_STUDENT_LOG, youngestStudent));
        } else {
            log.error(EMPTY_LIST_LOG);
        }
        return youngestStudent;
    }

    /**
     * Вывести студентов с уникальными именами.
     */
    public void printStudentsWithUniqueNames(List<StudentsInfo> studentList) {
        log.info(WITHDRAWAL_OF_UNIQUE_NAME_LOG);
        Map<String, Long> nameCount = this.students.stream()
                .collect(Collectors.groupingBy(StudentsInfo::getFirstName, Collectors.counting()));
        studentList.stream()
                .filter(student -> nameCount.get(student.getFirstName()) == INT_1)
                .forEach(System.out::println);
    }

    /**
     * Вывести количество людей с определенным именем.
     *
     * @param name имя для поиска.
     * @return количество студентов с указанным именем.
     */
    public long countStudentsWithName(String name) {
        log.info(String.format(LAUNCH_STUDENTS_COUNT_LOG, name));
        long count = students.stream()
                .filter(student -> student.getFirstName().equals(name))
                .count();
        log.info(String.format(STUDENTS_COUNT_LOG, name, count));
        return count;
    }
}