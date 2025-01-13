/*public static ResultSet runQuery(String query) {
    ResultSet resultSet = null;
    try {
        log.info("Установка соединения с БД");
        Connection conn = getNewConnection();
        assertTrue(conn.isValid(1));

        log.info("Отправка запроса в БД");
        Statement statement = conn.createStatement();
        resultSet = statement.executeQuery(query);
        assertNotNull(resultSet);

        conn.close();
        assertFalse(conn.isValid(1));
        log.info("Соединение с БД разорвано\n");
    } catch (SQLException e) {
        log.error(e.getMessage());
    }
    return resultSet;
}*/
