import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num;
        int length = 0;

        for (int i = 0; temp > 0; i++) {
            length++;
            temp = temp / 10;
        }
        temp = num;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            int digit = temp % 10;
            sum = sum + (int)Math.pow(digit, length);
            temp = temp / 10;
        }
        if (sum == num)
            System.out.println("Armstrong number");
        else
            System.out.println("Not an Armstrong number");
    }
}
