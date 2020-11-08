import java.util.function.Function;

public class Lambda {
    String header = "h";
    Function<Object,String> f = obj->obj.toString()+header;
}
