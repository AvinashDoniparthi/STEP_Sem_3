public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        if (combinationCode == null || combinationCode.isEmpty()) {
            throw new IllegalArgumentException("Combination code cannot be empty");
        }
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode) && newCode != null && !newCode.isEmpty()) {
            combinationCode = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("First change: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong-code change: " + locker.changeCode("0000", "9999"));
    }
}