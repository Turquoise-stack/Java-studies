public class Numbers {

    private final int number1;
    private final int number2;
    private final String calculationRequested;

    public Numbers(int newNumber1, int newNumber2, String calcRequested){
        number1 = newNumber1;
        number2 = newNumber2;
        calculationRequested = calcRequested;
    }

    public int getNumber1() {return number1;}
    public int getNumber2() {return number2;}
    public String getCalcRequested() {return calculationRequested;}
}
