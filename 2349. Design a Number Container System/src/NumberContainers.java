import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberContainers {

    Map<Integer, Integer> containers;
    Map<Integer, PriorityQueue<Integer>> reversContainers;

    public NumberContainers() {
        containers = new HashMap<>();
        reversContainers = new HashMap<>();
    }

    public void change(int index, int number) {
        if(containers.containsKey(index) && containers.get(index)==number)
            return;
        Integer num = containers.get(index);
        if(num != null){
            reversContainers.get(num).remove(index);
        }
        containers.put(index, number);

        PriorityQueue<Integer> queue = reversContainers.get(number);
        if(queue == null){
            queue = new PriorityQueue<>();
            queue.add(index);
            reversContainers.put(number, queue);
        }else
            queue.add(index);
    }

    public int find(int number) {
        PriorityQueue<Integer> num = reversContainers.get(number);
        if(num != null && !num.isEmpty()){
            return num.peek();
        }
        return -1;
    }
}
