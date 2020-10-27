package mooc;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

public class G866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] s1 = minmax1() ; // error
//		String[] s2 = minmax2() ;
		String[] s3 = minmax3(String[]::new) ;
		String[] s4 = minmax4(String[].class);
		System.out.println(String[].class.getComponentType());
		System.out.println(String[].class);
	}
	
//	public static <T extends Comparable > T[] minmax1() {
//		T[] mm = new T[2]; // error
//		return mm;
//		}
	
	public static <T extends Comparable > T[] minmax2() {
		Object[] mm = new Object[2];
		return (T[]) mm;
		}
	
	public static <T extends Comparable > T[] minmax3(IntFunction<T[]> constr) {
		T[] mm = constr.apply(2);
		return mm;
		}
	
	public static <T extends Comparable> T[] minmax4(Class<T[]> a){
		T[] mm = (T[]) Array.newInstance(a.getComponentType(), 2);
	return mm;
	}
}