package daelim.java_ch01;

public class CalAssembler {
    MyCalculator calculator;
    CalAdd calAdd;
    CalSub calSub;
    CalMul calMul;
    CalDiv calDiv;

    public CalAssembler() {
        calculator = new MyCalculator();
        calAdd = new CalAdd();
        calSub = new CalSub();
        calMul =  new CalMul();
        calDiv = new CalDiv();
    }
    public void assembler(){
        calculator.calculator(10, 5, calAdd);
        calculator.calculator(10, 5, calSub);
        calculator.calculator(10, 5, calMul);
        calculator.calculator(10, 5, calDiv);
    }
}
