package Exceptions;

import Annotations.GovnoCode;

public class RomanArithmeticException extends ArithmeticException{

    public RomanArithmeticException() {
        super("Нельзя записать такое число в римской системе!!!");
    }

    @GovnoCode
    public RomanArithmeticException(int message) {
        //все говорят, что StringBuilder быстрее, но в смысле такого я сомневаюсь)
        super(String.valueOf(new StringBuilder("Нельзя записать такое число в римской системе: ").append(message)));
    }
}
