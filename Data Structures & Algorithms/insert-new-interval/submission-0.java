class Solution {
    public int[][] insert(int[][] intervals, int[] newIntervals) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newIntervals[0]){
            res.add(intervals[i]);
            i++;
        }
        int start = newIntervals[0], end = newIntervals[1];
        while(i<n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});

        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
