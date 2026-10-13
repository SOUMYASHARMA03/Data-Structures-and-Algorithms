import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Handle edge case
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        // 2. Initialize with the first interval
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        // 3. Iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= currentEnd) { 
                // There is an overlap, merge the intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval and add it to the list
                currentInterval = intervals[i];
                mergedList.add(currentInterval);
            }
        }

        // 4. Convert the List back to a 2D array
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
