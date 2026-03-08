import java.util.*;

/*
    You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
    Define a pair (u, v) which consists of one element from the first array and one element from the second array.
    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

    ---------------------------------

    Example 1:
        Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        Output: [[1,2],[1,4],[1,6]]
        Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
    
    Example 2:
        Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        Output: [[1,1],[1,1]]
        Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

    ---------------------------------

    Constraints:
        - 1 <= nums1.length, nums2.length <= 105
        - -109 <= nums1[i], nums2[i] <= 109
        - nums1 and nums2 both are sorted in non-decreasing order.
        - 1 <= k <= 104
        - k <= nums1.length * nums2.length
*/

// TC: O(N^2)
// SC: O(N)
class Pair {
    int sum, i, j;

    public Pair(int s, int i, int j) {
        this.sum = s;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums1[i] + nums2[0], i, 0));
        }

        while (k > 0 && !pq.isEmpty()) {
            k--;
            Pair p = pq.poll();
            int x = p.i, y = p.j;

            ans.add(Arrays.asList(nums1[x], nums2[y]));
            if (y < m - 1) pq.offer(new Pair(nums1[x] + nums2[y + 1], x, y + 1));
        }

        return ans;
    }
}