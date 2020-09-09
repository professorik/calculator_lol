package Converters;

import Annotations.GovnoCode;
import Exceptions.WrongInputException;

public class NumConverter{
    private int countOfArabNums;

    public NumConverter() {
        this.countOfArabNums = 0;
    }

    public int getCountOfArabNums() {
        return countOfArabNums;
    }

    /**
     * Перевод числа из римской системы
     * в арабскую. Если при конвертировании
     * встречается цифра из арабской системы,
     * то выбрасывается @Exception про неправильный
     * ввод.
     * @param s
     * @return Integer
     */
    private int convertToArab(String s){
        int arr[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    arr[i] = 1;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                default:
                    new Exception("Несоответсвие цифр").printStackTrace();
                    System.exit(0);
            }
        }
        int sum = arr[s.length() - 1];
        for (int i = s.length() - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                sum -= arr[i];
            } else {
                sum += arr[i];
            }
        }
        return sum;
    }

    //TODO
    @GovnoCode
    public String convertToRim(int num){
        return "kar";
    }

    /**
     * Если строка конвертируется встроиным
     * методом valueOf() - возвращаем данное
     * значение. Иначе ловим @NumberFormatException
     * и пытаемся сконвертировать через convertToArab(s).
     * Если результат не входит в отрезок [1,10] -
     * выдаем исключение о неправильной величине.
     * @param s
     * @return int
     * @Exception неправильная величина числа
     */
    public int convert(String s) throws WrongInputException {
        int result;
        try{
            result = Integer.valueOf(s);
        }catch (NumberFormatException e){
            result = convertToArab(s);
            ++countOfArabNums;
        }
        if (result < 1 || result > 10){
            throw new WrongInputException("неправильная величина числа: ".concat(String.valueOf(result)));
        }
        return result;
    }
}
