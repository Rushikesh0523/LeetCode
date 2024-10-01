class Solution {

    public boolean canArrange(int[] arr, int k) {
        
        int[] count = new int[k];

       
        for (int number : arr) {
            count[(number % k + k) % k]++;
        }
     for (int i = 1; i < k; ++i) {
         
            if (count[i] != count[k - i]) {
               
                return false;
            }
        }

        return count[0] % 2 == 0;
    }
}