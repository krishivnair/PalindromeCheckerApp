package src;

import java.util.*;

/**
 * UC11: Palindrome Checker App
 * This class encapsulates the logic using OOPS principles.
 */
public class PalindromeCheckerApp {

    /**
     * Service Method: checkPalindrome
     * Uses a Stack (LIFO) and a Queue (FIFO) to check for symmetry.
     */
    public boolean checkPalindrome(String input) {
        // Handle null or empty cases
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        // 1. Normalization: Remove all non-alphanumeric characters and lowercase
        String cleanStr = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 2. Data Structures: Stack (Last-In-First-Out) and Queue (First-In-First-Out)
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // 3. Populate both structures
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);   // Reverses the string
            queue.add(c);    // Maintains original order
        }

        // 4. Comparison Logic
        while (!stack.isEmpty()) {
            // Comparing the character from the end (Stack) with the character from the start (Queue)
            if (!stack.pop().equals(queue.remove())) {
                return false; // Not a palindrome
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        // Create an instance of the class (Object-Oriented Approach)
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App: UC11 (OOPS) ===");
        System.out.print("Enter text to validate: ");

        if (sc.hasNextLine()) {
            String userInput = sc.nextLine();

            // Calling the service method
            boolean result = app.checkPalindrome(userInput);

            // Display results
            System.out.println("\nAnalyzing: \"" + userInput + "\"");
            if (result) {
                System.out.println("SUCCESS: This is a valid palindrome.");
            } else {
                System.out.println("FAILURE: This is NOT a palindrome.");
            }
        }

        sc.close();
    }
}