package mooc;


public class G884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxminBonus(new Pair<Employee>());

	}
	
	public static void maxminBonus(Pair<? super Manager> result) {
		System.out.println("maxminBonus:"+result);
		swap(result);
		swapHelper(result);
	}
	
	public static void swap(Pair<?> p) {
		System.out.println("swap:"+p);
		swapHelper(p);
	}
	
	public static <T> void swapHelper(Pair<T> p) {
		System.out.println("swapHelper:"+p);
	}
}


class Pair<T>{
}


class Employee{
	
}


class Manager extends Employee{
	
}
