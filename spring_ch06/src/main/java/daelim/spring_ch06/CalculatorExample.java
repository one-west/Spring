package daelim.spring_ch06;

public class CalculatorExample {
    public static void main(String[] args) {
//        long start1 = System.currentTimeMillis();
//        ImpleCalculator impleCalculator = new ImpleCalculator();
//        long iResult = impleCalculator.factorial(4);
//        long end1 = System.currentTimeMillis();
//        System.out.printf("ImpecCalculator.factorial(%d) 실행시간 = %d\n", 4, (end1 - start1));
//
//        long start2 = System.currentTimeMillis();
//        RecCalculator recCalculator = new RecCalculator();
//        recCalculator.factorial(4);
//        long end2 = System.currentTimeMillis();
//        System.out.printf("RecCalculator.factorial(%d) 실행시간 = %d\n", 4, (end2 - start2));

        ExTimeCalculator calculator1 = new ExTimeCalculator(new ImpleCalculator());
        System.out.println("ImpleCalculator : " + calculator1.factorial(4));
        ExTimeCalculator calculator2 = new ExTimeCalculator(new RecCalculator());
        System.out.println("RecCalculator : " + calculator2.factorial(4));
    }
}
