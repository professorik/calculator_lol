import Converters.NumConverter;
import Exceptions.WrongInputException;
import Operations.*;

public class Expression {
    private int firstNum;
    private int secondNum;
    private char operator;
    private boolean isArabSystem;

    public Expression(String input) throws WrongInputException {
        //удаляю пробелы и невидимые символы
        input = input.replaceAll("\\s+","");

        for (char temp: new char[]{'+', '-', '/', '*'}) {
            input = input.replace(String.valueOf(temp), String.format(" %c ", temp));
        }
        String arr[] = input.split(" ");
        if (arr.length < 3) throw new WrongInputException();
        this.operator = arr[1].charAt(0);

        NumConverter numConverter = new NumConverter();
        this.firstNum = numConverter.convert(arr[0]);
        this.secondNum = numConverter.convert(arr[2]);

        int temp = numConverter.getCountOfArabNums();
        if (temp % 2 != 0) throw new WrongInputException(input);
        this.isArabSystem = (temp == 0);
    }

    public String calculate() throws WrongInputException{
        switch (operator){
            case '+':
                return new Plus().calculate(firstNum, secondNum, isArabSystem);
            case '-':
                return new Minus().calculate(firstNum, secondNum, isArabSystem);
            case '*':
                return new Multiply().calculate(firstNum, secondNum, isArabSystem);
            case '/':
                return new Division().calculate(firstNum, secondNum, isArabSystem);
            default: throw new WrongInputException(String.format("неправильная арифметическая операция: %c", operator));
        }
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}