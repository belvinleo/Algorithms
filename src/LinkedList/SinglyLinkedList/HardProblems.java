package LinkedList.SinglyLinkedList;

public class HardProblems {
    static class Node{
        int data;
        Node next;
        Node child;
        Node random;

        Node(int data1){
            this.data = data1;
            this.next = null;
        }
        Node(int data1, Node next1){
            this.data = data1;
            this.next = next1;
        }

        Node (int data1, Node next1, Node child1, Node random){
            this.data = data1;
            this.next = next1;
            this.child = child1;
            this.random = random;
        }
    }

    //reverse a LL in group with K size
    public static Node reverseKgroup(Node head, int k){
        if(head == null || k <= 1){
            return head;
        }

        Node dummy = new Node(0, head);

        Node prev = dummy;
        Node curr = head;

        while (curr != null){
            Node tail = curr;
            int count = 0;

            while (tail != null && count < k){
                tail = tail.next;
                count++;
            }
            if(count == k){
                Node reverseHead = reverseLL(curr, k);

                prev.next = reverseHead;
                curr.next = tail;

                prev = curr;
                curr = tail;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static Node reverseLL(Node head, int k){
        Node prev = null;
        Node curr = head;
        for(int i = 0; i < k; i++){
            Node mover = curr.next;
            curr.next = prev;
            prev = curr;
            curr = mover;
        }
        return prev;
    }

    //rotate a LL
    public static Node rotateLL(Node head, int k){
        int length = 1;
        Node mover = head;
        Node dummy = new Node(0, head);
        while (mover.next != null){
            mover = mover.next;
            length++;
        }

        k = k % length;
        if(k == 0){
            return head;
        }

        int count = 1;
        Node temp = head;
        while (count < length - k){
            temp = temp.next;
            count++;
        }

        Node temp2 = temp.next;
        mover.next = dummy.next;
        dummy.next = temp2;
        temp.next = null;
        return dummy.next;
    }

    //flattening LL
    public static Node flatten(Node head){
        if ((head == null || head.next == null)) return head;
        head.next = flatten(head.next);
        return merge(head, head.next);
    }

    public static Node merge(Node a, Node b){
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (a != null && b != null){
            if(a.data <= b.data){
                tail.child = a;
                a = a.child;
            } else {
                tail.child = b;
                b = b.child;
            }
            tail = tail.child;
            tail.next = null;
        }
        tail.child = (a != null) ? a : b;
        return dummy.next;
    }

    //cloning a LL
    public static Node cloningLL(Node head){
        if (head == null) return head;

        Node curr = head;
        while (curr != null){
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null){
            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        curr = head;
        while (curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            curr = curr.next;
        }
        return newHead;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = convertToLL(arr);
        Node ans = rotateLL(head, 2);
        //traversal(ans);

        //flattening LL
        Node Fhead = new Node(3);
        Fhead.child = null;

        Fhead.next = new Node(2);
        Fhead.next.child = new Node(10);
        Fhead.next.child.next = null;

        Fhead.next.next = new Node(1);
        Fhead.next.next.child = new Node(7);
        Fhead.next.next.child.next = new Node(11);
        Fhead.next.next.child.next.next = new Node(12);
        Fhead.next.next.child.next.next.next = null;

        Fhead.next.next.next = new Node(4);
        Fhead.next.next.next.child = new Node(9);
        Fhead.next.next.next.child.next = null;

        Fhead.next.next.next.next = new Node(5);
        Fhead.next.next.next.next.child = new Node(6);
        Fhead.next.next.next.next.child.next = new Node(8);
        Fhead.next.next.next.next.child.next.next = null;

        Fhead.next.next.next.next.next = null;

        Node ans1 = flatten(Fhead);
        traversal(Fhead);
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

    public static void traversal(Node head){
        Node mover = head;
        while(mover != null){
            System.out.print(mover.data + " ");
            mover = mover.next;
        }
    }
}
