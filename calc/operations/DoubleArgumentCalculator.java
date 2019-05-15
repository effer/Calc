package calc.operations;
import java.math.BigDecimal;
public class DoubleArgumentCalculator extends AbstractCalculator {
    //Этот класс реализует метод вычисления операции(берется из 3 параметра массива аргументов) над первыми двумя введенными числами
    //(берутся из первых двух элементов массива аргументов метода.
    @Override
    public String result(String[] param){
        BigDecimal arg1;
        BigDecimal arg2;
        try{//попытка спарсить первый аргумент-число
            arg1=new BigDecimal(param[0]);
        }
        catch (Exception ex){
            return "incorrect first argument";
        }
        try{//попытка спарсить второй аргумент
            arg2=new BigDecimal(param[1]);
        }
        catch(Exception ex){
            return "incorrect second argument";
        }
        if(operationsMap.get(param[2])!=null){
            try{//попытка произвести вычисление
                return operationsMap.get(param[2]).apply(arg1,arg2).toString();
            }
            catch(ArithmeticException e){
                return "Divizion by zero";
            }
        }
        return"incorrect operator";
    }

}
