import Exceptions.WrongInputException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongInputException {
        Scanner in = new Scanner(System.in);
        System.out.println(new Expression(in.nextLine()).calculate());
    }
}
