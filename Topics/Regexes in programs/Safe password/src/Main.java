import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPassword = scanner.nextLine();
        String regexUp = ".*[A-Z]+.*";
        String regexLow = ".*[a-z]+.*";
        String regexDigit = ".*[0-9]+.*";

        if (inputPassword.matches(regexUp) &&
                inputPassword.matches(regexLow) &&
                inputPassword.matches(regexDigit) &&
                inputPassword.length() >= 12) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}