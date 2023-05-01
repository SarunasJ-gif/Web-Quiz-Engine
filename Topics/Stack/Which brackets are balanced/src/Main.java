import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> deque = new ArrayDeque<>();
        boolean flag = true;
        for (char ch : input.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                || (deque.peekFirst() == '[' && ch == ']')
                || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(deque.isEmpty());
        } else {
            System.out.println("false");
        }
    }
}