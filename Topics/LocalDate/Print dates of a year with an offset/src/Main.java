import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int daysPlus = scanner.nextInt();

        LocalDate date = LocalDate.parse(year);
        int currentYear = date.getYear();
        for (int i = 0; i < daysPlus; i++) {
            int checkYear = date.getYear();
            if (checkYear > currentYear) {
                break;
            } else {
                System.out.println(date);
                date = date.plusDays(daysPlus);
            }
        }

//        for (LocalDate i = date; i.getYear() == date.getYear(); i = i.plusDays(daysPlus)) {
//            System.out.println(i.toString());
//        }


    }
}