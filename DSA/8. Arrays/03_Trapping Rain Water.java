import java.util.Arrays;

/*
    Problem Link: https://leetcode.com/problems/trapping-rain-water/

    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    ------------------------------

    Example 1:
        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    
    Example 2:
        Input: height = [4,2,0,3,2,5]
        Output: 9
    
    ------------------------------

    Constraints:
        - n == height.length
        - 1 <= n <= 2 * 104
        - 0 <= height[i] <= 105
*/

// TC: O(N)
// SC: O(N)
class Solution {
    public int trap(int[] nums)
    {
        int n=nums.length, cnt=0;
        int[] left=new int[n], right=new int[n];
        Arrays.fill(left, nums[0]);
        Arrays.fill(right, nums[n-1]);

        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], nums[i]);
        }

        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], nums[i]);
        }

        for(int i=0; i<n; i++) {
            cnt += Math.abs(nums[i] - Math.min(left[i], right[i]));
        }

        return cnt;
    }
};