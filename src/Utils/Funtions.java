package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Funtions {

    public static <T> List<T>  fillNumbers(Supplier<T> supplier,int  times){
        List<T> listNums = new ArrayList<>();
       for (int i =0 ;i<times;i++){
            listNums.add((supplier.get()));
       }
       return listNums;
    }

    public static <T> List<T> fillSentences(Supplier<T> supplier,int times){
        List<T> listStrings = new ArrayList<>();
        for (int i = 0; i< times ; i++){
            listStrings.add(supplier.get());
        }
        return listStrings;
    }

    public static <T,R> List<R> elevateNumbers(Function<T,R> function, List<T> listNums){
        List<R> listNumsElevate = new ArrayList<>();
        for (T value:listNums){
            listNumsElevate.add(function.apply(value));
        }
        return  listNumsElevate;
    }

    public static <T> void seeList(Consumer<T> consumer, List<T> listNums){
     for (T value:listNums){
         consumer.accept(value);
     }
    }

    public static <T> List<T>  filterNums(Predicate<T> predicate, List<T> listNums){
        List<T> list = new ArrayList<>();
        for (T value: listNums){
            if (predicate.test(value)){
             list.add(value);
            }
        }

        return list;
    }



}

