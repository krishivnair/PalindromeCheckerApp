import java.util.*;

/**
 * UC12: PalindromeStrategy Interface
 * Defines the contract for all palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean isValid(String input);
}

/**
 * Strategy 1: StackStrategy (LIFO)
 * Uses a Stack to reverse the string for comparison.
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        if (input == null) return false;
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}

/**
 * Strategy 2: DequeStrategy (Double-Ended Queue)
 * More efficient: compares characters from both ends simultaneously.
 */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        if (input == null) return false;
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            // Remove from front and back and compare
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

/**
 * UC12: Context Class (The Main App)
 * Demonstrates Strategy Injection and Polymorphism.
 */
public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    // Method to set strategy at runtime (Polymorphism)
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String text) {
        if (strategy == null) {
            System.out.println("Strategy not set!");
            return false;
        }
        return strategy.isValid(text);
    }

    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern System ===");
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Select Algorithm: [1] Stack Strategy | [2] Deque Strategy");
        int choice = sc.nextInt();

        // Runtime Strategy Injection
        if (choice == 1) {
            app.setStrategy(new StackStrategy());
            System.out.println("Applying Stack Algorithm...");
        } else {
            app.setStrategy(new DequeStrategy());
            System.out.println("Applying Deque Algorithm...");
        }

        boolean result = app.executeCheck(text);
        System.out.println("Is Palindrome: " + result);

        sc.close();
    }
}