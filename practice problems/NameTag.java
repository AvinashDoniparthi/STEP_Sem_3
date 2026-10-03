public final class NameTag {
    private final String firstName;
    private final char lastInitial;

    public NameTag(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        String[] parts = fullName.split(" ", -1);
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Name must contain a first and last name");
        }
        firstName = parts[0];
        lastInitial = parts[1].charAt(0);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        System.out.println(new NameTag("Maria Gomez").getNickname());
    }
}