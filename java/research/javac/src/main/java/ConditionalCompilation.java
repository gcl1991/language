
/**
 * 观察条件编译.
 * */
public class ConditionalCompilation {
    public static void main(String[] args) {
        if(true){
            // 经过条件编译将仅保留此分支
            System.out.println("block 1");
        }else {
            System.out.println("block 2");
        }
    }
}
