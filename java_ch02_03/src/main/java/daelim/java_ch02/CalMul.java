package daelim.java_ch02;

public class CalMul implements ICalculator{
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
