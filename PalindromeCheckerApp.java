import java.util.*;

/**
 * UC13: Performance Comparison using Strategy Pattern
 */
interface PalindromeStrategy {
    boolean isValid(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder rev = new StringBuilder();
        while (!stack.isEmpty()) rev.append(stack.pop());
        return clean.equals(rev.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) deque.add(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== UC13: Performance Benchmarking ===");
        System.out.print("Enter text to test: ");
        String text = sc.nextLine();

        PalindromeStrategy stack = new StackStrategy();
        PalindromeStrategy deque = new DequeStrategy();

        // Benchmark Stack
        long startStack = System.nanoTime();
        stack.isValid(text);
        long endStack = System.nanoTime() - startStack;

        // Benchmark Deque
        long startDeque = System.nanoTime();
        deque.isValid(text);
        long endDeque = System.nanoTime() - startDeque;

        System.out.println("\n--- Performance Results ---");
        System.out.println("Stack Strategy: " + endStack + " ns");
        System.out.println("Deque Strategy: " + endDeque + " ns");
        System.out.println("Efficiency Gain: " + (Math.abs(endStack - endDeque)) + " ns");

        sc.close();
    }
}