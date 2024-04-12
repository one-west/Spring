package daelim.java_ch01;

public class MyCalculator {
    public void callAdd(int fNum, int sNum) {
        ICalculator calculator = new CalAdd();
        int value = calculator.doOperation(fNum, sNum);
        System.out.println(value);
    }

    public void callSub(int fNum, int sNum) {
        ICalculator calculator = new CalSub();
        int value = calculator.doOperation(fNum, sNum);
        System.out.println(value);
    }

    public void callMul(int fNum, int sNum) {
        ICalculator calculator = new CalMul();
        int value = calculator.doOperation(fNum, sNum);
        System.out.println(value);
    }

    public void callDiv(int fNum, int sNum) {
        ICalculator calculator = new CalDiv();
        int value = calculator.doOperation(fNum, sNum);
        System.out.println(value);
    }
}
