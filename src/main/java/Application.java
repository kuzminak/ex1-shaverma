import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Application
{
    public static void main(String[] args)
    {
        int result;
        final List<Integer> prices = Arrays.asList(350, 250, 100, 1600, 500, 150, 150);
        result = takeMyMoney(prices, 2, 1672);
        System.out.println("takeMyMoney: " + result);

        final List<Integer> rods = Arrays.asList(1, 2, 3, 6);
        result = getHeight(rods);
        System.out.println("getHeight: " + result);
    }


    public static int takeMyMoney(List<Integer> prices, int desiredQuantity, int budget)
    {
        ImmutableSet<Integer> set = ImmutableSet.copyOf(prices);
        Set<Set<Integer>> powerSet = Sets.powerSet(set);
        return powerSet.stream().filter(innerSet -> innerSet.size() == desiredQuantity)
                .map(innerSet -> innerSet.stream().mapToInt(Integer::intValue).sum())
                .filter(innerSum -> innerSum <= budget).max(Integer::compareTo).orElseGet(() -> 0);
    }


    public static int getHeight(List<Integer> rods)
    {
        ImmutableSet<Integer> set = ImmutableSet.copyOf(rods);
        int halfHeight = (int) Math.floor(rods.stream().reduce(0, Integer::sum) / 2);
        Set<Set<Integer>> powerSet = Sets.powerSet(set);

        Map<Integer, Long> heightGroupingMap = powerSet.stream()
                .map(innerSet -> innerSet.stream().mapToInt(Integer::intValue).sum())
                .filter(innerSum -> innerSum <= halfHeight)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return heightGroupingMap.entrySet().stream().filter(entry -> entry.getValue() == 2).map(entry -> entry.getKey())
                .max(Integer::compareTo).orElseGet(() -> 0);
    }
}
