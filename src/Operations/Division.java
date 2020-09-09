package Operations;

import Converters.NumConverter;
import Interfaces.Operation;

public class Division implements Operation {
    @Override
    public String calculate(int firstNum, int secondNum, boolean returnArab){
        if (returnArab) return String.valueOf(firstNum / secondNum);
        return new NumConverter().intToRoman(firstNum / secondNum);
    }
}
