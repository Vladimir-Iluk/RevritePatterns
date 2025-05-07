package wrapper;

import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class Main {
    public static double sum(List<Function<Double,Double>> functions, double basePrice) {
        Function<Double, Double> decorated = functions.stream()
                .reduce(Function.identity(), Function::andThen);
        return decorated.apply(basePrice);
    }
    public static void main(String[] args) {

        Function<Double,Double> PeperoniWrapper = price ->price + 5.0;
        Function<Double,Double> CheeseWrapper = price ->price + 2.5;

        double basePrice = 2.5;
        double finalPrice = sum(List.of(PeperoniWrapper, CheeseWrapper), basePrice);
        System.out.println("Final price: " + finalPrice);

    }
}
