import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int origNumber = num;
		int reversed = 0;

		while (num != 0) {
			reversed = reversed * 10 + num % 10;
			num /= 10;
		}

		System.out.println(origNumber == reversed ? "Palindrome" : "Not a palindrome");
		sc.close();
	}
}
