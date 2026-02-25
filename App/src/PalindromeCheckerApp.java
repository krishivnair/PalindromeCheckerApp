import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String to check for Palindrome: ");
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";
        for (int i = cleanOriginal.length() - 1; i >= 0; i--) {
            reversed += cleanOriginal.charAt(i);
        }
        boolean isPalindrome = cleanOriginal.equals(reversed);
        System.out.println(isPalindrome);
        sc.close();
    }
}