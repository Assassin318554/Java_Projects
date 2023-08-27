package DewanSir.normalcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Sum {
    double tempResult;
    public double DO(Calculator calculator) {
        if(calculator.signString1 == "+"){
            tempResult = calculator.value1 + calculator.value2;
        }
        else if(calculator.signString1 == "-"){
            tempResult = calculator.value1 - calculator.value2;
        }
        else if(calculator.signString1 == "x"){
            tempResult = calculator.value1 * calculator.value2;
        }
        else if(calculator.signString1 == "÷"){
            tempResult = calculator.value1 / calculator.value2;
        }
        else if(calculator.signString1 == "%"){
            tempResult = calculator.value1 % calculator.value2;
        }

        BigDecimal bd = new BigDecimal(tempResult).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
