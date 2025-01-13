import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GameBody {
    private final String title;
    private final String company;
    private final String description;
    private final ArrayList<Object> dlcs;

    @JsonProperty(value = "isFree")
    private final boolean isFree = true;
    private final int price = 0;

    public GameBody(Game game) {
        this.title = game.getTitle();
        this.description = game.getDescription();
        this.company = game.getCompany();
        this.dlcs = game.getDlcs();
    }
}