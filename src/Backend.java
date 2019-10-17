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

        for (int i = 0; i < courseIds.length; i++) {
            int id = Integer.parseInt(courseIds[i]);
            if (this.courseExists(id)){
                user.addCourse(this.getCourse(id));
                System.out.println("Course added to: " + user.getUsername());
                if(user.getType() == User.UserType.STUDENT){
                    this.courseDB.getValue(id).addStudent(user.getUsername());
                    System.out.println("Student added to: " + this.courseDB.getValue(id).getName());
                }else if(user.getType() == User.UserType.PROFESSOR){
                    this.courseDB.getValue(id).addProfessor(user.getUsername());
                    System.out.println("Professor added to: " + this.courseDB.getValue(id).getName());
                }
            }
        }
    }

    boolean courseExists(int id){
        if(this.courseDB.hasKey(id)){
            System.out.println("Course exists");
            return true;
        }
        System.out.println("Course does not exists");
        return false;
    }

    boolean enrollStudent(String username, int courseId){
        if(this.userExists(username) && this.isStudent(username) && this.courseExists(courseId)){
            this.userDB.getValue(username).addCourse(this.getCourse(courseId));
            this.courseDB.getValue(courseId).addStudent(username);
            System.out.println("Succesfully enrolled");
            return true;
        }
        System.out.println("Not able to enroll");
        return false;
    }

    Collection<Course> getAllCourses(){
        System.out.println("All courses: ");
        return this.courseDB.getAllValues();
    }

    Collection<User> getAllUsers(){
        System.out.println("All users: ");
        return this.userDB.getAllValues();
    }

    Course getCourse(int id){
        if(this.courseExists(id)){
            return this.courseDB.getValue(id);
        }
        System.out.println("Couldn't get course");
        return null;
    }

    Collection<Course> getCourseUser(String username){
        if(this.userExists(username)){
            return this.userDB.getValue(username).getCourses();
        }
        System.out.println("No courses for non-existent user");
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

                this.addCourses(temp, courses);
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
                //new student
                String[] courses = new String[fields.length-1];
                for (int i = 1; i < fields.length; i++) {
                    courses[i-1] = fields[i];
                }
                this.addCourses(temp, courses);
                //adds courses to student
                this.userDB.addValue(temp);
            }
        }
    }

    boolean isStudent(String username){
        if (this.userExists(username) && this.userDB.getValue(username).getType() == User.UserType.STUDENT){
            System.out.println(username + " is a Student");
            return true;
        }
        System.out.println("Not a student, or does not exists");
        return false;
    }

    boolean unenrollStudent(String username, int courseId){
        if(this.userExists(username) && this.isStudent(username) && this.courseExists(courseId)){
            this.userDB.getValue(username).removeCourse(this.getCourse(courseId));
            this.courseDB.getValue(courseId).removeStudent(username);
            System.out.println("Student unenrolled");
            return true;
        }
        System.out.println("Not a student or course does not exists");
        return false;
    }

    boolean userExists(String username){
        if(this.userDB.hasKey(username)){
            System.out.println("User exists");
            return true;
        }
        System.out.println("User does not exists");
        return false;
    }

}
