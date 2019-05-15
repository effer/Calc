package calc;
import calc.operations.*;
import calc.dataloader.*;
import java.util.Scanner;
public class Controller {


    private  Calculator calculator=new DoubleArgumentCalculator().addOperation(
            "pow",
            (bigDecimal,bigDecimal2)->{//метод возводит первый аргумент в степень второго аргумента,
                int a;                 //второй аргумент должен укладываться в размеры типа int
                a=Integer.parseInt(bigDecimal2.toString());
                return bigDecimal.pow(a);
            }

    );//экземпляр калькулятора расширен добавлением операции возведения в целочисленную степень
    private DataProcessor processor= new StringProcessor(
            /*определяем использование данных, получаемых на вход StringProcessor-
            они поступят на вход метода getResult() калькулятора и будут выведены на консоль.
            изменив это поле, можно поменять поведение программы, например, использовать другой экземпляр
            калькулятора или вместо консоли записать данные в файл.
             */
            s->{
                System.out.println(calculator.getResult(s));
            },
            i->{//тут выводим сообщения в консоль для пользователя
                switch(i){
                    case 0:
                        System.out.println("Enter the first decimal argument");
                        break;
                    case 1:
                        System.out.println("Enter the second decimal argument");
                        break;
                    case 2:
                        System.out.println("Enter * to multiply arguments,- to subtract arguments,+ to summarize arguments, / to divide arguments, pow to raise to a power(if you want to raise to" +
                                " a power the second argument must be not greater than a max value of int and must be a positive number)");
                        break;
                }
            }
    );
    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    };
    public  void setCalculator(Calculator calculator){
        this.calculator=calculator;
    }
    public void work(){
        boolean flag=true;
        Scanner in=new Scanner(System.in);
        while(flag){
            processor.processData();
            System.out.println("Enter C if you want to continue");
            if(!in.nextLine().equals("C")){//если пользователь не ввел "C", метод заканчивает работу
                flag=false;
            }
        }
    }

}
