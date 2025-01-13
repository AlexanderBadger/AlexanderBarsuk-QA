package junit_stringInfoTest;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import task_6.Task6_4;
import task_6.TypeParamEnum;

import static junit_calc.ConstantsTest.EMPTY_STRING;
import static junit_calc.ConstantsTest.STRING_FOR_TESTS;
import static junit_calc.ConstantsTest.STRING_WITHOUT_NUMBERS;
import static junit_calc.ConstantsTest.STRING_WITHOUT_VOWELS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
class StringParamsTest {
    //Проверка расчета длины строки
    @Test
    void testStringLength() {
        String testString = STRING_FOR_TESTS;
        int expected = 68;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.LENGTH));
        log.info("Проверка определения длины строки пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.LENGTH));
    }

    //Проверка подсчета чисел в строке
    @Test
    void testDigitCount() {
        String testString = STRING_FOR_TESTS;
        int expected = 2;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.DIGIT));
        log.info("Проверка определения количества цифр в строке пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.DIGIT));
    }

    //Проверка подсчета букв в строке
    @Test
    void testLetterCount() {
        String testString = STRING_FOR_TESTS;
        int expected = 56;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.LETTER));
        log.info("Проверка определения количества букв в строке пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.LETTER));
    }

    //Проверка подсчета пробелов в строке
    @Test
    void testSpaceCount() {
        String testString = STRING_FOR_TESTS;
        int expected = 10;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.SPACE));
        log.info("Проверка определения количества пробелов в строке пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.SPACE));
    }

    //Проверка подсчета гласных букв в строке
    @Test
    void testVowelCount() {
        String testString = STRING_FOR_TESTS;
        int expected = 21;
        assertEquals(21, Task6_4.getStringParams(testString, TypeParamEnum.VOWEL));
        log.info("Проверка определения количества гласных букв в строке пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.VOWEL));
    }

    //Проверка метода по определению гласных букв
    @Test
    public void testIsVowel() {
        assertTrue(Task6_4.isVowel('а'));
        assertTrue(Task6_4.isVowel('у'));
        assertFalse(Task6_4.isVowel('б'));
        assertFalse(Task6_4.isVowel('г'));
        log.info("Проверка метода по определению гласных букв пройдена");
    }

    //Негативная проверка подсчета длины строки при заданной пустой строке
    @Test
    void testStringLengthEmptyString() {
        String testString = EMPTY_STRING;
        int expected = 0;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.LENGTH));
        log.info("Проверка определения длины пустой строки пройдена. Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.LENGTH));
    }

    //Негативная проверка подсчета цифр в строке с отсутствующими цифрами
    @Test
    void testDigitCountNoDigits() {
        String testString = STRING_WITHOUT_NUMBERS;
        int expected = 0;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.DIGIT));
        log.info("Проверка определения количества цифр в строке с отсутствующими цифрами пройдена. "
                + "Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.DIGIT));
    }

    //Негативная проверка подсчета кол-ва гласных букв в строке, где нет гласных
    @Test
    void testVowelCountNoVowels() {
        String testString = STRING_WITHOUT_VOWELS;
        int expected = 0;
        assertEquals(expected, Task6_4.getStringParams(testString, TypeParamEnum.VOWEL));
        log.info("Проверка определения количества гласных букв в строке с отсутствующими гласными пройдена."
                + " Ожидаемый результат: "
                + expected + ", Фактический результат: " + Task6_4.getStringParams(testString, TypeParamEnum.VOWEL));
    }
}