package encapsulation.assigment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be positive");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - Math.max(0, amount));
    }

    public void heal(int amount) {
        long restoredHealth = (long) health + Math.max(0, amount);
        health = (int) Math.min(maxHealth, restoredHealth);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("Health after damage: " + character.getHealth());
        character.heal(50);
        System.out.println("Health after healing: " + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health after excess damage: " + character.getHealth());
    }
}