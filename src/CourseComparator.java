import java.util.Comparator;

/**
 * A class that overrides the natural order comparison of courses to order
 * them alphabetically by course name.
 *
 * @author YOUR NAME HERE
 */
public class CourseComparator extends Object implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result;
    }
}
