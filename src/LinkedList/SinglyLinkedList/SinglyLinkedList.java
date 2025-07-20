package LinkedList.SinglyLinkedList;

public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data1, Node next1){
            this.data = data1;
            this.next = next1;
        }

        Node(int data1){
            this.data = data1;
            this.next = null;
        }
    }

    //Convert Array to LinkedList
    public Node Convert2Array(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Traversing a LinkedList
    public static void Traversal(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Calculating length of a LinkedList
    public static int Length(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Searching in a LinkedList
    public static int Search(Node head, int target){
        Node temp = head;
        while(temp != null){
            if(temp.data == target) return 1;
            temp = temp.next;
        }
        return -1;
    }

    //Delete head of the LinkedList
    public static Node Deletehead(Node head){
        if(head == null) return null;
        head = head.next;
        return head;
    }

    //Delete tail of the LinkedList
    public static Node DeleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    //Delete Kth element of a LinkedList
    public static Node DeleteK(Node head, int k){
        if(head == null) return null;
        if(k==1){
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //Delete element of a LinkedList
    public static Node DeleteElement(Node head, int num){
        if(head == null) return null;
        if(head.data == num){
            head = head.next;
            return head;
        }
        Node prev = null;
        Node temp = head;
        while (temp != null){
            if(temp.data == num){
                prev.next = prev.next.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //Insert a element to the head of a LinkedList
    public Node insertAtHead(Node head, int num){
        Node temp = new Node(num, head);
        head = temp;
        return head;
    }

    //Insert a element to the tail of a LinkedList
    public Node insertAtTail(Node head, int num){
        Node temp = new Node(num, null);
        Node mover = head;
        while(mover != null){
            if(mover.next == null){
                mover.next = temp;
                break;
            }
            mover = mover.next;
        }
        return head;
    }

    //Insert at the Kth position of a LinkedList
    public Node insertAtPosition(Node head, int num, int k){
        Node temp = new Node(num, null);
        Node mover = head;
        int count = 0;
        while(mover != null){
            count++;
            if(count + 1 == k){
                Node temp2 = mover.next;
                mover.next = temp;
                temp.next = temp2;
            }
            mover = mover.next;
        }
        return head;
    }

    //Medium Problems
    public static Node middleNode(Node head){
        //length of the LL
        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        int mid = count/2;
        temp = head;
        for(int i = 0; i < mid; i++){
            temp = temp.next;
        }
        return temp;
    }

    //Reverse a LinkedList
    public static Node reverse(Node head){
        Node prev = null;
        Node temp = head;
        while(temp != null){
            Node mover = temp.next;
            temp.next = prev;
            prev =  temp;
            temp = mover;
        }
        return prev;
    }

    //To check if loop exist in a LL
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    //Returning the starting node of the loop
    public static Node detectCycle(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 10};
        Node head = Convert2Array(arr);
        Traversal(head);
        Node head2 = middleNode(head);
        Traversal(head2);
    }
}
