import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestVar {
    public static void main(String[] args) {
        List<Integer> x=new ArrayList<>();
        TestVar.plus(()->{
            return null;
        });

    }

    public static <T> void plus(Supplier<T> s){
        s.get();
    }

}
