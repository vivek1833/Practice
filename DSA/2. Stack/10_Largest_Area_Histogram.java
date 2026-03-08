import java.util.*;

/*
    Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/description/

    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1. 
    Return the area of the largest rectangle in the histogram.

    Example 1:
        Input: heights = [2,1,5,6,2,3]
        Output: 10
        Explanation: The above is a histogram where width of each bar is 1.
        The largest rectangle is shown in the red area, which has an area = 10 units.
    
    Example 2:
        Input: heights = [2,4]
        Output: 4    

    Constraints:
        1 <= heights.length <= 105
        0 <= heights[i] <= 104
*/

class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            prev[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            st.pop();
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            next[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            int left = (prev[i] == -1 ? 0 : prev[i] + 1);
            int right = (next[i] == -1 ? n - 1 : next[i] - 1);
            int curr = (right - left + 1) * nums[i];
            cnt = Math.max(cnt, curr);
        }
        
        return cnt;
    }
}

/*
    Problem: https://leetcode.com/problems/next-greater-element-ii

    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), 
    Return the next greater number for all elements in nums.

    Example 1:
        Input: nums = [1,2,1]
        Output: [2,-1,2]
        Explanation: The first 1's next greater number is 2; 
            The number 2 can't find next greater number. 
            The second 1's next greater number needs to search circularly, which is also 2.
    
    Example 2:
        Input: nums = [1,2,3,4,3]
        Output: [2,3,4,-1,4]

    Constraints:
        1 <= nums.length <= 104
        -109 <= nums[i] <= 109
*/

class NGE {
    public int[] nextGreaterElements(int[] nums) {

        int n=nums.length;
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek()<=nums[i]) {
                st.pop();
            }

            next[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(nums[i]);
        }

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek()<=nums[i]) {
                st.pop();
            }

            next[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(nums[i]);
        }

       return next;
    }
}