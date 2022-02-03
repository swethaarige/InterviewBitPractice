/*
Problem statement: You have an array (list) of interval pairs as input where each interval has a start and
end timestamp, sorted by starting timestamps. Merge the overlapping intervals and return a new output array.
Consider an input array below. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so they should be
merged to one interval (1, 8). Similarly, intervals (10, 12) and (12, 15) are also overlapping and should
be merged to (10, 15).
This problem can be solved with a linear scan algorithm. The list of input intervals is given, and
we’ll keep merged intervals in the output list. For each interval in the input list:
If the input interval is overlapping with the last interval in the output list, merge these two
intervals and update the last interval of the output list with the merged interval.
Otherwise, add an input interval to the output list.
Runtime complexity: Linear, O(n)
Memory complexity: Linear, O(n)


 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> A = new ArrayList<Interval>(2);
        A.add(new Interval(1,3));
        A.add(new Interval(2,6));
        A.add(new Interval(8,10));
        A.add(new Interval(15,18));

        ArrayList<Interval> resultIntervals=merge(A);
        for(Interval i : resultIntervals){
            System.out.println("Inserted merged intervals"+"("+i.start +" ,"+i.end + ")" );
        }
    }
    static class Interval {
            int start;
            int end;
            Interval(){
                start = 0;
                end = 0;
            }
            Interval(int s, int e) {
                start = s;
                end = e;
            }
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(intervals.get(i).end, end);
            }
            else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;

    }
}
