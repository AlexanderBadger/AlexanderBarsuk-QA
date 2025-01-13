import lombok.Getter;

@Getter
public class TokenBody {
    private final String password;
    private final String username;

    public TokenBody(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}