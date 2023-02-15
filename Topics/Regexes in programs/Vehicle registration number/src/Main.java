import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        String numberRegex = "^[A | B | E | K | M | H | O | P | C | T | Y | X]{1}[0-9]{3}[A | B | E | K | M | H | O | P | C | T | Y | X]{2}$";

        System.out.println(regNum.matches(numberRegex) ? "true" : "false");
    }
}