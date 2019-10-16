import java.util.Collection;
import java.util.HashMap;

public class UserDB extends Object implements DB<String, User>{

    HashMap<String, User> users;

    public UserDB() {
    }

    @Override
    public User addValue(User user) {
        return null;
    }

    @Override
    public Collection<User> getAllValues() {
        return null;
    }

    @Override
    public User getValue(String username) {
        return null;
    }

    @Override
    public boolean hasKey(String username) {
        return false;
    }
}
