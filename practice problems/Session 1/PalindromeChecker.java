public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return text != null && isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        return left >= right || (text.charAt(left) == text.charAt(right)
                && isPalindromeRecursive(text, left + 1, right - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int index = 0; index < original.length; index++) {
            reversed[index] = original[original.length - 1 - index];
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        String text = args.length == 0 ? "madam" : String.join(" ", args);
        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text));
        System.out.println("Array reversal: " + isPalindromeArrayReversal(text));
    }
}