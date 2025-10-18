package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class HardProblems {
    class Node{
        int data;
        Node left;
        Node right;

        Node (int data1){
            this.data = data1;
        }

        Node (int data1, Node left1, Node right1){
            this.data = data1;
            this.left = left1;
            this.right = right1;
        }
    }

    //root to node path
    public static List<List<Integer>> path(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> path = new ArrayList<>();
        dfs(root, result, path);
        return result;
    }

    public static void dfs(Node node, List<List<Integer>> result, List<Integer> path){
        if (node == null) return;

        path.add(node.data);
        if (node.left == null && node.right == null){
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, result, path);
            dfs(node.right, result, path);
        }
        path.remove(path.size() - 1);
    }

    //LCA of a binary tree
    public static Node LCA(Node root, Node p, Node q){
        if (root == null || root == p || root == q) return root; // Wikipedia allows node as its own descendant
        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);
        if (left != null && right != null) return root;           // p and q found in different subtrees
        return left != null ? left : right;
    }

    //check sum of the children nodes
    public boolean childrenSum(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int L = root.left != null ? root.left.data : 0;
        int R = root.right != null ? root.right.data : 0;
        return root.data == L + R
                && childrenSum(root.left)
                && childrenSum(root.right);
    }

    //requirement for unique BT
    public boolean canConstructUniqueTree(int traversal1, int traversal2) {
        return traversal1 == 2 || traversal2 == 2;
    }

    //Morris preorder traversal
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    result.add(current.data);

                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        return result;
    }

    //Morris inorder traversal
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    result.add(current.data);
                    current = current.right;
                }
            }
        }

        return result;
    }

    //flattening a binary tree
    private Node prev = null;

    public void flatten(Node root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //main
    public static void main(String[] args) {

    }
}
