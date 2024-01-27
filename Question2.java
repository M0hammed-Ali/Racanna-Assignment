import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNode {
    public static void deleteNode(Node n) {
        if (n == null || n.next == null) {
            // Cannot delete the last node or null node.
            return;
        }

        Node nextNode = n.next;
        n.data = nextNode.data;
        n.next = nextNode.next;
        nextNode = null; // Optional: Free up the memory occupied by the next node.
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the linked list:");
        int n = scanner.nextInt();

        System.out.println("Enter the values of the nodes:");
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Original List:");
        printList(head);

        System.out.println("Enter the node value to delete:");
        int valueToDelete = scanner.nextInt();

        Node current = head;
        Node nodeToDelete = null;

        // Find the node to delete
        while (current != null && current.data != valueToDelete) {
            current = current.next;
        }

        if (current != null) {
            nodeToDelete = current;
        } else {
            System.out.println("Node not found in the list.");
            return;
        }

        // Delete the node
        deleteNode(nodeToDelete);

        System.out.println("List after deleting the node:");
        printList(head);
    }
}

/*
 
Corner cases to consider:

Deleting the last node in the list.
Deleting a null node.


Complexity of the algorithm:

Time Complexity: O(1) since we are copying data and updating pointers.
Space Complexity: O(1) since no extra space is used.

 */