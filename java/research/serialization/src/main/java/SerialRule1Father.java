import java.io.Serializable;

public class SerialRule1Father implements Serializable {
    private final int filedInt;

    public SerialRule1Father() {
        filedInt = 1;
    }

    public int getFiledInt() {
        return filedInt;
    }
}
