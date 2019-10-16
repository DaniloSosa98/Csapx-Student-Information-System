import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class User extends Object implements Comparable<User>{

    public enum UserType {
        PROFESSOR,
        STUDENT
    }

    private TreeSet<Course> courses;
    private User.UserType type;
    private String username;

    public User(String username, User.UserType type, Comparator<Course> comp) {
        this.username = username;
        this.type = type;
    }

    boolean addCourse(Course course){
        return false;
    }

    @Override
    public int compareTo(User other) {
        return 0;
    }

    Collection<Course> getCourses(){
        return null;
    }

    User.UserType getType(){
        return null;
    }

    String getUsername(){
        return null;
    }

    @Override
    public int hashCode(){
        return this.username.hashCode();
    }

    boolean removeCourse(Course course){
        return false;
    }

    @Override
    public String toString(){
        return "User{username = " + this.username + ", type = " + this.type +
                ", courses = " + this.courses;
    }
}
