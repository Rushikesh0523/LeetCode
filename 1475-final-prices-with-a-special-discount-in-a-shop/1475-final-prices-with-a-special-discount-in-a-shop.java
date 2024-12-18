class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] finalPrices = new int[n];
        for (int i = 0; i < n; ++i) {
            finalPrices[i] = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                 finalPrices[stack.pop()] -= prices[i];
            }
 stack.push(i);
        }
 return finalPrices;
    }
}
