public class Constants {
    public  static final String URL = "jdbc:postgresql://192.168.100.72:5432/dictionary_service_new";
    public static final String USER = "dictionary_service_reader";
    public static final String PASS = "dictionary_service_reader";
    public static final String SQL_QUERY_TASK1 = "SELECT code, schema, name FROM public.dictionary_domain WHERE id = ?";
    public static final String SQL_QUERY_TASK2 = "SELECT COUNT(*) AS total_domains FROM public.dictionary_domain";
    public static final String SQL_QUERY_TASK3 = "SELECT COUNT(*) FROM public.dictionary_domain WHERE name = ?";
    public static final String SQL_QUERY_TASK4 = "SELECT COUNT(*) FROM public.dictionary_metadata WHERE table_name LIKE 'rmz_%'";

}
