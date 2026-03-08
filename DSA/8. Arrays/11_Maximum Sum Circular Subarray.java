/*
    Problem Link: https://leetcode.com/problems/maximum-sum-circular-subarray

    -------------------------------
    
    Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

    A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

    A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

    -------------------------------

    Example 1:
        Input: nums = [1,-2,3,-2]
        Output: 3
        Explanation: Subarray [3] has maximum sum 3.
    
    Example 2:
        Input: nums = [5,-3,5]
        Output: 10
        Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
    
    Example 3:
        Input: nums = [-3,-2,-3]
        Output: -2
        Explanation: Subarray [-2] has maximum sum -2.
    
    -------------------------------

    Constraints:
        - n == nums.length
        - 1 <= n <= 3 * 104
        - -3 * 104 <= nums[i] <= 3 * 104
*/

// TC: O(n)
// SC: O(1)
class Solution {
    int[] solve(int n, int[] arr)
    {
        int mn=arr[0], mx=arr[0], s=arr[0];
        int mns=arr[0], mxs=arr[0];

        for(int i=1; i<n; i++) {
            mx=Math.max(arr[i],mx+arr[i]);
            mxs=Math.max(mxs,mx);

            mn=Math.min(arr[i],mn+arr[i]);
            mns=Math.min(mn,mns);

            s+=arr[i];
        }

        return new int[]{mxs,mns,s};
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int[] ans=solve(n,nums);

        int mx=ans[0], mn=ans[1], s=ans[2];
        return (mx<0 ? mx : Math.max(s-mn,mx));
    }
}