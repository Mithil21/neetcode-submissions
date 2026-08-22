class MinStack {
                        Stack<Integer> stack;
    int min;
    List<Integer> list;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        list.add(val);
        min = calculateMin();
    }

    public void pop() {
        if(!stack.isEmpty()){
            int pop = stack.pop();
            list.remove(Integer.valueOf(pop));
            min = calculateMin();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public int calculateMin(){
        min = list.stream()
                .min(Integer::compare)
                .orElse(min);
        return min;
    }
}
