class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        int[] need = new int[128];
        for(char c:t.toCharArray()) need[c]++ ;
        int required =0;
        for (int i=0;i<128;i++){
            if(need[i]>0)required++;
        }
        int [] window = new int[128];
        int have = 0,left =0;
        int bestLen = Integer.MAX_VALUE, bestStart =0;

        for(int right =0;right < s.length(); right++){
            char c = s.charAt(right);
            window[c]++;
            if(need[c]>0 && window[c]== need[c]) have++;

            while(have == required){
                if(right -left + 1<bestLen){
                    bestLen = right - left +1;
                    bestStart = left;
                }
                char lc = s.charAt(left);
                window[lc]--;
                if(need[lc]> 0 && window[lc] < need[lc]) have--;
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE? "" :s.substring(bestStart,bestStart+bestLen);
    }
}
