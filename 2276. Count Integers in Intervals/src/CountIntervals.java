import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountIntervals {

    private static class Interval implements Comparable<Interval>{
        public int left;
        public int right;

        public Interval(int left, int right) {
            this.left = Integer.min(left, right);
            this.right = Integer.max(left, right);
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.signum(this.left - o.left);
        }

        @Override
        public String toString() {
            return "[" + left + ", " + right + ']';
        }
    }

    private final Set<Interval> intervals;
    private int last_count = 0;
    private boolean isUpdate = false;
    private int min_value = Integer.MAX_VALUE;
    private int max_value = Integer.MIN_VALUE;

    public CountIntervals() {
        this.intervals = new HashSet<>();
    }

    public void add(int left, int right) {
        Interval interval = new Interval(left, right);
        if (min_value <= interval.right + 1 && max_value >= interval.left - 1){
            for (Iterator<Interval> i = this.intervals.iterator(); i.hasNext(); ) {
                Interval interval1 = i.next();
                if (isOverlap(interval, interval1)) {
                    i.remove();
                    interval.left = Integer.min(interval.left, interval1.left);
                    interval.right = Integer.max(interval.right, interval1.right);
                }
            }
        }
        if(interval.left < min_value){
            min_value = interval.left;
        }
        if(interval.right > max_value){
            max_value = interval.right;
        }
        this.intervals.add(interval);
        isUpdate = true;
    }

    public int count() {
        if(intervals.isEmpty()){
            return 0;
        }
        if(!isUpdate){
            return last_count;
        }
        int count = 0;
        for (Interval interval: this.intervals){
            count += interval.right - interval.left + 1;
        }
        last_count = count;
        isUpdate = false;
        return count;
    }

    private boolean isOverlap(Interval interval1, Interval interval2){
        if(interval1.left >= interval2.left && interval1.left <= interval2.right){
            return true;
        }
        if(interval2.left >= interval1.left && interval2.left <= interval1.right){
            return true;
        }
        if(interval1.left == interval2.right + 1 || interval2.left == interval1.right + 1){
            return true;
        }
        return false;
    }
}
