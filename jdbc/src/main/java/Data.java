import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.100.72:5432/dictionary_service_new";
        String user = "dictionary_service_reader";
        String password = "dictionary_service_reader";
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            Statement stat = connection.createStatement();

            ResultSet result = stat.executeQuery("SELECT * FROM public.dictionary_domain");
            int i = 1;
            while (result.next()){
                System.out.println(result.getInt("id"));
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }

    }
}