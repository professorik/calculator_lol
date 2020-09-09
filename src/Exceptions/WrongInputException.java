package Exceptions;

import Annotations.GovnoCode;

public class WrongInputException extends Exception{

    public WrongInputException() {
        super("Wrong input!!!");
    }

    @GovnoCode
    public WrongInputException(String message) {
        //все говорят, что StringBuilder быстрее, но в смысле такого я сомневаюсь)
        super(String.valueOf(new StringBuilder("Wrong input: ").append(message)));
    }
}
