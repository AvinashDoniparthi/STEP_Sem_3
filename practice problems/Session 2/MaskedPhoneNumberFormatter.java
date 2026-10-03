public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int index = 0; index < phone.length(); index++) {
            if (!Character.isDigit(phone.charAt(index))) {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.append(phone.substring(6));
        maskedNumber.insert(6, '-');
        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}