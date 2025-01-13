import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class Game {
    private String company;
    private String description;
    private ArrayList<Object> dlcs = new ArrayList<>();
    private int gameId;
    private String genre;
    private boolean isFree;
    private int price;
    private Date publish_date;
    private int rating;
    private boolean requiredAge;
    private String[] tags;
    private String title;

    public Game(String description, String company, String title) {
        this.description = description;
        this.company = company;
        this.title = title;
        publish_date = new Date();
    }

    public static String randomGameTitle() {
        return Constants.GAME_TITLE + new Random().nextInt(Constants.NUMBER_1, Constants.NUMBER_2);
    }
}