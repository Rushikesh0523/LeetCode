class Solution {
  
    // Function to find the length of the longest substring containing vowels in even counts
    public int findTheLongestSubstring(String s) {
        // pos array to keep track of the earliest index of each state
        int[] earliestPos = new int[32]; // 32 possible states for 5 vowels (2^5)
        // Initialize all positions to max value except for state 0
        Arrays.fill(earliestPos, Integer.MAX_VALUE);
        // State 0 (no vowels seen or all seen even times) starts at index -1
        earliestPos[0] = -1;
      
        // String of vowels to check against
        String vowels = "aeiou";
      
        // 'state' will represent the binary value of the vowels seen odd number of times
        int state = 0;
        // 'maxLength' stores the length of the longest substring found so far
        int maxLength = 0;
      
        // Loop through characters of input string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // Check and flip the corresponding bit for the vowel
            for (int j = 0; j < 5; j++) {
                if (currentChar == vowels.charAt(j)) {
                    state ^= (1 << j);
                }
            }
          
            // If state has been seen before, update the maxLength
            maxLength = Math.max(maxLength, i - earliestPos[state]);
            // If state has not been seen before, set it to the current index
            if (earliestPos[state] == Integer.MAX_VALUE) {
                earliestPos[state] = i;
            }
        }
      
        // Return the length of the longest substring
        return maxLength;
    }
}