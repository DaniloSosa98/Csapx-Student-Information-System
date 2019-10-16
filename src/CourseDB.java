import java.util.Collection;
import java.util.HashMap;

public class CourseDB extends Object implements DB<Integer, Course>{

    private HashMap<Integer, Course> courses;

    public CourseDB() {
    }

    @Override
    public Course addValue(Course course) {
        return null;
    }

    @Override
    public Collection<Course> getAllValues() {
        return null;
    }

    @Override
    public Course getValue(Integer id) {
        return null;
    }

    @Override
    public boolean hasKey(Integer id) {
        return false;
    }
}
