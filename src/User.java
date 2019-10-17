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
        this.courses = new TreeSet<Course>();
    }

    boolean addCourse(Course course){

        return this.courses.add(course);
    }

    @Override
    public int compareTo(User other) {
        return this.username.compareTo(other.getUsername());
    }

    Collection<Course> getCourses(){

        return this.courses;
    }

    User.UserType getType(){

        return this.type;
    }

    String getUsername(){

        return this.username;
    }

    @Override
    public boolean equals(Object other) {
        if(this.username == ((User)other).getUsername()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){

        return this.username.hashCode();
    }

    boolean removeCourse(Course course){
        return this.courses.remove(course);
    }

    @Override
    public String toString(){
        return "User{username = " + this.username + ", type = " + this.type +
                ", courses = " + this.courses;
    }
}
