import java.util.*;

/*
    Problem Link: https://leetcode.com/problems/online-stock-span/
    
    Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

    Example 1:
        Input
            ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
            [[], [100], [80], [60], [70], [60], [75], [85]]
        Output
            [null, 1, 1, 1, 2, 1, 4, 6]

        Explanation: 
            StockSpanner stockSpanner = new StockSpanner();
            stockSpanner.next(100); // return 1
            stockSpanner.next(80);  // return 1
            stockSpanner.next(60);  // return 1
            stockSpanner.next(70);  // return 2
            stockSpanner.next(60);  // return 1
            stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
            stockSpanner.next(85);  // return 6
        
        Constraints:
            - 1 <= price <= 105
            - At most 104 calls will be made to next.
*/

class StockSpanner {
    Stack<int[]> stack;     // price , span
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
   }
}