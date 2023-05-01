import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] dateInput = input.split(" ");
        LocalDate date = LocalDate.ofYearDay(Integer.parseInt(dateInput[0]), Integer.parseInt(dateInput[1]));
        if (date.getDayOfMonth() == date.lengthOfMonth()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}