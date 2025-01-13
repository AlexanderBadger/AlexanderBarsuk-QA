import lombok.extern.log4j.Log4j;
import main.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static main.Constants.DateConstants.BIRTH_DATE_DAY;
import static main.Constants.DateConstants.BIRTH_DATE_MONTH;
import static main.Constants.DateConstants.BIRTH_DATE_YEAR;
import static main.Constants.PathConstants.DELETE_FILE_PATH;
import static main.Constants.PathConstants.EACH_DAY_FILE_PATH;
import static main.Constants.PathConstants.NEW_DIRECTORY_PATH;
import static main.Constants.PathConstants.NEW_FILE_NAME;
import static main.Constants.PathConstants.NEW_NAME_FILE_PATH;
import static main.Constants.PathConstants.OLD_NAME_FILE_PATH;
import static main.Constants.PathConstants.READ_FILE_PATH;
import static main.Constants.PathConstants.WRITE_FILE_PATH;
import static main.Constants.StringConstants.TEXT_TO_WRITE;
import static main.Constants.StringConstants.WRITE_TEXT;
import static main.FileUtils.createDirectoryAndFile;
import static main.FileUtils.renameFile;
import static main.FileUtils.writeDailyEntries;

@Log4j
public class FileTests {
    @Test
    @DisplayName("Задание 9. Напишите программу, которая считывает текст из файла и выводит его содержимое на экран")
    public void readTextFromFileTest() {
        FileUtils.readFile(READ_FILE_PATH);
    }

    @Test
    @DisplayName("Задание 10. Напишите программу, которая записывает заданный текст в файл")
    public void writeTextToFileTest() throws IOException {
        Path filePath = Paths.get(WRITE_FILE_PATH);
        // Создаем файл
        FileUtils.createFile(filePath);
        // Записываем данные в файл
        FileUtils.writeDataToFile(filePath, WRITE_TEXT);
        // Удаляем файл после теста
        FileUtils.deleteFileIfExists(filePath);
    }

    @Test
    @DisplayName("Задание 11. Напишите программу, которая переименовывает файл")
    public void renameFileTest() throws IOException {
        Path filePath = Paths.get(OLD_NAME_FILE_PATH);
        // Создаем файл
        FileUtils.createFile(filePath);
        // Переименовываем файл
        renameFile(OLD_NAME_FILE_PATH, NEW_NAME_FILE_PATH);
        // Возвращаем файлу исходное имя
        renameFile(NEW_NAME_FILE_PATH, OLD_NAME_FILE_PATH);
        // Удаляем файл после теста
        FileUtils.deleteFileIfExists(filePath);
    }

    @Test
    @DisplayName("Задание 12. Напишите программу, которая создает директорию, в ней файл,  заполняет его данными, "
            + "затем удаляет заданный файл")
    public void createAndFillDirectoryTest() {
        createDirectoryAndFile(NEW_DIRECTORY_PATH, NEW_FILE_NAME, TEXT_TO_WRITE, DELETE_FILE_PATH);
    }

    @Test
    @DisplayName("Задание 13. Напишите программу, которая пишет в файл каждый день, начиная от вашего дня рождения "
            + "с указанием дня недели. После каждого 31 декабря делать два отступа,"
            + "после каждого последнего дня месяца - один, "
            + "день рождения отделять от общих строк пустой строкой сверху и снизу")
    public void writeEachDayFromDateTest() {
        LocalDate birthday = LocalDate.of(BIRTH_DATE_YEAR, BIRTH_DATE_MONTH, BIRTH_DATE_DAY);
        writeDailyEntries(EACH_DAY_FILE_PATH, birthday);
    }
}