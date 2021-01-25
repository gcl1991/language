package classes;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class th18Test {
    @Test
    public void testExtends(){
        th18.InstrumentedHashSet<String> s = new th18.InstrumentedHashSet<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

    @Test
    public void testComposition(){
        th18.InstrumentedSet<String> s = new th18.InstrumentedSet<>(new HashSet<>());
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
