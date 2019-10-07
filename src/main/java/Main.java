import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SpacedIntegers numbers = new SpacedIntegers(2);
        System.out.println(numbers.add(11));
        System.out.println(numbers.add(20));
        System.out.println(numbers.add(14));
        System.out.println(numbers.getSmallestDistance());
        System.out.println(numbers.toString());
        List<Integer> testAddAllList = new ArrayList<>(Arrays.asList(1,2,3,4,9,10));
        System.out.println(numbers.addAll(testAddAllList));
        System.out.println(numbers.getSmallestDistance());
        System.out.println(numbers.toString());
    }
}
