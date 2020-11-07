package mooc;

public class G8610<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new G8610<String>().equals("s"));

	}
	
//	public boolean equals(T value) {
//		return false;  //error
//	}

}


//class Employee1 implements Comparable<String>{
//
//	@Override
//	public int compareTo(String arg) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//}
class Manager1 implements Comparable<Integer>{

	@Override
	public int compareTo(Integer arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	@Override
//	public int compareTo(String arg0) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
} // error

class Employee2 implements Comparable{

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class Manager2 extends Employee2 implements Comparable{
} // error
