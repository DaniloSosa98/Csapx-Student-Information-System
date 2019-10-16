import java.util.Collection;

public class Backend {
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) {

    }

    private void addCourses(User user, String[] courseIds){

    }

    boolean courseExists(int id){

    }

    boolean enrollStudent(String username, int courseId){

    }

    Collection<Course> getAllCourses(){

    }

    Collection<User> getAllUsers(){

    }

    Course getCourse(int id){

    }

    Collection<Course> getCourseUser(String username){

    }

    private void initializeCourseDB(String courseFile){

    }

    private void initializeUserDB(String professorFile, String studentFile){

    }

    boolean isStudent(String username){

    }

    boolean unenrollStudent(String username, int courseId){

    }

    boolean userExists(String username){

    }

}
