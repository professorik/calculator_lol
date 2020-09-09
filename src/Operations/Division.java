package Operations;

import Converters.NumConverter;
import Interfaces.Operation;

public class Division implements Operation {
    @Override
    public String calculate(int firstNum, int secondNum, boolean returnArab) throws ArithmeticException{
        if (returnArab) return String.valueOf(firstNum / secondNum);
        return new NumConverter().convertToRim(firstNum / secondNum);
    }
}
