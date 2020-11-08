@SingleA(a = 5) // 单值非value必须指定参数赋值
@SingleValue(5)
@MultipleValue(a=1,b=1) // 无默认参数必须赋值
public class Assignment {
}

@interface SingleA{
    int a();
}

@interface SingleValue{
    int value();
}

@interface MultipleValue{
    int a();
    int b();
}