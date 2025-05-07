package startegy;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void PrintValue(ArrayList<Object> arr, Predicate<Object> selector) {
        for(Object v : arr)
            if(selector.test(v))
                System.out.println(v);

        arr.stream().filter(selector).forEach(System.out::println);
    }
    public static void main(String[] args) {

       ArrayList<Object> arr = new ArrayList<Object>();
       arr.add(5);
       arr.add("Pizza");
       arr.add(6);
       arr.add("Peperoni");
       arr.add(7);
       arr.add("cheese");
       PrintValue(arr,p->p instanceof Integer);
       PrintValue(arr,p->p instanceof String);
    }
}
