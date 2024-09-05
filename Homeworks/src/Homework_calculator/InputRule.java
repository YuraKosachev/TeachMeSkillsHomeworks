package Homework_calculator;

public class InputRule {
    private final char[] operationChars;
    {
        this.operationChars = new char[]{'-', '+', '/', '*','.'};
    }
    public boolean isCorrect(String current, String additional ){

        if(current.isEmpty() && "-*+/.".indexOf(additional) > -1)
            return false;

        if("-*+/.".indexOf(additional) > -1 && Extensions.isContains(current.charAt(current.length() - 1),this.operationChars))
            return false;

        if(".".indexOf(additional)>-1 && isValueHasPoint(current))
            return false;

        return true;
    }


    private boolean isValueHasPoint(String operationStr){
        for(int i = operationStr.length() -1 ; i > 0; i--){
            if(operationStr.charAt(i) == '.')
                return true;

            if(Extensions.isContains(operationStr.charAt(i), new char[]{'-', '+', '/', '*'}))
                return false;
        }
        return false;
    }


}
