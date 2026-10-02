class MinStack {
   private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val){
        stack.push(val);
        minStack.push(minStack.isEmpty() ? val : Math.min(val, minStack.peek()));
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
       return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
