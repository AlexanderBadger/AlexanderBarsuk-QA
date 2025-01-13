import lombok.extern.log4j.Log4j;
import main.StudentUtils;
import main.StudentsInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static main.IntegerConstants.INT_1;
import static main.IntegerConstants.INT_2;
import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.INT_4;
import static main.LogMessages.LAUNCH_TEST_LOG;
import static main.LogMessages.TEST_PASSED_LOG;
import static main.StringConstants.LASTNAME_FOR_TESTS;
import static main.StringConstants.NAME_FOR_TESTS;
import static main.StringConstants.NAME_FOR_TEST_COUNTER;
import static main.StringConstants.PATRONYMIC_FOR_TESTS;
import static main.StudentsInfoConstants.STUDENT_1_AVERAGE_SCORE;
import static main.StudentsInfoConstants.STUDENT_1_BIRTH_DATE;
import static main.StudentsInfoConstants.STUDENT_1_NAME;
import static main.StudentsInfoConstants.STUDENT_2_AVERAGE_SCORE;
import static main.StudentsInfoConstants.STUDENT_2_BIRTH_DATE;
import static main.StudentsInfoConstants.STUDENT_2_NAME;
import static main.StudentsInfoConstants.STUDENT_3_AVERAGE_SCORE;
import static main.StudentsInfoConstants.STUDENT_3_BIRTH_DATE;
import static main.StudentsInfoConstants.STUDENT_3_NAME;
import static main.StudentsInfoConstants.STUDENT_4_AVERAGE_SCORE;
import static main.StudentsInfoConstants.STUDENT_4_BIRTH_DATE;
import static main.StudentsInfoConstants.STUDENT_4_NAME;
import static main.StudentsInfoConstants.STUDENT_5_AVERAGE_SCORE;
import static main.StudentsInfoConstants.STUDENT_5_BIRTH_DATE;
import static main.StudentsInfoConstants.STUDENT_5_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тесты для класса StudentsManager.
 */
@Log4j
class StudentsTest {
    private List<StudentsInfo> students;
    private StudentUtils studentUtils;

    /**
     * Инициализация данных перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        students = Arrays.asList(
                new StudentsInfo(STUDENT_1_NAME, STUDENT_1_BIRTH_DATE.getTime(), STUDENT_1_AVERAGE_SCORE),
                new StudentsInfo(STUDENT_2_NAME, STUDENT_2_BIRTH_DATE.getTime(), STUDENT_2_AVERAGE_SCORE),
                new StudentsInfo(STUDENT_3_NAME, STUDENT_3_BIRTH_DATE.getTime(), STUDENT_3_AVERAGE_SCORE),
                new StudentsInfo(STUDENT_4_NAME, STUDENT_4_BIRTH_DATE.getTime(), STUDENT_4_AVERAGE_SCORE),
                new StudentsInfo(STUDENT_5_NAME, STUDENT_5_BIRTH_DATE.getTime(), STUDENT_5_AVERAGE_SCORE)
        );
        studentUtils = new StudentUtils(students);
    }

    /**
     * Тестирование метода поиска студента с максимальным средним баллом.
     */
    @Test
    @DisplayName("Проверка метода по поиску студента с максимальным средним балом")
    void findStudentWithMaxAverageScoreTest() {
        log.info(LAUNCH_TEST_LOG);
        StudentsInfo maxScoreStudent = studentUtils.findStudentWithMaxAverageScore();
        assertNotNull(maxScoreStudent);
        assertEquals(LASTNAME_FOR_TESTS, maxScoreStudent.getLastName());
        assertEquals(NAME_FOR_TESTS, maxScoreStudent.getFirstName());
        assertEquals(PATRONYMIC_FOR_TESTS, maxScoreStudent.getPatronymic());
        log.info(TEST_PASSED_LOG);
    }

    /**
     * Тестирование метода поиска самого молодого студента.
     */
    @Test
    @DisplayName("Проверка метода по поиску самого молодого студента")
    void findYoungestStudentTest() {
        log.info(LAUNCH_TEST_LOG);
        StudentsInfo youngestStudent = studentUtils.findYoungestStudent();
        assertNotNull(youngestStudent);
        assertEquals(LASTNAME_FOR_TESTS, youngestStudent.getLastName());
        assertEquals(NAME_FOR_TESTS, youngestStudent.getFirstName());
        assertEquals(PATRONYMIC_FOR_TESTS, youngestStudent.getPatronymic());
        log.info(TEST_PASSED_LOG);
    }

    /**
     * Тестирование метода подсчета студентов с заданным именем.
     */
    @Test
    @DisplayName("Проверка метода по поиску студентов с одинаковым именем")
    void countStudentsWithNameTest() {
        log.info(LAUNCH_TEST_LOG);
        long count = studentUtils.countStudentsWithName(NAME_FOR_TEST_COUNTER);
        // Учитываем, что два студента имеют имя "Анна"
        assertEquals(INT_2, count);
        log.info(TEST_PASSED_LOG);
    }

    /**
     * Проверяет метод сортировки студентов по дате рождения.
     * Ожидается, что студенты будут отсортированы в порядке возрастания даты рождения.
     */
    @Test
    @DisplayName("Проверка метода по сортировке студентов по дате рождения")
    void printStudentsSortedByBirthDateTest() {
        // Вызываем метод
        List<StudentsInfo> sortedStudents = studentUtils.printStudentsSortedByBirthDate();
        // Проверяем порядок студентов
        assertEquals(STUDENT_5_NAME, sortedStudents.getFirst().getFullName());
        assertEquals(STUDENT_2_NAME, sortedStudents.get(INT_1).getFullName());
        assertEquals(STUDENT_4_NAME, sortedStudents.get(INT_2).getFullName());
        assertEquals(STUDENT_1_NAME, sortedStudents.get(INT_3).getFullName());
        assertEquals(STUDENT_3_NAME, sortedStudents.get(INT_4).getFullName());
        log.info(TEST_PASSED_LOG);
    }

    /**
     * Проверяет метод вывода студентов с уникальными именами.
     * Ожидается, что вывод будет содержать только студентов с уникальными именами,
     * исключая тех, у кого имена повторяются.
     */
    @Test
    @DisplayName("Проверка вывода студентов с уникальными именами")
    void printStudentsWithUniqueNamesTest() {
        // Сохраняем вывод в ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Вызываем метод
        studentUtils.printStudentsWithUniqueNames(students);
        log.info(outputStream);
        // Получаем вывод
        String output = outputStream.toString();
        // Проверяем, что вывод содержит только студента с уникальным именем
        assertTrue(output.contains(STUDENT_1_NAME));
        assertTrue(output.contains(STUDENT_2_NAME));
        assertTrue(output.contains(STUDENT_5_NAME));
        assertFalse(output.contains(STUDENT_4_NAME));
        log.info(TEST_PASSED_LOG);
    }
}