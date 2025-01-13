import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Json {
    public static int arrayLength(Response responseBody) {
        JsonPath jsonArray = responseBody.jsonPath();
        return jsonArray.getInt("size()");
    }
}