import java.util.Comparator;

public class Student extends User{


    public Student(String username, UserType type, Comparator<Course> comp) {
        super(username, type, comp);
    }
}
