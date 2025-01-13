import lombok.Getter;

@Getter
public class PasswordUpdateBody {
    private final String password;

    public PasswordUpdateBody(String password) {
        this.password = password;
    }
}