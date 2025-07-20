package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data1){
            this.data = data1;
        }

        Node(int data1, Node left1, Node right1){
            this.data = data1;
            this.left = left1;
            this.right = right1;
        }
    }

    public static Node fillTree(Integer[] nums){
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(nums[0]);
        queue.add(root);
        int i = 0;
        int n = nums.length;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (i < n && nums[i] != null) {
                temp.left = new Node(nums[i]);
                queue.add(temp.left);
            }
            i++;
            if (i < n && nums[i] != null) {
                temp.right = new Node(nums[i]);
                queue.add(temp.right);
            }
            i++;
        }
        return root;
    }

    public static Node searchBST(Node root, int target){
        if( root == null || root.data == target) return root;
        if(target < root.data){
            return searchBST(root.left, target);
        } else {
            return searchBST(root.right, target);
        }
    }

    public Node insertIntoBST(Node root, int val) {
        if(root == null) return new Node(val);
        if(val < root.data) {
            root.left = insertIntoBST(root.left, val);
        }
        if(val > root.data) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public int ceil(Node root, int key){
        int ceil = -1;
        while(root != null) {
            if(root.data == key) {
                ceil = root.data;
                return ceil;
            } else if (key > root.data) {
                root = root.right;
            } else if (key < root.data){
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public int floor(Node root, int key){
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            } else if (key < root.data){
                root = root.left;
            } else if (key > root.data) {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }

//    public int kthSmallestElement(Node root, int k){
//        return inorder(root, k);
//    }
//    private void inorder(Node node, int k){
//        int count = 0;
//        int result = -1;
//        inorder(node.left, k);
//        count++;
//        if(count == k){
//            result =  node.data;
//            return result;
//        }
//        inorder(node.right, k);
//    }
    
    public boolean isValidBST(Node root){
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(Node node, long min, long max){
        if(node == null) return true;
        if(node.data <= min || node.data >= max) return false;
        return isValid(node.left, min, node.data) && isValid(node.right, min, node.data);
    }



    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 6, 7};
        Node root = fillTree(nums);

    }
}
