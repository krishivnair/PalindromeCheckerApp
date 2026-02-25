import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < cleanOriginal.length(); i++) {
            deque.addLast(cleanOriginal.charAt(i));
        }
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
        sc.close();
    }
}