class MinStack {
   private final Deque<Long> stack = new ArrayDeque<>();
    private long min;

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else if (val >= min) {
            stack.push((long) val);
        } else {
            stack.push(2L * val - min); // encode using the OLD min
            min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) throw new IllegalStateException("stack is empty");
        long top = stack.pop();
        if (top < min) {
            min = 2 * min - top; // decode the previous min
        }
    }

    public int top() {
        if (stack.isEmpty()) throw new IllegalStateException("stack is empty");
        long top = stack.peek();
        return (int) (top < min ? min : top);
    }

    public int getMin() {
        if (stack.isEmpty()) throw new IllegalStateException("stack is empty");
        return (int) min;
    }
}
