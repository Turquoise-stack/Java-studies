public class DivideNumbers extends Chain {

    private Chain nextInChain;

    @Override
    public void jumpToNextChain(Chain nextChain) {

        this.nextInChain = nextChain;
    }
    @Override
    public void calculate(Numbers request) {

        if(request.getCalcRequested().equals("*")){
            System.out.println(request.getNumber1()  + " * " + request.getNumber2() + " = " + (request.getNumber1()*request.getNumber2()));
        }
        else{
            System.out.println(request.getCalcRequested() + " is not an operator in this calculator..." );
        }
    }
}