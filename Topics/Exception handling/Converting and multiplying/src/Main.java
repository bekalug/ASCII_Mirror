import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strSequence = new ArrayList<>();

        String input;
        while (true) {
            input = scanner.nextLine();
            if (!"0".equals(input)) {
                strSequence.add(input);
            } else {
                break;
            }
        }

        for (String str : strSequence) {
            try {
                System.out.println(Integer.parseInt(str) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + str);
            }
        }
    }
}
