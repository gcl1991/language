package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class MyMapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        // error split
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .forEach(System.out::println);
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        // flat map
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        List< Integer> numbers1 = Arrays. asList( 1, 2, 3);
        List< Integer> numbers2 = Arrays. asList( 3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i->numbers2.stream().map(j->new int[]{i, j}))
                .collect(toList());
        List<int[]> pairs1 = numbers1.stream()
                .flatMap(i->numbers2.stream().map(j->new int[]{i, j}))
                .filter(pair->(pair[0]+pair[1])%3==0)
                .collect(toList());
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i->numbers2.stream().filter(j->(i+j)%3 == 0).map(j->new int[]{i, j}))
                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        System.out.println();
        pairs1.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        System.out.println();
        pairs2.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

    }

}
