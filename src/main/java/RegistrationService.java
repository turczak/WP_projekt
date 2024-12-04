import java.util.ArrayList;
import java.util.List;

public class RegistrationService implements IRegistrationService {

    private final List<User> users = new ArrayList<>();

    @Override
    public void register(User user) throws ValidationException {
        users.add(user);
        System.out.println("Registration successful. Welcome " + user.getLogin());
    }
}
