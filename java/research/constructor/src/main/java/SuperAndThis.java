public class SuperAndThis {
}

class Super{
    int filed;
    Super(){}
    void myIsSuper(){}

}

class This extends Super{
    This(){
        super();
        int x = filed;
        int y = super.filed;
        super.myIsSuper();
    }
}

