class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for(char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c,0) +1);
        }
        for(char c: t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c,0) -1);
        }
        for (int v: counts.values()) {
            if(v!=0) {
                return false;
            }
        }
        return true;
    }
}
