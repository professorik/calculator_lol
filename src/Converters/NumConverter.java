package Converters;

import Exceptions.RomanArithmeticException;
import Exceptions.WrongInputException;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

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

    public String intToRoman(int number) throws RomanArithmeticException{
        if (number >= 4000 || number <= 0) {
            throw new RomanArithmeticException(number);
        }
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private final NavigableMap<Integer, String> units;
    {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

    /**
     * Перевод числа из арабской системы
     * в римскую. (максимум можно 999)
     * @param num
     * @return String
     */
    @Deprecated
    public String convertToRoman(int num){
        String res = numberExponentConvert(num / 100, new String[]{"CCC", "CD", "D", "CM"}, "");
        num %= 100;
        res = numberExponentConvert(num / 10, new String[]{"XXX", "XL", "L", "XC"}, res);
        num %= 10;
        res = numberExponentConvert(num, new String[]{"III", "IV", "V", "IX"}, res);
        return res;
    }

    /**
     * Так как в римской системе нельзя 4 подряд
     * идущих символа - в параметрах было передано
     * числа (в римской системе):
     * 3*10^n, 4*10^n, 5*10^n, 9*10^n
     * @param temp
     * @param arr
     * @param res
     * @return String
     */
    private String numberExponentConvert(int temp, String arr[], String res){
        if (temp < 4){
            res += arr[0].substring(0, temp);
        }else if (temp == 4){
            res += arr[1];
        }else if (temp > 4 && temp < 9){
            res += arr[2] + arr[0].substring(0, temp - 5);
        }else res += arr[3];
        return res;
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
            throw new WrongInputException("неправильная величина числа: ".concat(s));
        }
        return result;
    }
}
