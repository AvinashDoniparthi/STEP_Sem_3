public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        presentStudents = new String[capacity];
    }

    public boolean markPresent(String name) {
        if (name == null || name.isBlank() || isPresent(name) || presentCount == presentStudents.length) {
            return false;
        }
        presentStudents[presentCount++] = name;
        return true;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}