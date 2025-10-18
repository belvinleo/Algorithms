package BinaryTrees;

import java.util.*;

public class MediumProblems {
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

    //maximum height of the tree
    public static int maxDepth(Node root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //check balanced tree
    public boolean isBalanced(Node root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //diameter of a binary tree
    private static int diameter = 0;

    private static int maxDiameter(Node root){
        dfs1(root);
        return diameter;
    }

    public static int dfs1(Node node){
        if (node == null) return 0;
        int lh = dfs1(node.left);
        int rh = dfs1(node.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    //maximum path sum of a tree
    private static int maxSum = 0;

    public static int maxPathSum(Node root){
        maxSum = Integer.MIN_VALUE;
        dfs2(root);
        return maxSum;
    }

    private static int dfs2(Node node){
        if (node == null) return 0;

        int leftGain = dfs2(node.left);
        int rightGain = dfs2(node.right);

        int pathThrough = node.data + leftGain + rightGain;
        if (pathThrough > maxSum) maxSum = pathThrough;

        return node.data + Math.max(leftGain, rightGain);
    }

    //check for same tree
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.data != q.data) return false;
        boolean a = isSameTree(p.left, q.left);
        boolean b = isSameTree(p.right, q.right);
        return (a && b);
    }

    //zigzag level order
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                if(count % 2 == 0){
                    if(temp.left != null) queue.add(temp.left);
                    if(temp.right != null) queue.add(temp.right);
                    level.add(temp.data);
                } else if (count % 2 == 1) {
                    if(temp.right != null) queue.add(temp.right);
                    if(temp.left != null) queue.add(temp.left);
                    level.add(temp.data);
                }
            }
            result.add(level);
            count++;
        }
        return result;
    }

    //Boundary traversal
    public static List<Integer> boundaryTraversal(Node root){
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;
        if (!isLeaf(root)) result.add(root.data);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);

        return result;
    }

    private static boolean isLeaf(Node node){
        return (node != null && node.right == null && node.left == null);
    }

    public static void addLeftBoundary(Node node, List<Integer> result){
        while (node != null){
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    public static void addLeaves(Node node, List<Integer> result){
        if (node == null) return;
        if (isLeaf(node)){
            result.add(node.data);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    public static void addRightBoundary(Node node, List<Integer> result){
        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) result.add(stack.pop());
    }

    //check symmetry
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.data == t2.data)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    //main
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        Node root = fillTree(nums);
        int ans = maxDepth(root);
        System.out.print(ans);
    }
}
