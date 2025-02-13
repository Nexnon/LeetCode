import java.util.PriorityQueue;

public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: nums){
            queue.add(i);
        }
        int countOperations = 0;
        while (true){
            if(queue.size() < 2 || queue.peek() >= k){
                break;
            }
            int x = queue.poll();
            int y = queue.poll();
            if(x*2 + y > 0)
                queue.add(x*2 + y);
            else
                queue.add(Integer.MAX_VALUE);
            countOperations++;
        }
        return countOperations;
    }
}
