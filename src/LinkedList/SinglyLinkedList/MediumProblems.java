package LinkedList.SinglyLinkedList;

public class MediumProblems {
    static class Node{
        int data;
        Node next;

        Node(int data1){
            this.data = data1;
            this.next = null;
        }

        Node(int data1, Node next1){
            this.data = data1;
            this.next = next1;
        }
    }

    //middle element of the LL
    public static Node middleOfLL(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //reverse a LL
    public static Node reverseLL(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null){
            Node mover = curr.next;
            curr.next = prev;
            prev = curr;
            curr = mover;
        }
        return prev;
    }

    //detect loop
    public static boolean detectLoop(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //find entry point
    public static Node entryPoint(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        Node ptr = head;
        while (ptr != slow){
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }

    //palindrome LL using floyd two pointers approach
    public static boolean palindromeCheck1(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow;
        while(curr != null){
            Node mover = curr.next;
            curr.next = prev;
            prev = curr;
            curr = mover;
        }

        Node first = head;
        Node second = prev;
        while(first != second){
            if(second != null){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    //segregating odd even LL
    public static Node oddEvenList(Node head){
        Node oddhead = head;
        Node evenhead = head.next;
        Node oddpt = oddhead;
        Node evenpt = evenhead;
        while (evenpt != null && evenpt.next != null){
            oddpt.next = evenpt.next;
            oddpt = oddpt.next;
            evenpt.next = oddpt.next;
            evenpt = evenpt.next;
        }
        oddpt.next = evenhead;
        return oddhead;
    }

    //removing nth node from the end
    public static Node removeNthFromEnd(Node head, int n){
        if(head.next == null){
            return null;
        }
        Node temp = new Node(0);
        temp.next = head;
        Node fast = temp;
        Node slow = temp;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }

    //Delete the middle node
    public static Node deleteMiddleNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    //sort LL
    public static Node sortList(Node head){
        if (head == null || head.next == null) return head;

        // 1) Split into halves using slow/fast
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;

        // 2) Sort both halves
        Node left = sortList(head);
        Node right = sortList(mid);

        // 3) Merge sorted halves
        return merge(left, right);
    }

    public static Node merge(Node a, Node b){
        Node dummy = new Node(-1);
        Node tail = dummy.next;
        while (a != null && b != null){
            if (a.data <= b.data){
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (tail.next != null) ? a : b;
        return dummy.next;
    }

    //intersect of LL
    public static Node intersectionNode(Node headA, Node headB){
        Node ptrA = headA;
        Node ptrB = headB;
        while(ptrA != ptrB){
            if(ptrA == null) {
                ptrA = headB;
            } else {
                ptrA = ptrA.next;
            }
            if(ptrB == null){
                ptrB = headA;
            } else {
                ptrB = ptrB.next;
            }
        }
        return ptrA;
    }

    //plus one
    public static Node plus1(Node head){
        Node dummy = new Node(0);
        dummy.next = head;

        Node notNine = dummy;
        Node curr = head;

        while (curr != null){
            if(curr.data != 9){
                notNine = curr;
            }
            curr = curr.next;
        }
        notNine.data++;
        curr = notNine.next;

        while (curr != null){
            curr.data = 0;
            curr = curr.next;
        }
        return (dummy.data == 1) ? dummy : dummy.next;
    }


    //add two numbers
    public static Node addTwoNumbers(Node l1, Node l2){
        Node head = new Node(0);
        Node mover = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }

            mover.next = new Node(sum % 10);
            carry = sum / 10;
            mover = mover.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertToLL(arr);

        //System.out.print(middleOfLL(head).data);

        //reverse
        Node ans = reverseLL(head);
        traversal(ans);

        //loop
        Node head1 = convertTocyclicLL(arr);
        System.out.print(detectLoop(head1));
        System.out.println();
        System.out.print(entryPoint(head1));

        System.out.print(oddEvenList(head));
    }

    public static Node convertToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node convertTocyclicLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        mover.next = head.next.next.next;
        return head;
    }

    public static void traversal(Node head){
        Node mover = head;
        while(mover != null){
            System.out.print(mover.data + " ");
            mover = mover.next;
        }
    }
}
