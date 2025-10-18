package BinaryTrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTrees {

    static class Node {
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
        int n = nums.length;
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < n){
            Node current = queue.poll();
            if (i < n && nums[i] != null) {
                current.left = new Node(nums[i]);
                queue.add(current.left);
            }
            i++;

            if (i < n && nums[i] != null) {
                current.right = new Node(nums[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> preOrderTraversal(Node root){
        List<Integer> result = new ArrayList<>();
        preOrder(result, root);
        return result;
    }

    private static void preOrder(List<Integer> result, Node node){
        if (node == null) return;

        result.add(node.data);
        preOrder(result, node.left);
        preOrder(result, node.right);
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrder(result, root);
        return result;
    }

    private void inOrder(List<Integer> result, Node node){
        if(node == null) return;

        inOrder(result, node.left);
        result.add(node.data);
        inOrder(result, node.right);
    }

    public List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }

    private void postOrder(List<Integer> result, Node node){
        if(node == null) return;
        postOrder(result, node.left);
        postOrder(result, node.right);
        result.add(node.data);
    }

    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return result;;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                level.add(temp.data);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            result.add(level);
        }
        return result;
    }





    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        Node ans = fillTree(root);

    }
}
