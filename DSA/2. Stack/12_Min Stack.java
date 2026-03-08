import java.util.Stack;

/*
    Problem Link: https://leetcode.com/problems/min-stack/

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    Implement the MinStack class:

    - MinStack() initializes the stack object.
    - void push(int val) pushes the element val onto the stack.
    - void pop() removes the element on the top of the stack.
    - int top() gets the top element of the stack.
    - int getMin() retrieves the minimum element in the stack.
    
    You must implement a solution with O(1) time complexity for each function.
*/

class Pair<K,V> {
    public K a;
    public V b;

    public Pair(K a, V b) {
        this.a=a;
        this.b=b;
    }
}

class MinStack {
    private Stack<Pair<Integer, Integer>> st;

    public MinStack() {
        this.st = new Stack<>();
    }

    public void push(int val) {
        int mn = val;
        if (!st.isEmpty()) mn = Math.min(st.peek().b, val);
        st.push(new Pair<>(val, mn));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().a;
    }

    public int getMin() {
        return st.peek().b;
    }
}