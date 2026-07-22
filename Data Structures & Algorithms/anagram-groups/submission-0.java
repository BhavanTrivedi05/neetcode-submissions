class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c- 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int n: count) {
                sb.append('#').append(n);
            }
            String key = sb.toString();

            if(!groups.containsKey(key)) {
                groups.put(key,new ArrayList<>());
            }
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
