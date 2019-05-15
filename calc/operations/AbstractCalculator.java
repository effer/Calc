package calc.operations;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.math.BigDecimal;
abstract public class AbstractCalculator implements Calculator{
    // ниже созданы 4 метода для 4 арифметических операций с длинными числами
    protected final BiFunction<BigDecimal,BigDecimal,BigDecimal> sum=new BiFunction<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.add(bigDecimal2);
        }
    };
    protected final BiFunction<BigDecimal,BigDecimal,BigDecimal> mul=new BiFunction<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.multiply(bigDecimal2);
        }
    } ;
    protected final BiFunction<BigDecimal,BigDecimal,BigDecimal> sub = new BiFunction<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.subtract(bigDecimal2);
        }
    };
    protected final BiFunction<BigDecimal,BigDecimal,BigDecimal> div = new BiFunction<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.divide(bigDecimal2);
        }
    };
    protected static  final Map<String,BiFunction<BigDecimal,BigDecimal,BigDecimal>> operationsMap=new HashMap<>();
    {//в этот словарь помещаются арифметические операции, которые будут извлекаться по текстовому ключу, соответствующему каждой операции
        operationsMap.put("+",sum);
        operationsMap.put("-",sub);
        operationsMap.put("*",mul);
        operationsMap.put("/",div);
    }
    abstract public String result(String[] param);//этот метод остается абстрактным для возможности расширения.
    //в рамках данной мне задачи нужно производить операции только с двумя введенными числами, эта возможность будет
    //добавлена в классе-наследнике.
    //Так же, функциональность этого класса может быть расширена для проведения более сложных расчетов.
}
