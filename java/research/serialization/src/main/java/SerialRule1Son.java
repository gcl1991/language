/**
 * 验证规则1：可序列化的子类皆可序列化
 * */
public class SerialRule1Son extends SerialRule1Father{
    private final int filedInt;
    SerialRule1Son(){
        filedInt = 2;
    }

    public int getFiledInt() {
        return filedInt;
    }

    @Override
    public String toString() {
        return "SerialRule1Son{" +
                "filedInt=" + filedInt +
                '}';
    }

}
