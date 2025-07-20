package LinkedList.DoublyLinkedList;

class DNode{
    int data;
    DNode prev;
    DNode next;

    DNode(int data1, DNode prev1, DNode next1){
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    DNode(int data1){
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    //Convert to Double Linked List
    public static DNode convert2array(int[] arr){
        DNode head = new DNode(arr[0], null, null);
        DNode mover = head;
        for(int i = 1; i < arr.length; i++){
            DNode temp = new DNode(arr[i]);
            mover.next = temp;
            temp.prev = mover;
            mover = mover.next;
        }
        return head;
    }

    //Traversal of a Double Linked List
    public static void Traversal(DNode head){
        DNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Length of a Double Linked List
    public static int Length(DNode head){
        DNode temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Insert a node at the tail
    public static DNode insertAtTail(DNode head, int num){
        DNode temp = new DNode(num, null, null);
        DNode mover = head;
        while(mover != null){
            if(mover.next == null){
                mover.next = temp;
                temp.prev = mover;
                break;
            }
            mover = mover.next;
        }
        return head;
    }

    //Delete a node
    public static DNode deleteNode(DNode head){
        DNode mover = head;
        while(mover != null){
            if(mover.next.next == null){
                mover.next = null;
            }
            mover = mover.next;
        }
        return head;
    }

    //Reverse a Double LinkedList


    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        DNode head = convert2array(arr);
        Traversal(head);
    }
}
