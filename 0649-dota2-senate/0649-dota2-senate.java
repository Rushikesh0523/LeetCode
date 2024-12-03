class Solution {
    public String predictPartyVictory(String senate) {
        int totalSenators = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();

        for (int i = 0; i < totalSenators; ++i) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
      
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.peek();
            int direIndex = direQueue.peek();
          
            if (radiantIndex < direIndex) {
                radiantQueue.offer(radiantIndex + totalSenators);
            } else {                direQueue.offer(direIndex + totalSenators);
            }

            radiantQueue.poll();
            direQueue.poll();
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}