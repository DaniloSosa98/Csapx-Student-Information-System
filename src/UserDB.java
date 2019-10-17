import java.util.Collection;
import java.util.HashMap;

public class UserDB extends Object implements DB<String, User>{

    HashMap<String, User> users;

    public UserDB() {
        this.users = new HashMap<String, User>();
    }

    @Override
    public User addValue(User user) {
        User temp = null;
        if(this.hasKey(user.getUsername())){
            temp = this.getValue(user.getUsername());
            this.users.put(user.getUsername(), user);
            return temp;
        }
        this.users.put(user.getUsername(), user);
        return temp;
    }

    @Override
    public Collection<User> getAllValues() {

        return this.users.values();
    }

    @Override
    public User getValue(String username) {
        if(this.hasKey(username)){
            return this.users.get(username);
        }
        return null;
    }

    @Override
    public boolean hasKey(String username) {
        if(this.users.containsKey(username)){
            return true;
        }
        return false;
    }
}
