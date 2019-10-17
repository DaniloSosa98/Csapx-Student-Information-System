import java.util.Comparator;

public class StudentComparator extends Object implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        int result = new CourseComparator().compare(o1, o2);
        return result;
    }
}
