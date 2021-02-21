import java.lang.annotation.*;

// 研究解语法糖，javap次文件的class
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desugar {
    int value() default 0;
}
