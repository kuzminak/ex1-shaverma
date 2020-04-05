import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.*;


public class Application
{
    public static void main(String[] args)
    {
        final List<Integer> prices = Arrays.asList(350, 250, 100, 1600, 500, 150, 150);
        int result = takeMyMoney(prices, 2, 1672);
        System.out.println(result);
    }


    public static int takeMyMoney(List<Integer> prices, int desiredQuantity, int budget)
    {
        ImmutableSet<Integer> set = ImmutableSet.copyOf(prices);
        Set<Set<Integer>> powerSet = Sets.powerSet(set);
        return powerSet.stream().filter(innerSet -> innerSet.size() == desiredQuantity)
                .map(innerSet -> innerSet.stream().mapToInt(Integer::intValue).sum())
                .filter(innerSum -> innerSum <= budget).max(Integer::compareTo).orElseGet(() -> 0);
    }
}
