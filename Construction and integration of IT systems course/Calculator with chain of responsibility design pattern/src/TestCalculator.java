public class TestCalculator {
    public static void main(String[] args) {
        Chain chainCalc1 = new AddNumbers();
        Chain chainCalc2 = new SubtractNumbers();
        Chain chainCalc3 = new MulitplyNumbers();
        Chain chainCalc4 = new DivideNumbers();

        chainCalc1.jumpToNextChain(chainCalc2);
        chainCalc2.jumpToNextChain(chainCalc3);
        chainCalc3.jumpToNextChain(chainCalc4);

        Numbers request = new Numbers(37,  48 , "-" );

        chainCalc1.calculate(request);

    }
}
