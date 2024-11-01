class BollesCourses{
    private String courseName;
    private String courseSub;
    private String courseLevel;
    private int coursePeriod;
    private int numCourses = 0;

    public BollesCourses(String name, String subject, String level, int period){
        courseName = name;
        courseSub = subject;
        courseLevel = level;
        coursePeriod = period;
    }

    public void changeCourse(String name, String subject, String level, int period) {
        /**
         * @method that changes the Study Hall to Computer Science AP
         **/
        courseName = name;
        courseSub = subject;
        courseLevel = level;
        coursePeriod = period;
    }
    public int getCoursePeriod(){
        return this.coursePeriod;
    }

    public void setNumCourses() {
        /**
         * this method was a tentative to create an int that would tell me
         * how many courses I have on my schedule
         **/
        numCourses++;
    }

    public String toString(){
        if(courseLevel.equals("Honors") || courseLevel.equals("")){
            /**
             * if statement to make the "honors" comes first in the name and to put the Study Hall in a good format
             **/
            return String.format("%-15s", courseSub) + String.format("%-30s", courseName + " " + courseLevel) +
                    String.format("%-8d", coursePeriod);
        }
        else{
            /**
             * else statement to put the "AP" and the "regular" after the name
             **/
            return String.format("%-15s", courseSub) + String.format("%-30s", courseLevel + " " + courseName) +
                    String.format("%-8d", coursePeriod);
        }
    }

}
class Student{
    private String name;
    private String ID;
    private String advisor;
    private int year;
    private double GPA;
    public static int x = 0;
    public static BollesCourses[] mysched = new BollesCourses[7];

    /**
     *
     * @param name
     * @param ID
     * @param advisor
     * @param year
     * @param GPA
     */
    public Student(String name, String ID, String advisor, int year, double GPA){
        this.name = name;
        this.ID = ID;
        this.advisor = advisor;
        this.year = year;
        this.GPA = GPA;
    }

    /**
     *
     * @param course
     */
    public void addACourse(BollesCourses course){
        /**
         * @METHOD that gets the course and adds in an array
         **/
        mysched[course.getCoursePeriod()-1] = course;
    }

    /**
     *
     * @return String
     */
    public String toString(){
        /*method that formats the string and the array*/
        String str = String.format("%-30s","----- Victor's Information -----\n") + String.format("%-9s","Student:") + this.name + String.format("%-5s","\nID:") + this.ID +
                String.format("%-10s","\nAdvisor:") + this.advisor + String.format("%-7s","\nYear:") + this.year +
                String.format("%-6s","\nGPA:") + this.GPA + "\n----- Victor's Schedule   Num Courses: 7 -----\n";

        for(BollesCourses course: mysched){
            str += course + "\n";
        }
        return str;
    }
}

public class Main {
    public static void main(String[] args) {
        /* calling the class BollesCourses */
        BollesCourses course1 = new BollesCourses("ALGEBRA II AB", "Math", "Regular", 1);
        BollesCourses course2 = new BollesCourses("Study Hall", "SH", "", 3);
        BollesCourses course3 = new BollesCourses("PHYSICS", "Science", "Honors", 4);
        BollesCourses course4 = new BollesCourses("FRENCH II", "Language", "Regular", 5);
        BollesCourses course5 = new BollesCourses("ENG III AMERICAN LIT", "Literature", "Regular", 6);
        BollesCourses course6 = new BollesCourses("U S HISTORY", "History", "Regular", 7);
        BollesCourses course7 = new BollesCourses("COMPUTER SCI A AP", "CS", "AP", 2);

        Student victor = new Student("Victor", "99999 (don't remember)", "Ms. Boylan", 11, 3.9);

        victor.addACourse(course1);
        victor.addACourse(course2);
        victor.addACourse(course3);
        victor.addACourse(course4);
        victor.addACourse(course5);
        victor.addACourse(course6);
        victor.addACourse(course7);

        System.out.println(victor);

    }
}
