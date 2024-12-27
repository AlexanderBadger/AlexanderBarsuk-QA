import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@Log4j
public class GetDataTest {

    static Connection connection = null;

    @BeforeEach
    void connect() throws SQLException{
        connection = ConnectionManager.getConnection();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        ConnectionManager.closeConnection();
    }

    @Test
    @DisplayName("Задание 1. Из таблицы public.dictionary_domain вывести code, schema, name у записи с id =7")
    public void getDataFromDomain(){
        log.info("Отправляем запрос");
        try (PreparedStatement preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_TASK1)) {
            preparedStatement.setInt(1,7);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String code = resultSet.getString("code");
                String schema = resultSet.getString("schema");
                String name = resultSet.getString("name");
                log.info("Получен ответ");
                log.info("Code: " + code + " ," + "Schema: " + schema + " ," + "Name: " + name);
            } else {
                log.info("Запись с id = 7 не найдена.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Задание 2. Из таблицы public.dictionary_domain вывести общее количество доменов")
    public void getTotalDomainTest(){
        try (PreparedStatement preparedStatement = connection.prepareStatement(Constants.SQL_QUERY_TASK2)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Constants.SQL_QUERY_TASK2);

            if (resultSet.next()) {
                int totalDomains = resultSet.getInt("total_domains");
                log.info("Общее количество доменов: " + totalDomains);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Задание 3. Из таблицы public.dictionary_metadata вывести количество записей, "
            + "у которых домен с именем: ЕСНСИ")
    public void getCountTest(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Установка соединения с базой данных
            connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASS);

            // SQL-запрос для подсчета записей с доменом "ЕСНСИ"
            String query = "SELECT COUNT(*) FROM public.dictionary_domain WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "ЕСНСИ"); // Устанавливаем значение для параметра

            // Выполнение запроса
            resultSet = preparedStatement.executeQuery();

            // Обработка результата
            if (resultSet.next()) {
                int count = resultSet.getInt(1); // Получаем количество записей
                System.out.println("Количество записей с доменом 'ЕСНСИ': " + count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрытие ресурсов
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Задание 4. Из таблицы public.dictionary_metadata вывести количество записей, "
            + "у которых имя таблицы начинается с \"rmz_\"")
    public void getCountWithJoin (){
        try (Connection connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASS)) {
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT COUNT(*) FROM public.dictionary_metadata WHERE table_name LIKE 'rmz_%'";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Количество записей с именем таблицы, начинающимся на 'rmz_': " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
