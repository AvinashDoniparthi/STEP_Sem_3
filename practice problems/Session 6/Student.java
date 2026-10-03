public class Student {
    private final String name;
    private final int attendance;
    public static final String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Asha", 90);
        new Student("Ravi", 85);
        Student.printCollegeInfo();
    }
}