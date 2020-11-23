// 使用ordinal实现swith
public class SwithEnum {
    enum E{
        E1,E2
    }
    public static void contains(E x){
        switch (x){
            case E1:
                System.out.println("E1");
            case E2:
                System.out.println("E2");
            default:
                System.out.println("no");
        }
    }
}
