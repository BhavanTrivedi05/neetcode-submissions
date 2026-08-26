class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of (')','(',']','[','}','{');

        for (char c: s.toCharArray()){
            if(pairs.containsKey(c)){
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(open != pairs.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
