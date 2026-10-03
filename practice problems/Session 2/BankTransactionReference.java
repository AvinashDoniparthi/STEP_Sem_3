public class BankTransactionReference {
    public static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() < 3) {
            return reference.toUpperCase();
        }
        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }
        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append('[').append(reference, 0, 3).append("] DATE: ")
                .append(reference, 3, 5).append('/')
                .append(reference, 5, 7).append('/')
                .append(reference, 7, 9).append(" | SEQ: ")
                .append(reference, 9, 14);
        return formatted.toString();
    }

    public static void main(String[] args) {
        String valid = normalizeReference(" hdf03022600042 ");
        String invalid = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(valid));
        System.out.println(validateAndFormat(invalid));
    }
}