import java.util.*;
public class PalindromeCheckerApp {
    static boolean checkPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return checkPalindrome(str, start + 1, end - 1);
    }
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        boolean isPalindrome = true;
        if (cleanOriginal.length() > 0) {
            isPalindrome = checkPalindrome(cleanOriginal, 0, cleanOriginal.length() - 1);
        }
        System.out.println(isPalindrome);
        sc.close();
    }
}