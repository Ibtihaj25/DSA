class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node to simplify handling of the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists, picking the smaller element at each step
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If one list is not exhausted, link the remaining elements
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the head of the merged list (dummy.next skips the dummy node)
        return dummy.next;
    }

    // Helper function to print the list (for testing purposes)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test case: Create two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merge lists and print the result
        ListNode mergedHead = mergeTwoLists(l1, l2);
        printList(mergedHead);  // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    }
}
