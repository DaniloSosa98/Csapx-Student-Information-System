import java.util.*;

public class User extends Object implements Comparable<User>{

    public enum UserType {
        PROFESSOR,
        STUDENT
    }

    private TreeSet<Course> courses;
    private User.UserType type;
    private String username;
    //private Comparator<Course> comp;

    public User(String username, User.UserType type, Comparator<Course> comp) {
        this.username = username;
        this.type = type;
        this.courses = new TreeSet<Course>(comp);
    }

    boolean addCourse(Course course){

        return this.courses.add(course);
    }

    @Override
    public int compareTo(User other) {
        System.out.println(this.username.compareTo(other.getUsername()));
        return this.username.compareTo(other.getUsername());
    }

    Collection<Course> getCourses(){
        for (Course c: this.courses) {
            System.out.println(c);
        }
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

    List<String> courseList(){
        ArrayList<String> courselist = new ArrayList<>();
        for (Course c: this.courses) {
            courselist.add(c.getName());
        }
        return courselist;
    }
    @Override
    public String toString(){
        return "User{username = " + this.username + ", type = " + this.type +
                ", courses = " + this.courseList();
    }
}
