import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class Backend extends Object{
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) throws FileNotFoundException {
        initializeCourseDB(courseFile);
        initializeUserDB(professorFile, studentFile);
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

    private void initializeCourseDB(String courseFile) throws FileNotFoundException{
        this.courseDB = new CourseDB();
        try (Scanner in = new Scanner(new File(courseFile))) {
            while (in.hasNext()) {
                Course temp;
                String[] fields = in.nextLine().split(",");
                int id = Integer.parseInt(fields[0]);
                // fields[0] is the course id, as a String
                String name = fields[1];
                // fields[1] is the course name, as a String
                int level = Integer.parseInt(fields[2]);
                // fields[2] is the course level, as a String
                temp = new Course(id, name, level);
                this.courseDB.addValue(temp);
            }
        }
    }

    private void initializeUserDB(String professorFile, String studentFile) throws FileNotFoundException{
        this.userDB = new UserDB();
        try (Scanner in = new Scanner(new File(professorFile))) {
            while (in.hasNext()) {
                Professor temp;
                String[] fields = in.nextLine().split(",");
                String username = fields[0];
                User.UserType type = User.UserType.PROFESSOR;
                temp = new Professor(username, type, new ProfessorComparator());
                //new professor
                String[] courses = new String[fields.length-1];
                for (int i = 1; i < fields.length; i++) {
                    courses[i-1] = fields[i];
                }

                //adds courses to professor
                this.userDB.addValue(temp);
            }
        }
        try (Scanner in = new Scanner(new File(studentFile))) {
            while (in.hasNext()) {
                Student temp;
                String[] fields = in.nextLine().split(",");
                String username = fields[0];
                User.UserType type = User.UserType.STUDENT;
                temp = new Student(username, type, new StudentComparator());
                //new professor
                for (int i = 1; i < fields.length; i++) {
                    temp.addCourse(this.courseDB.getValue(Integer.parseInt(fields[i])));
                }
                //adds courses to professor
                this.userDB.addValue(temp);
            }
        }
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
