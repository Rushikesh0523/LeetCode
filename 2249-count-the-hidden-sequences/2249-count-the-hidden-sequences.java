class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long x = 0;    // This keeps track of the current value as we apply differences
        long mi = 0;   // This stores the minimum value reached so far
        long mx = 0;   // This stores the maximum value reached so far

        // Traverse through the differences array to find the range of values
        for (int d : differences) {
            x += d;               // Add the current difference to x
            mi = Math.min(mi, x); // Update the minimum value seen so far
            mx = Math.max(mx, x); // Update the maximum value seen so far
        }

        // The possible range of starting values [s] that keeps all values in range [lower, upper]
        // is from (lower - mi) to (upper - mx)
        // So total valid starting values = (upper - lower) - (mx - mi) + 1
        return (int) Math.max(upper - lower - (mx - mi) + 1, 0);
        // If the calculated number is negative, return 0 (i.e., no valid arrays possible)
    }
}
