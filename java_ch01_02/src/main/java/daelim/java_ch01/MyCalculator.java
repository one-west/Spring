package daelim.java_ch01;

public class MyCalculator {
//    public void callAdd(int fNum, int sNum, CalAdd calAdd) {
//        ICalculator calculator = new CalAdd();
//        int value = calculator.doOperation(fNum, sNum);
//        System.out.println("result: " + value);
//    }
//
//    public void callSub(int fNum, int sNum, CalSub calSub) {
//        ICalculator calculator = new CalSub();
//        int value = calculator.doOperation(fNum, sNum);
//        System.out.println("result: " + value);
//    }
//
//    public void callMul(int fNum, int sNum, CalMul calMul) {
//        ICalculator calculator = new CalMul();
//        int value = calculator.doOperation(fNum, sNum);
//        System.out.println("result: " + value);
//    }
//
//    public void callDiv(int fNum, int sNum, CalDiv calDiv) {
//        ICalculator calculator = new CalDiv();
//        int value = calculator.doOperation(fNum, sNum);
//        System.out.println("result: " + value);
//    }
    public void calculator(int fNum, int sNum, ICalculator calculator){
        int value = calculator.doOperation(fNum, sNum);
        System.out.println("result : " + value);
    }
}
