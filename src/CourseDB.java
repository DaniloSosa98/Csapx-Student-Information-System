import java.util.Collection;
import java.util.HashMap;

public class CourseDB extends Object implements DB<Integer, Course>{

    private HashMap<Integer, Course> courses;

    public CourseDB() {
    }

    @Override
    public Course addValue(Course course) {
        Course temp = null;
        if(this.hasKey(course.getId())){
            temp = this.getValue(course.getId());
            this.courses.put(course.getId(), course);
            return temp;
        }
        this.courses.put(course.getId(), course);
        return temp;
    }

    @Override
    public Collection<Course> getAllValues() {
        return this.courses.values();
    }

    @Override
    public Course getValue(Integer id) {
        if(this.hasKey(id)){
            return this.courses.get(id);
        }

        return null;
    }

    @Override
    public boolean hasKey(Integer id) {
        if(this.courses.containsKey(id)){
            return true;
        }
        return false;
    }
}
