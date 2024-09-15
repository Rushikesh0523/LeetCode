class Solution {
    public int myAtoi(String s) {
        // Step 1: Handle null or empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Initialize index and length
        int i = 0;
        int n = s.length();

        // Step 2: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If the entire string is just whitespaces
        if (i == n) {
            return 0;
        }

        // Step 3: Handle optional sign
        int sign = 1; // Default to positive
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Step 4: Convert number and handle overflow
        int result = 0;
        int limit = Integer.MAX_VALUE / 10;  // Prevent overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > limit || (result == limit && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Build the result
            result = result * 10 + digit;
            i++;
        }

        // Step 5: Apply sign and return result
        return result * sign;
    }
}