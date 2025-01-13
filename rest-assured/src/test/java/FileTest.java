import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

@Log4j
public class FileTest {
    @Test
    @DisplayName("Задача 8. Скачать картинку с сервера в формате JPEG")
    public void downloadImageTest() {
        String filePath = Constants.DOWNLOAD_LINK;
        if (!RequestSteps.isFileDownloaded(filePath)) {
            Response response = RequestSteps.downloadImage();
            RequestSteps.saveImage(response);
        } else {
            log.info("Файл уже загружен: " + filePath);
        }
    }

    @Test
    @DisplayName("Задача 9. Загрузить файл на сервер")
    public void uploadImageTest() {
        File imageFile = RequestSteps.getImageFile();
        RequestSteps.uploadImage(imageFile);
    }
}