public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be blank");
        }
        this.id = id;
        this.savings = 0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }
        savings += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("PB-1");
        bank.deposit(100);
        bank.withdraw(30);
        bank.withdraw(500);
        System.out.printf("%s savings: %.2f%n", bank.getId(), bank.getSavings());
    }
}