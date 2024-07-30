class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        
        int count = 0;
        stack.push(s.charAt(0));

        for (int i = 1 ; i < s.length() ; i++) {
            if (!stack.empty() && stack.peek() == 'b' && s.charAt(i) == 'a') {
                count++;
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return count;
    }
}