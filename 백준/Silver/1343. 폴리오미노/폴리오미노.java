import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        calculateXDot(input, stack);
        if (validateStack(stack, result)) return;

        System.out.println(result);
    }

    private static boolean validateStack(Stack<String> stack, StringBuilder result) {
        for (String s : stack) {
            if (Objects.equals(s, "X")) {
                System.out.println(-1);
                return true;
            }
            result.append(s);
        }
        return false;
    }

    private static void calculateXDot(String input, Stack<String> stack) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                stack.add("X");
                if (stack.size() > 1 && Objects.equals(stack.get(stack.size()-1), "X") && Objects.equals(stack.get(stack.size()-2), "X")) {
                    stack.pop();
                    stack.pop();
                    stack.add("BB");
                }

                if (stack.size() > 1 && Objects.equals(stack.get(stack.size()-1), "BB") && Objects.equals(stack.get(stack.size()-2), "BB")) {
                    stack.pop();
                    stack.pop();
                    stack.add("AAAA");
                }
            }
            else {
                stack.add(".");
            }
        }
    }
}
