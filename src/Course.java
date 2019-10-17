import java.util.*;

/**
 * Represents a course.
 *
 * @author Sean Strout @ RIT CS
 * @author YOUR NAME HERE
 */
public class Course extends Object implements Comparable<Course> {
    /** course id (unique) */
    private int id;
    /** course name */
    private String name;
    /** course level */
    private int level;
    /** professor teaching the course, null if none */
    private String professor;
    /** students enrolled in the course (unique), empty if none */
    private HashSet<String> students;

    /**
     * Create a course.  Initially there is no professor or student for the
     * course.
     *
     * @param id course id
     * @param name course name
     * @param level course level
     */
    public Course(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.professor = null;
        this.students = new HashSet<>();
    }

    /**
     * Get the course id.
     *
     * @return course id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get the course name.
     *
     * @return course name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the course level.
     *
     * @return course level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Get the professor teaching the course.
     *
     * @return the professor, if none, null
     */
    public String getProfessor() {
        return this.professor;
    }

    /**
     * Get the students enrolled in the course.
     *
     * @return the students, organized by interally by hash codes. if there
     *  are no students enrolled the list should be empty.
     */
    public Collection<String> getStudents() {
        return this.students;
    }

    /**
     * Make a professor the instructor of this course.  If another professor
     * was teaching it, that information is lost.
     *
     * @param username the username of the professor
     */
    public void addProfessor(String username) {
        this.professor = username;
    }

    /**
     * Add a student to the course, if they are not enrolled,
     * <b>in constant time</b>.
     *
     * @param username the username of the student
     * @return whether the student was added or not
     */
    public boolean addStudent(String username) {
        this.students.add(username);
        return true;
    }
    /**
     * Remove a student from the course, if they are enrolled,
     * <b>in constant time</b>.
     *
     * @param username the username of the student to remove
     * @return true if the student was removed, false if the student was not in the course
     */
    public boolean removeStudent(String username) {
        if(this.students.contains(username)){
            //System.out.println("Student removed");
            this.students.remove(username);
            return true;
        }
        System.out.println("Student was not in the course");
        return false;
    }

    /**
     * Compare courses naturally by ascending course id.
     *
     * @param other the other course to compare to
     * @return a value less than 0 if this course has an id less the other course,
     * 0 if the two courses have the same id, or a value greater than 0 if this
     * course has an id greater than the other course.
     */
    @Override
    public int compareTo(Course other) {
        if(this.id<other.getId()){
            return -1;
        }else if(this.id == other.getId()){
            return 0;
        }
        return 1;
    }

    /**
     * Two courses are equal if they have the same course id.
     *
     * @param other the other course
     * @return true if
     */
    @Override
    public boolean equals(Object other) {
        if(this.compareTo((Course)other) == 0){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return this.id;
    }
    /**
     * The hash code of a course is the course's id.
     *
     * @return the hash code
     */


    /**
     * Return a string representation of the course in the format:<br>
     * <br>
     * Course{id=ID, name=NAME, level=LEVEL, professor=PROF_USERNAME, students=STUDENT_LIST}<br>
     * <br>
     * Here, STUDENT_LIST should be a list of students username, displayed in traditional
     * bracketed list format, but organized by ascending hash code.  Note, in IntelliJ
     * you can have this automatically generated if you go to Code then Generate and select
     * toString.
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "Course{id=" +this.id+ ", name=" +this.name+", level="
                +this.level+", professor=" +this.professor+", students="
                +this.students + "}";
    }
}