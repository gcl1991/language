import java.io.Serializable;

/**
 * 验证规则2：将不可序列化类的子类序列化
 * */
public class SerialRule2Son extends SerialRule2Father implements Serializable {
    private final int filedInt;
    SerialRule2Son(){
        filedInt = 2;
    }

    public int getFiledInt() {
        return filedInt;
    }

    @Override
    public String toString() {
        return "SerialRule2Son{" +
                "filedInt=" + filedInt +
                '}';
    }
}
