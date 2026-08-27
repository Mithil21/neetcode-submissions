class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        // int index = 0;

        Arrays.fill(res, 0);

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];

            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
