class Solution {
    public int strStr(String haystack, String needle) {
        // If the needle is an empty string, return 0
        if (needle.equals("")) {
            return 0;
        }

        // Get the lengths of haystack and needle
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Initialize indexes for both haystack and needle
        int hayIndex = 0;
        int needleIndex = 0;

        // Loop through the haystack
        while (hayIndex < haystackLength) {
            // If characters match, move both indexes forward
            if (haystack.charAt(hayIndex) == needle.charAt(needleIndex)) {
                if (needleLength == 1) {
                    return hayIndex;
                }
                hayIndex++;
                needleIndex++;
            } else {
                // If a mismatch happens, reset the indexes
                hayIndex = hayIndex - needleIndex + 1;
                needleIndex = 0;
            }

            // If the whole needle is found, return the start position
            if (needleIndex == needleLength) {
                return hayIndex - needleIndex;
            }
        }

        // If the needle is not found, return -1
        return -1;
    }
}
