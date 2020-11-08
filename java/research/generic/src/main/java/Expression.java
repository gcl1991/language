import java.io.Serializable;

public class Expression<T extends Comparable<T> & Serializable> implements Serializable {
    T lower;
    T upper;
    public Expression(T f, T s){
        lower = f;
        upper = s;
    }

    public T getLower() {
        return lower;
    }
}
