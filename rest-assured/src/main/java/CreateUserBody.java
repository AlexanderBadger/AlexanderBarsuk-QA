import lombok.Getter;

@Getter
public class CreateUserBody {
    private final String login;
    private final String pass;

    public CreateUserBody(User user) {
        this.login = user.getUsername();
        this.pass = user.getPassword();
    }
}