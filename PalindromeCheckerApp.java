package src;

import java.util.*;

/**
 * UC11: Palindrome Checker App
 * This single class handles both the User Interface and the Palindrome Logic.
 */
public class PalindromeCheckerApp {

    /**
     * UC11 Service Method: checkPalindrome
     * Encapsulates the logic using Stack (LIFO) and Queue (FIFO) data structures.
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        // Step 1: Normalize (Lowercase and remove whitespace)
        String cleanStr = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Data Structures
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Step 3: Fill structures
        // Stack reverses the order, Queue keeps the original order
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Step 4: Compare
        while (!stack.isEmpty()) {
            // Character by character comparison (Backwards vs Forwards)
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create an instance of the class to access the non-static method (OOPS)
        PalindromeCheckerApp app = new PalindromeCheckerApp();

        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to the Palindrome Checker App (UC11) ---");

        System.out.print("Enter text to check: ");
        String userInput = sc.nextLine();

        // Calling the encapsulated logic
        boolean result = app.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }

        sc.close();
    }
}