class Solution {
    public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
                int b = stack.pop(); // second operand (pushed most recently)
                int a = stack.pop(); // first operand
                int result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                stack.push(result);
                break;
            default:
                stack.push(Integer.parseInt(token));
                break;
        }
    }

    return stack.pop();
}
}
