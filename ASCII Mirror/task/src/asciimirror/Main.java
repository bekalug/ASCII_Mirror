package asciimirror;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        try {
            List<String> strList = Files.readAllLines(Paths.get(path));
            int longestStrLength = strList.stream().max(Comparator.comparingInt(String::length)).get().length();
            Scanner input = new Scanner(new File(path));
            String str;
            int count = 0;
            while (input.hasNextLine()) {
                str = input.nextLine();
                str = str + " ".repeat(longestStrLength - str.length());
                strList.set(count, str);
                System.out.print(str + " | ");
                char[] reversed = str.toCharArray();
                for (int i = reversed.length - 1; i >= 0; i--) {
                    if (reversed[i] == '[') {
                        reversed[i] = ']';
                    } else if (reversed[i] == '<') {
                        reversed[i] = '>';
                    } else if (reversed[i] == '>') {
                        reversed[i] = '<';
                    } else if (reversed[i] == ']') {
                        reversed[i] = '[';
                    } else if (reversed[i] == '{') {
                        reversed[i] = '}';
                    } else if (reversed[i] == '}') {
                        reversed[i] = '{';
                    } else if (reversed[i] == '(') {
                        reversed[i] = ')';
                    } else if (reversed[i] == ')') {
                        reversed[i] = '(';
                    } else if (reversed[i] == '/') {
                        reversed[i] = '\\';
                    } else if (reversed[i] == '\\') {
                        reversed[i] = '/';
                    }
                    System.out.print(reversed[i]);
                }
                count++;
                System.out.println();
            }
        } catch (InvalidPathException | IOException e) {
            System.out.println("File not found!");
        }
    }
}