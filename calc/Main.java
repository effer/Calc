package calc;
import calc.operations.Calculator;
import calc.operations.DoubleArgumentCalculator;
import java.util.function.BiFunction;
import java.math.BigDecimal;
public class Main {

    static Controller controller=new Controller();
    public static void main(String[] argv){
        controller.work();
    }
}
