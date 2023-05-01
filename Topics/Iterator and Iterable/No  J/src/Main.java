import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> arrayList = new ArrayList<>(Arrays.asList(array));
        ListIterator<String> list = arrayList.listIterator();
        while (list.hasNext()) {
            String word = list.next();
            if (!word.startsWith("J")) {
                list.remove();
            }
        }
        while (list.hasPrevious()) {
            String elem = list.previous();
            System.out.println(elem.substring(1));
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}