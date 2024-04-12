package daelim.java_ch01;

public class MainClass {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();
        calculator.callAdd(10, 5);
        calculator.callSub(10, 5);
        calculator.callMul(10, 5);
        calculator.callDiv(10, 5);
    }
}
