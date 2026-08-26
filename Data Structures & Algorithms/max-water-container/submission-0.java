class Solution {
    public int maxArea(int[] heights) {
        int left =0, right = heights.length-1;
        int best =0;

        while (left < right) {
            int area = (right - left)*Math.min(heights[left], heights[right]);
            best = Math.max(best, area);

            if(heights[left]<heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }
}
