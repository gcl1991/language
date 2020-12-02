package methods;

/**
 * 为所有已公开的API元素编写文档注释.
 *
 * 运行 javadoc -tag "implSpec:a:Implementation Requirements:" -encoding utf-8 th56.java -d C:\Users\longlong\Desktop\doc
 *
 * @author   gcl
 *           作者用在类中
 * @version  1.0
 *           当前版本描述,用在类中
 */
public class th56 {
    public static class Father{
        /**
         * 父类方法ms.
         * */
        public void methodF(){

        }
    }
    public static class Son extends Father{
        /**
         * 域注释：字段使用名字短语描述.
         * */
        public static int filedS;
        /**
         * 方法注释:方法使用动词短语描述; 以.结束,如果想包含.应使用{@literal M.S.}.
         *
         * <p> 方法的文档注释应该简洁地描述方法与其客户端之间的契约<br>
         *     契约: 前置条件+后置条件+副作用</p>
         *
         * @param paramS
         *        解释参数的名词短语
         *
         * @return 解释返回值的名字短语
         *
         * @throws NullPointerException if 隐式描述前置条件(条件违反)
         *
         * */
        public int methodS(int paramS) {
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
            return 0;
        }

        /**
         * 常用标记说明.
         * <ul>
         * <li><b>link</b>
         * <p> {@link java.lang.Object 规则与see相同,用于指向其他类或方法的超链接}</p></li>
         *
         * <li><b>code</b>
         * <p>code 显示简短等宽代码语句,同时可以显示实体符号,但是code无法保留空格和换行格式，需要使用pre{@code x > 0}</p></li>
         *
         * <li><b>literal</b>
         * <p>literal用于显示实体符号{@literal < > &}<br></p></li>
         *
         * <li><b>pre</b><br>
         * pre用于显示多行代码,将保留换行空行和格式，每个代码块使用code包含
         * <pre>{@code
         * for(int i=0; i<10; i++){
         *     System.out.println(i);
         * }}
         * {@code
         * for(int i=0; i<10; i++){
         *     System.out.println(i);
         * }}
         * </pre>
         * </li>
         * </ul>
         * @implSpec 自用模式
         *           描述了方法与其子类之间的契约
         *
         * @since 1.0（引入特性的版本描述）
         * @see <a href="https://www.oracle.com/cn/technical-resources/articles/java/javadoc-tool.html">lable1</a>
         * @see java.lang.Object#equals(Object) label2
         * @see "lable3"
         * @deprecated 使用X方法代替此方法，此说明自动提升到第一行
         *
         * */
        public void methodMark(){
        }

        /**
         * 继承父类方法注释.
         * <p>以下为父类方法注释:<br>{@inheritDoc}</p>
         * */
        @Override
        public void methodF() {
            super.methodF();
        }
    }
}
