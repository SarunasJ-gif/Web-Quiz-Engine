import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt() + 1;
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackMax = new ArrayDeque<>();
        while (inputSize > 0) {
            String command = scanner.nextLine();
            if (command.startsWith("push")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                stack.push(number);
                if (stack.size() == 1) {
                    stackMax.push(number);
                } else {
                    if (number > stackMax.peek()) {
                    stackMax.push(number);
                    } else {
                        stackMax.push(stackMax.peek());
                    }
                }
            } else if (command.startsWith("pop")) {
                stack.pop();
                stackMax.pop();
            } else if (command.startsWith("max")) {
                System.out.println(stackMax.peek());
            }
            inputSize--;

        }

    }
}
