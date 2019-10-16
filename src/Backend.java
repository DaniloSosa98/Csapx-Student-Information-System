import java.util.Collection;

public class Backend extends Object{
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) {

    }

    private void addCourses(User user, String[] courseIds){

    }

    boolean courseExists(int id){
        return false;
    }

    boolean enrollStudent(String username, int courseId){
        return false;
    }

    Collection<Course> getAllCourses(){
        return null;
    }

    Collection<User> getAllUsers(){
        return null;
    }

    Course getCourse(int id){
        return null;
    }

    Collection<Course> getCourseUser(String username){
        return null;
    }

    private void initializeCourseDB(String courseFile){

    }

    private void initializeUserDB(String professorFile, String studentFile){

    }

    boolean isStudent(String username){
        return false;
    }

    boolean unenrollStudent(String username, int courseId){
        return false;
    }

    boolean userExists(String username){
        return false;
    }

}
