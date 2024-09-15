class Solution {
    public int divide(int dividend, int divisor) {
        // Special cases
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;  // Prevent overflow
        }

        // Determine the sign of the result
        boolean positiveResult = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);

        // Work with negative numbers to avoid overflow issues
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize result
        int quotient = 0;

        // Subtract divisor from dividend while possible
        while (dividend - divisor >= 0) {
            int tempDivisor = divisor;
            int multiple = 1;

            // Keep doubling divisor until it's larger than dividend
            while (dividend - (tempDivisor << 1) >= 0 && tempDivisor <= (Integer.MAX_VALUE >> 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the found divisor from dividend
            dividend -= tempDivisor;
            quotient += multiple;
        }

        // Return result with correct sign
        return positiveResult ? quotient : -quotient;
    }
}
