package main;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.Constants.DateAndTimeFormatConstants.WRITE_DATE_FORMAT;
import static main.Constants.DateConstants.BIRTH_DATE_DAY;
import static main.Constants.DateConstants.BIRTH_DATE_MONTH;
import static main.Constants.DateConstants.BIRTH_DATE_YEAR;
import static main.Constants.DateConstants.DAYS_TO_ADD;
import static main.Constants.DateConstants.LAST_MONTH;
import static main.Constants.LogMessages.CREATE_DIRECTORY_LOG;
import static main.Constants.LogMessages.ERROR_CREATING_FILE_LOG;
import static main.Constants.LogMessages.ERROR_DELETING_FILE_LOG;
import static main.Constants.LogMessages.ERROR_LOG;
import static main.Constants.LogMessages.FAILED_TO_CREATE_FILE_LOG;
import static main.Constants.LogMessages.FILE_ALREADY_EXIST_LOG;
import static main.Constants.LogMessages.FILE_CREATED_LOG;
import static main.Constants.LogMessages.FILE_FILLED_LOG;
import static main.Constants.LogMessages.FILE_NOT_FOUND_LOG;
import static main.Constants.LogMessages.READ_FILE_ERROR_LOG;
import static main.Constants.LogMessages.RECORDING_COMPLETED_LOG;
import static main.Constants.LogMessages.RECORDING_ERROR_LOG;
import static main.Constants.LogMessages.RENAME_FILE_ERROR_LOG;
import static main.Constants.LogMessages.SUCCESS_DIRECTORY_DELETE_LOG;
import static main.Constants.LogMessages.SUCCESS_FILE_DELETE_LOG;
import static main.Constants.LogMessages.SUCCESS_RENAME_FILE_LOG;
import static main.Constants.StringConstants.EMPTY_FILE;
import static main.Constants.StringConstants.LINE_INDENTATION;

@Log4j
public class FileUtils {
    /**
     * Считывает текст из указанного файла и выводит его содержимое на экран.
     *
     * @param filePath путь к файлу, который необходимо прочитать.
     */
    public static void readFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            log.error(READ_FILE_ERROR_LOG + e.getMessage());
        }
    }

    /**
     * Переименовывает файл.
     *
     * @param oldFilePath путь к существующему файлу.
     * @param newFilePath новый путь (включая новое имя) для файла.
     */
    public static void renameFile(String oldFilePath, String newFilePath) {
        Path oldPath = Paths.get(oldFilePath);
        Path newPath = Paths.get(newFilePath);
        try {
            // Переименовываем файл
            Files.move(oldPath, newPath);
            log.info(SUCCESS_RENAME_FILE_LOG + newFilePath);
        } catch (IOException e) {
            log.error(RENAME_FILE_ERROR_LOG + e.getMessage());
        }
    }

    /**
     * Создает директорию и файл, записывает данные в файл, удаляет указанный файл и
     * удаляет директорию, если она пуста.
     *
     * @param dirPath      путь к директории, которую нужно создать
     * @param fileName     имя файла, который нужно создать
     * @param data         данные, которые нужно записать в файл
     * @param fileToDelete путь к файлу, который нужно удалить
     */
    public static void createDirectoryAndFile(String dirPath, String fileName, String data, String fileToDelete) {
        Path directory = Paths.get(dirPath);
        Path file = directory.resolve(fileName);
        Path fileToDeletePath = Paths.get(fileToDelete);

        try {
            createDirectory(directory);
            createFile(file);
            writeDataToFile(file, data);
            deleteFileIfExists(fileToDeletePath);
            deleteDirectoryIfEmpty(directory);
        } catch (IOException e) {
            log.error(ERROR_LOG + e.getMessage());
        }
    }

    /**
     * Создает директорию, если она не существует.
     *
     * @param directory путь к директории
     * @throws IOException если возникла ошибка при создании директории
     */
    public static void createDirectory(Path directory) throws IOException {
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
            log.info(CREATE_DIRECTORY_LOG + directory);
        }
    }

    /**
     * Создает файл, если он не существует.
     *
     * @param file путь к файлу
     * @throws IOException если возникла ошибка при создании файла
     */
    public static void createFile(Path file) throws IOException {
        try {
            // Создаем файл, если он не существует
            if (!Files.exists(file)) {
                Files.createFile(file);
                log.info(FILE_CREATED_LOG + file);
            } else {
                log.warn(FILE_ALREADY_EXIST_LOG + file);
            }
        } catch (IOException e) {
            log.error(ERROR_CREATING_FILE_LOG + e.getMessage());
            throw new RuntimeException(FAILED_TO_CREATE_FILE_LOG + file, e);
        }
    }

    /**
     * Записывает данные в указанный файл.
     *
     * @param file путь к файлу
     * @param data данные, которые нужно записать
     * @throws RuntimeException если возникла ошибка при записи данных в файл
     */
    public static void writeDataToFile(Path file, String data) {
        try {
            // Записываем данные в файл
            Files.writeString(file, data);
            log.info(FILE_FILLED_LOG + data);
        } catch (IOException e) {
            log.error(RECORDING_ERROR_LOG + e.getMessage());
            throw new RuntimeException(RECORDING_ERROR_LOG + file, e);
        }
    }

    /**
     * Удаляет указанный файл, если он существует.
     *
     * @param fileToDelete путь к файлу для удаления
     * @throws RuntimeException если возникла ошибка при удалении файла
     */
    public static void deleteFileIfExists(Path fileToDelete) {
        try {
            if (Files.exists(fileToDelete)) {
                Files.delete(fileToDelete);
                log.info(SUCCESS_FILE_DELETE_LOG + fileToDelete);
            } else {
                log.info(FILE_NOT_FOUND_LOG + fileToDelete);
            }
        } catch (IOException e) {
            log.error(ERROR_DELETING_FILE_LOG + e.getMessage());
            throw new RuntimeException(ERROR_DELETING_FILE_LOG + fileToDelete, e);
        }
    }

    /**
     * Удаляет директорию, если она пуста.
     *
     * @param directory путь к директории для удаления
     * @throws IOException если возникла ошибка при удалении директории
     */
    public static void deleteDirectoryIfEmpty(Path directory) throws IOException {
        if (Files.exists(directory) && isDirectoryEmpty(directory)) {
            Files.delete(directory);
            log.info(SUCCESS_DIRECTORY_DELETE_LOG + directory);
        }
    }

    /**
     * Проверяет, пуста ли указанная директория.
     *
     * @param directory путь к директории
     * @return true, если директория пуста; иначе false
     * @throws IOException если возникла ошибка при проверке директории
     */
    public static boolean isDirectoryEmpty(Path directory) throws IOException {
        try (var dirStream = Files.newDirectoryStream(directory)) {
            return !dirStream.iterator().hasNext();
        }
    }

    /**
     * Записывает записи в файл, начиная с указанной даты.
     *
     * @param filePath  путь к файлу, в который будут записываться данные
     * @param startDate дата, с которой начинается запись (например, день рождения)
     */
    public static void writeDailyEntries(String filePath, LocalDate startDate) {
        Path path = Paths.get(filePath);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(WRITE_DATE_FORMAT);
        try {
            // Очищаем файл перед записью
            Files.writeString(path, EMPTY_FILE, java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.TRUNCATE_EXISTING);
            // Начинаем с текущей даты
            LocalDate currentDate = startDate;
            // Цикл записывает даты до текущей даты (включительно)
            while (!currentDate.isAfter(LocalDate.now())) {
                // Проверяем, является ли текущая дата днем рождения
                boolean isBirthday = (currentDate.getMonth() == startDate.getMonth()) &&
                        (currentDate.getDayOfMonth() == startDate.getDayOfMonth());
                // Если это день рождения, добавляем пустую строку перед
                if (isBirthday) {
                    Files.writeString(path, LINE_INDENTATION, java.nio.file.StandardOpenOption.CREATE,
                            java.nio.file.StandardOpenOption.APPEND);
                }
                // Записываем текущую дату
                String entry = currentDate.format(formatter) + LINE_INDENTATION;
                Files.writeString(path, entry, java.nio.file.StandardOpenOption.APPEND);
                // Если это день рождения, добавляем пустую строку после
                if (isBirthday) {
                    Files.writeString(path, LINE_INDENTATION, java.nio.file.StandardOpenOption.APPEND);
                }
                // Проверяем, является ли текущая дата последним днем месяца
                if (currentDate.getDayOfMonth() == currentDate.lengthOfMonth()) {
                    // Если последний день месяца, добавляем один отступ
                    Files.writeString(path, LINE_INDENTATION, java.nio.file.StandardOpenOption.APPEND);
                    // Проверяем, является ли это 31 декабря
                    if (currentDate.getMonthValue() == LAST_MONTH) {
                        // Если это 31 декабря, добавляем еще один отступ
                        Files.writeString(path, LINE_INDENTATION, java.nio.file.StandardOpenOption.APPEND);
                    }
                }
                // Переходим к следующему дню
                currentDate = currentDate.plusDays(DAYS_TO_ADD);
            }
            // Добавляем пустую строку в конце файла
            Files.writeString(path, LINE_INDENTATION, java.nio.file.StandardOpenOption.APPEND);
            log.info(String.format(RECORDING_COMPLETED_LOG, BIRTH_DATE_YEAR, BIRTH_DATE_MONTH, BIRTH_DATE_DAY));
        } catch (IOException e) {
            log.error(RECORDING_ERROR_LOG + e.getMessage());
        }
    }
}