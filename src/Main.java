import Exceptions.WrongInputException;

import java.util.Scanner;

public class Main {

    static String string[] = {"III  + X", "10/0", "3 -2", "IV-3", "32+V", "1*VI", "2X23-2"};

    public static void main(String[] args) throws WrongInputException {
        Scanner in = new Scanner(System.in);
        for (int y = 0; y < string.length; y++) {
            System.out.println(new Expression(string[y]).calculate());
        }
    }
}
