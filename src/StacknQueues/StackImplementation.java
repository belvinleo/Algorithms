package StacknQueues;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

class StackUsingArrays{
    int top = -1;
    int capacity = 10;
    int[] st = new int[capacity];

    void push(int x){
        if(top == capacity - 1) System.out.print("stack overflow");
        top++;
        st[top] = x;
    }

    int top(){
        if(top == -1){
            System.out.print("stack underflow");
            return 0;
        } else {
            return st[top];
        }
    }

    void pop(){
        if(top == -1) System.out.print("stack underflow");
        top = top - 1;
    }

    int size(){
        return top+1;
    }

}

class StackUsingLL {
    private class Node{
        int data;
        Node next;
    }

    private Node top = null;

    void push(int x){
        Node temp = new Node();
        temp.data = x;
        temp.next = top;
        top = temp;
    }

    void pop(){
        if (top == null) System.out.print("underflow");
        top = top.next;
    }

    int peek(){
        if (top == null) System.out.print("underflow");
        return top.data;
    }
}

class StackProblems {

    //check Valid parenthesis
    public static boolean validParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']'){
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && ch != ')' || top == '{' && ch != '}' || top == '[' && ch != ']') return false;
            }
        }
        return true;
    }

    //implement stack operations with O(1) time complexity - get minimum element
    private class MinStack{
        Stack<Integer> mainstack;
        Stack<Integer> minstack;

        public MinStack(){
            mainstack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int x){
            mainstack.push(x);
            if(minstack.isEmpty() || x <= minstack.peek()){
                minstack.push(x);
            }
        }

        public void pop(){
            if(mainstack.isEmpty()) return;
            int popped = mainstack.pop();
            if(popped == minstack.peek()){
                minstack.peek();
            }
        }

        public int top() {
            return mainstack.peek();
        }

        public int getMin() {
            return minstack.peek();
        }
    }

    //Next greater integer
    public static int[] nextGreaterElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return nge;
    }

    public static int[] nextGreaterElementI(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> NGE = new HashMap<>();
        int[] ans = new int[nums1.length];
        for(int i = nums2.length - 1; i >=0 ; i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()) {
                NGE.put(nums2[i], -1);
            } else {
                NGE.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for(int j = 0; j < nums1.length; j++){
            ans[j] = NGE.get(nums1[j]);
        }
        return ans;
    }

    public static int[] nextGreaterElementII(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for(int i = 2 * n - 1; i >= 0; i--){
            int index = i % n;
            while (!stack.isEmpty() && nums[index] >= stack.peek()){
                stack.pop();
            }
            if (i < n) {
                nge[index] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[index]);
        }
        return nge;
    }
}

class Conversions{
    public static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String InfixtoPostfix(String s){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    ans.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static String InfixtoPrefix(String s){
        //reverse string
        StringBuilder rs = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if (ch == '('){
                rs.append(')');
            } else if (ch == ')') {
                rs.append('(');
            } else {
                rs.append(ch);
            }
        }
        String str = rs.toString();

        //now to postfix
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            } else if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }

        //reverse the answer
        StringBuilder ans2 = new StringBuilder();
        for (int i = ans.length() - 1; i >= 0; i--){
            ans2.append(ans.charAt(i));
        }
        return ans2.toString();
    }

    public static String PostfixtoInfix(String s){
        Stack<String> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String exp = "(" + op1 + ch + op2 + ")";
                stack.push(exp);
            }
        }
        return stack.peek();
    }

    public static String PostfixToPrefix(String s){
        Stack<String> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String exp = ch + op1 + op2;
                stack.push(exp);
            }
        }
        return stack.peek();
    }

    public static String PrefixtoInfix(String s){
        Stack<String> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = "(" + op1 + ch + op2 + ")";
                stack.push(exp);
            }
        }
        return stack.peek();
    }

    public static String PrefixtoPostfix(String s){
        Stack<String> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = op1 + op2 + ch;
                stack.push(exp);
            }
        }
        return stack.peek();
    }
}



public class StackImplementation {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 3};
//        int[] ans = StackProblems.nextGreaterElementII(nums);
//        for (int i = 0; i < ans.length; i++){
//            System.out.print(ans[i] + " ");
//        }
//        String s = "a+b*(c^d-e)^(f+g*h)-i";
//        String ans = Conversions.InfixtoPrefix(s);

        String ans = Conversions.PrefixtoPostfix("*+ab-cd");
        System.out.print(ans);
    }
}
