package lambdasinaction.chap9;

import java.util.List;

public class Utils{
    public static void paint(List<Resizable> res){
        res.forEach(r -> { r.setAbsoluteSize(42, 42); });

        //TODO: uncomment, read the README for instructions
        res.forEach(r -> { r.setRelativeSize(2, 2); });
    }

}
