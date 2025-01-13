import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;

public class CodeResponseTest {
    @Test
    @DisplayName("Задача 1.1 Получить код 200")
    public void checkStatusCode200Test() {
        Response response = BasicRequests.getResponse(Constants.GET_CARS_BRANDS);
        RequestSteps.verifyStatusCode(response, SC_OK);
    }

    @Test
    @DisplayName("Задача 1.2 Получить код 404")
    public void checkStatusCode404Test() {
        Response response = BasicRequests.getResponse(Constants.GET_INVALID_URL);
        RequestSteps.verifyStatusCode(response, SC_NOT_FOUND);
    }
}