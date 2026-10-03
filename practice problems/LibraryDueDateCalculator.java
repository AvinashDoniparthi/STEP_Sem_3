import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LibraryDueDateCalculator {
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

    private abstract static class LibraryItem {
        private final String title;

        private LibraryItem(String title) {
            this.title = title;
        }

        abstract int loanDays();

        LocalDate dueDate() {
            return CURRENT_DATE.plusDays(loanDays());
        }
    }

    private static final class Book extends LibraryItem {
        private Book(String title) {
            super(title);
        }

        @Override
        int loanDays() {
            return 14;
        }
    }

    private static final class Dvd extends LibraryItem {
        private Dvd(String title) {
            super(title);
        }

        @Override
        int loanDays() {
            return 7;
        }
    }

    private static final class Magazine extends LibraryItem {
        private Magazine(String title) {
            super(title);
        }

        @Override
        int loanDays() {
            return 3;
        }
    }

    private static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) throws Exception {
        Week9Input input = Week9Input.read();
        int itemCount = input.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int index = 0; index < itemCount; index++) {
            String type = input.next().toUpperCase(Locale.ROOT);
            items.add(createItem(type, input.next()));
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate().format(DATE_FORMAT));
        }
    }
}