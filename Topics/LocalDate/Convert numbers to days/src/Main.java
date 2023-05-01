import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearInput = scanner.nextInt();
        int firstDaysInput = scanner.nextInt();
        int secondDaysInput = scanner.nextInt();
        int thirdDaysInput = scanner.nextInt();

        System.out.println(LocalDate.ofYearDay(yearInput, firstDaysInput));
        System.out.println(LocalDate.ofYearDay(yearInput, secondDaysInput));
        System.out.println(LocalDate.ofYearDay(yearInput, thirdDaysInput));
    }
}