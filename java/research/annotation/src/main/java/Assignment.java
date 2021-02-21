/**
 * 研究注解赋值相关
 * */
@SingleNoValue(a = 1) // 单值非value必须指定参数赋值
@SingleValue(1)
@MultipleValue(a=1,b=1) // 无默认参数必须赋值
@SingleObject("") // 对象赋值不可为null
public class Assignment {
}

@interface SingleNoValue{
    int a();
}

@interface SingleValue{
    int value();
}

@interface MultipleValue{
    int a();
    int b();
}

@interface SingleObject{
    String value() default ""; // 对象默认值不可为null
}
