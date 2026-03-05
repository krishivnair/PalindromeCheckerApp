package src;

import java.util.*;
public class PalindromeCheckerApp {
    public static boolean isPalindromeUC10(String input) {
    if (input == null) return false;

    // Step 1 & 2: Normalize (Lowercase and remove all non-alphanumeric characters)
    // \\s matches whitespace, \\p{Punct} matches punctuation
    // Alternatively, [^a-zA-Z0-9] matches everything NOT a letter or digit
    String cleanString = input.toLowerCase().replaceAll("[^a-z0-9]", "");

    // Step 3: Apply core logic (Two-pointer technique)
    int left = 0;
    int right = cleanString.length() - 1;

    while (left < right) {
        if (cleanString.charAt(left) != cleanString.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome? " + isPalindromeUC10(test)); // Output: true
    }
}