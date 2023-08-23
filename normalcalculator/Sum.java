package DewanSir.normalcalculator;

class Sum {
    int finalResult = 0, tempResult = 0, tempVariable;
    public int DO(Calculator calculator) {
        for(int i = 0; i < calculator.stringArrayList.size(); i++){

            if(calculator.stringArrayList.get(i).equals(calculator.sign[0].getLabel())){
                //finalResult += tempResult;
                for(int j = i+1; j < calculator.stringArrayList.size(); j++){
                    if(calculator.stringArrayList.get(i).equals(calculator.sign[0].getLabel()) ||
                            calculator.stringArrayList.get(i).equals(calculator.sign[1].getLabel()) ||
                            calculator.stringArrayList.get(i).equals(calculator.sign[2].getLabel()) ||
                            calculator.stringArrayList.get(i).equals(calculator.sign[3].getLabel()) ||
                            calculator.stringArrayList.get(i).equals(calculator.sign[4].getLabel())){
                        finalResult -= tempResult;
                        tempResult = 0;
                    }
                }
                tempResult = 0;
            }
            else if(calculator.stringArrayList.get(i).equals(calculator.sign[1].getLabel())){
                finalResult -= tempResult;
                tempResult = 0;
            }
            else if(calculator.stringArrayList.get(i).equals(calculator.sign[2].getLabel())){
                finalResult *= tempResult;
                tempResult = 0;
            }
            else if(calculator.stringArrayList.get(i).equals(calculator.sign[3].getLabel())){
                finalResult /= tempResult;
                tempResult = 0;
            }
            else if(calculator.stringArrayList.get(i).equals(calculator.sign[4].getLabel())){
                finalResult = finalResult%tempResult;
                tempResult = 0;
            }
            else {
                tempVariable = Integer.parseInt(calculator.stringArrayList.get(i));
                tempResult = tempResult * 10 + tempVariable;
            }
        }
        return finalResult;
    }
}
