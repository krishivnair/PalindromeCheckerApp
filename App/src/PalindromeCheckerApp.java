package src;

import java.util.*;

public class PalindromeCheckerApp {

    /**
     * UC10: Case-Insensitive & Space-Ignored Palindrome Checker
     * Uses Regular Expressions for normalization and Two-Pointer technique for efficiency.
     */
    public static boolean isPalindromeUC10(String input) {
        if (input == null) return false;

        // Step 1 & 2: Normalize
        // .toLowerCase() handles case-insensitivity
        // .replaceAll("[^a-z0-9]", "") removes everything except letters and numbers
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        // If the string is empty after cleaning, it's technically a palindrome
        if (normalized.isEmpty()) return true;

        // Step 3: Apply core logic (Two-pointer technique)
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Complex phrase with spaces and punctuation
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Test 1 ('" + test1 + "'): " + isPalindromeUC10(test1));

        // Test Case 2: Simple word with different cases
        String test2 = "RaceCar";
        System.out.println("Test 2 ('" + test2 + "'): " + isPalindromeUC10(test2));

        // Test Case 3: Not a palindrome
        String test3 = "Hello World";
        System.out.println("Test 3 ('" + test3 + "'): " + isPalindromeUC10(test3));

        // Test Case 4: Numbers and symbols
        String test4 = "12321!!!";
        System.out.println("Test 4 ('" + test4 + "'): " + isPalindromeUC10(test4));
    }
}