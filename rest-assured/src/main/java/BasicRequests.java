import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BasicRequests {
    public static Response getResponse(String endpoint) {
        return given().contentType(ContentType.JSON).when().get(Constants.URL + endpoint);
    }

    public static Response getResponse(String endpoint, String token) {
        return given().header(Constants.AUTH_TEXT, token)
                .contentType(ContentType.JSON)
                .when()
                .get(Constants.URL + endpoint);
    }

    public static Response postResponse(String endpoint, Object payload) {
        return given().contentType(ContentType.JSON).body(payload).when().post(Constants.URL + endpoint);
    }

    public static Response postResponse(String endpoint, String token, Object payload) {
        return given().header(Constants.AUTH_TEXT, token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Constants.URL + endpoint);
    }

    public static Response putResponse(String endpoint, String token, Object payload) {
        return given().header(Constants.AUTH_TEXT, token)
                .contentType(ContentType.JSON).body(payload)
                .when()
                .put(Constants.URL + endpoint);
    }

    public static Response deleteResponse(String endpoint, String token) {
        return given().header(Constants.AUTH_TEXT, token)
                .contentType(ContentType.JSON)
                .when()
                .delete(Constants.URL + endpoint);
    }

    public static Response deleteResponse(String endpoint, String token, int id) {
        String endpointWithId = endpoint + "/" + id;
        return given().header(Constants.AUTH_TEXT, token)
                .contentType(ContentType.JSON)
                .when()
                .delete(Constants.URL + endpointWithId);
    }
}