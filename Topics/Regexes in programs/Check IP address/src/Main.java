import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipInput = scanner.nextLine();
        boolean isValid = true;
        try {
            int[]ipAddress = Arrays.stream(ipInput.split("\\.")).mapToInt(Integer::parseInt).toArray();
                if (ipAddress.length == 4 && !ipInput.endsWith(".")) {
                    for (int i = 0; i < 4; i++) {
                        if (ipAddress[i] < 0 || ipAddress[i] > 255) {
                            isValid = false;
                            break;
                        }
                    }
                } else {
                    isValid = false;
                }
        } catch (NumberFormatException e) {
            isValid = false;
        }

        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}