package LinkedList.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data1, Node prev1, Node next1){
            this.data = data1;
            this.prev = prev1;
            this.next = next1;
        }

        Node(int data1){
            this.data = data1;
            this.prev = null;
            this.next = null;
        }
    }

    //Convert to Double Linked List
    public static Node convert2array(int[] arr){
        Node head = new Node(arr[0], null, null);
        Node mover = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            temp.prev = mover;
            mover = temp;
        }
        return head;
    }

    //Traversal of a Double Linked List
    public static void Traversal(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Length of a Double Linked List
    public static int Length(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Insert a node at the tail
    public static Node insertAtTail(Node head, int num){
        Node temp = new Node(num, null, null);
        Node mover = head;
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
    public static Node deleteNode(Node head){
        Node mover = head;
        while(mover != null){
            if(mover.next.next == null){
                mover.next = null;
            }
            mover = mover.next;
        }
        return head;
    }

    //Reverse a Double LinkedList
    public static Node reverse(Node head){
        Node curr = head;
        Node temp = null;
        while (curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if(temp != null){
            head = temp.prev;
        }
        return head;
    }

    //delete all the occurences of key
    public static Node deleteOccurences(Node head, int target){
        Node temp = head;
        Node mover = temp.next;
        while (mover != null){
            if(mover.data == target){
                mover = mover.next;
                temp.next = mover;
                mover.prev = temp;
            }
            temp = temp.next;
            mover = mover.next;
        }
        return head;
    }

    //Find Pairs with Given Sum in Doubly Linked List
    public static List<List<Integer>> findPairs(Node head, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (head == null) return result;

        Node right = head;
        while(right.next != null){
            right = right.next;
        }

        Node left = head;

        while (left != null && right != null && left != right && left.prev != right){
            int sum = left.data + right.data;
            if (sum == target){
                List<Integer> pair = new ArrayList<>(2);
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);

                left = left.next;
                right = right.prev;
            }
            if (sum > target){
                right = right.prev;
            }
            if (sum < target){
                left = left.next;
            }
        }
        return result;
    }

    //remove duplicates from DLL
    public static Node removeDuplicates(Node head){
        if(head == null) return head;
        Node curr = head;
        while (curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                Node dup = curr.next;
                curr.next = dup.next;
                if (dup.next != null){
                    dup.next.prev = curr;
                }
                dup.prev = dup.next = null;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 4};
        Node head = convert2array(arr);
        Node ans = removeDuplicates(head);
//        List<List<Integer>> ans = findPairs(head, 7);
//        for (int i = 0; i < ans.size(); i++){
//            System.out.print(ans.get(i));
//        }
        Traversal(head);

    }
}
