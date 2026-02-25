import java.util.*;
public class PalindromeCheckerApp {
    static class ListNode {
        char val;
        ListNode next;
        ListNode(char x) {
            val = x;
        }
    }
    public static void main(String args[]) {
        System.out.println("Welcome to the Palindrome Checker App Management System");
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String cleanOriginal = original.replaceAll("\\s+", "").toLowerCase();
        if (cleanOriginal.length() == 0) {
            System.out.println(true);
            sc.close();
            return;
        }
        ListNode head = new ListNode(cleanOriginal.charAt(0));
        ListNode current = head;
        for (int i = 1; i < cleanOriginal.length(); i++) {
            current.next = new ListNode(cleanOriginal.charAt(i));
            current = current.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        boolean isPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        System.out.println(isPalindrome);
        sc.close();
    }
}