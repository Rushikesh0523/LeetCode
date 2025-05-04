class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // Since max value is 9, 10*10 = 100
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            // Create a unique key where (1,2) and (2,1) both become 12
            int key = a < b ? a * 10 + b : b * 10 + a;
            result += count[key];
            count[key]++;
        }

        return result;
    }
}
