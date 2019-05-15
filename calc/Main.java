package calc;
import calc.operations.Calculator;
import calc.operations.DoubleArgumentCalculator;
import java.util.function.BiFunction;
import java.math.BigDecimal;
public class Main {
    static BiFunction<BigDecimal,BigDecimal,BigDecimal>f=new BiFunction<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            int a;

            a=Integer.parseInt(bigDecimal2.toString());
            return bigDecimal.pow(a);

        }
    };
    public static void main(String[] argv){
        Calculator c=new DoubleArgumentCalculator().addOperation("pow",f);
        String [] str={"12379725","57.800","pow"};
        System.out.println(c.result(str));

    }
}
