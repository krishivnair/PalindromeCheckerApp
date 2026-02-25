import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cleanOriginal.length(); i++) {
            stack.push(cleanOriginal.charAt(i));
        }
        boolean isPalindrome = true;
        for (int i = 0; i < cleanOriginal.length(); i++) {
            if (stack.pop() != cleanOriginal.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
        sc.close();
    }
}