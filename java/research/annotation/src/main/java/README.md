* 自带注解
* @Override表示继承与覆盖 自带普通注解
* @Deprecated表示废弃 自带普通注解
* @SuppressWarnings压制警告 自带普通注解
* @SafeVarargs不会对不定项参数做危险动作 自带普通注解
* @FunctionInterface声明函数式接口 自带普通注解
*
* 元注解：
* @Target 设置目标范围SOURCE/CLASS/RUNTIME
* @Retention 设置保持性（注解可以保留的范围）包类/接口枚举注解/注解ANNOTATION_TYPE/构造器/方法/字段/局部变量/
* @Documented 文档（标注此注解可以今日javadoc文档）
* @Inherited 注解继承（表示注解可以被继承）
* @Repeatable 此注解可以重复修饰（表示注解可以重复应用）
*
* 成员变量：
* 可以定义8中基本类型 byte short int long float double char boolean
* String,Class,枚举类型,注解类型，及以上类型的数组
* 详细内容见JSL9.6.4

