package Exceptions;

import Annotations.GovnoCode;

public class WrongInputException extends Exception{

    public WrongInputException() {
        super("Неправильный ввод!!!");
    }

    @GovnoCode
    public WrongInputException(String message) {
        //все говорят, что StringBuilder быстрее, но в смысле такого я сомневаюсь)
        super(String.valueOf(new StringBuilder("Неправильный ввод: ").append(message)));
    }
}
