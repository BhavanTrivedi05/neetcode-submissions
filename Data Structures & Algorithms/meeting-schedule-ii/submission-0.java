/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i = 0;i<n;i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0, maxRooms = 0;
        int s = 0, e = 0;

        while(s<n){
            if(starts[s]<ends[e]){
                rooms++;
                s++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                rooms--;
                e++;
            }
        }
        return maxRooms;
    }
}
