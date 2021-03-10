import java.lang.annotation.*;

// 研究子类如何继承父类注解
public class InheritedClass {
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface X{
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Y{
}

@X
class A{
    @Y
    public void m(){}

}

class A1 extends A{
    @Override
    public void m(){}
}


@X
interface B{
    @Y
    void m();
}

interface B1 extends B{
    @Override
    void m();
}

class B2 implements B{
    @Override
    public void m() {
    }
}

