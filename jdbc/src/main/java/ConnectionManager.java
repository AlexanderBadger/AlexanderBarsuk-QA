import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class ConnectionManager {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        log.info("Подключаемся к БД");
        return DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASS);
    }

    public static void closeConnection() throws SQLException {
        log.info("Соединение закрыто.");
        if (connection != null && !connection.isClosed()) {
            connection.close();

        }
    }

    private static void processResultSet(ResultSet resultSet) throws SQLException {
        String code = resultSet.getString("code");
        String schema = resultSet.getString("schema");
        String name = resultSet.getString("name");

        System.out.println("Code: " + code);
        System.out.println("Schema: " + schema);
        System.out.println("Name: " + name);
    }

}