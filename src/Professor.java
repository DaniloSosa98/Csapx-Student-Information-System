import java.util.Comparator;

public class Professor extends User{

    public Professor(String username, UserType type, Comparator<Course> comp) {
        super(username, type, comp);
    }
}
