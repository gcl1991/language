import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 研究注解继承
 * */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritAnnotation {

}
// sub无法继承Inherited，因为已经继承了Annotation
@interface sub {
}
