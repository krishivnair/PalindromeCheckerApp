import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        char[] charArray = cleanOriginal.toCharArray();
        boolean isPalindrome = true;
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(isPalindrome);
        sc.close();
    }
}