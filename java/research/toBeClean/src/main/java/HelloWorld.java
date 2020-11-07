package learn_java;
/**
 * JAVA 注釋學習 注釋會被編譯器忽略
 * 文檔注釋,文檔注釋會通過javadoc，生成文檔，不允許嵌套
 * 只有類，無函數，标识符區分大小寫
 */
//必须有主方法，这是程序入口,每个源代码中可以有多个类，但是public类只能有一个，且类名和文件
public class HelloWorld{
    /*
    多行注釋，不允許嵌套
    ctrl shift /快捷鍵
     */
    // 單行注釋 ctrl /快捷鍵
    public static void main(String[] args){
        //必须有 String[] args
        System.out.println("hello world"); // 语句以分号结束
        System.
        out.
        println("hello world"); // ok，这是一条语句
    }
}

// 不建议一个源代码中有多个类，最好一个类一个源代码文件，每个类都是public类
class HelloTsingHua{
    public static void main(String[] args){
        System.out.println("hello Tsing hua");
    }
}