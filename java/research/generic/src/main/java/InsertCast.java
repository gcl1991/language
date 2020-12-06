
/**
 * 用于测试javac自动插入类型转换.
 *
 * javac编译后使用反汇编工具,查看反汇编后代码,以观察javac deSugar阶段自动插入类型转换工作。
 * */
public class InsertCast {

    public static void main(String[] args) {
        Demo<String> demo = new Demo<>("demo");
        System.out.println(demo.filed);
        System.out.println(demo.getFiled());
    }
    public static class Demo<T>{
        T filed;
        Demo(T filed){
            this.filed = filed;
        }

        public T getFiled() {
            return filed;
        }
    }
}
