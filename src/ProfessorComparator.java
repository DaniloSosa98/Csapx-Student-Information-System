import java.util.Comparator;

public class ProfessorComparator extends Object implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        int result = Integer.compare(o1.getLevel(), o2.getLevel());
        if(result == 0) {
            result = new CourseComparator().compare(o1, o2);
        }
        return result;
    }
}
