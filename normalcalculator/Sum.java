package DewanSir.normalcalculator;

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
        return tempResult;
    }
}
