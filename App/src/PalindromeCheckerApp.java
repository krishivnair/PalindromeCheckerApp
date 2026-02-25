import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String to check: ");
        String str = sc.nextLine();
        boolean flag=true;
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            char ch1 = str.charAt(start);
            char ch2 = str.charAt(end);
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                flag=false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(flag);
    }
}