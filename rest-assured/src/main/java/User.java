import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private ArrayList<Game> games = new ArrayList<>();
    private boolean savedInDB;
    private String token;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static String randomUsername() {
        return Constants.USER_NAME + new Random().nextInt(Constants.NUMBER_2, Constants.NUMBER_3);
    }

    public static String randomPassword() {
        return Constants.USER_NAME + new Random().nextInt(Constants.NUMBER_2, Constants.NUMBER_3);
    }
}