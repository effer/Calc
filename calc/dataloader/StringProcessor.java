package calc.dataloader;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.function.Consumer;

public class StringProcessor implements DataProcessor {
    private Scanner in;
    protected final int stringCount;//по сколько строк данных будет передаваться на обработку
    protected final Consumer<String[]> worker;//метод, которому передаются полученные данные
    protected final Consumer<Integer> delayConsumer;//метод, который выполняется между получением новых строк
    protected final List<String> stringList=new LinkedList<>();
    public StringProcessor(Consumer<String[]> consumer,Consumer<Integer> delay,InputStream inputStream,int count){//ввод можно делать не только из консоли, но и из файла или сокета.
        //это нужно для возможности расширения.
        this.in=new Scanner(inputStream);
        this.worker=consumer;
        this.stringCount=count;
        this.delayConsumer=delay;
    }
    public StringProcessor(Consumer<String[]> consumer,Consumer<Integer> delay,InputStream inputStream){//по умолчанию обрабатываем по 3 строки
        this.in=new Scanner(inputStream);
        this.worker=consumer;
        this.stringCount=3;
        this.delayConsumer=delay;
    }
    public StringProcessor(Consumer<String[]> consumer,Consumer<Integer> delay){//по умолчанию обрабатываем по 3 строки
        this.in=new Scanner(System.in);//и читаем данные из потока System.in
        this.worker=consumer;
        this.stringCount=3;
        this.delayConsumer=delay;
    }
    @Override
    public void processData(){
        for(int i=0;i<this.stringCount;i++){
            delayConsumer.accept(i);
            stringList.add(in.nextLine());//получаем данные из потока ввода
        }
        String [] strings=new String[this.stringCount];
        this.stringList.toArray(strings);
        worker.accept(strings);//обрабатываем полученные данные
        stringList.clear();
    }

}
