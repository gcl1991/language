package mooc;

public class G868 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static <T extends Throwable> void doWork1(T t)
	{
//		try{
//			
//		}
//		catch (T e) // Error can't catch
//		{
//			
//		}
	}
	
	public static <T extends Throwable> void doWork2(T t) throws T
	{
//		try{
//			
//		}	
//		catch (T e) // Error can't catch
//		{
//			
//		}
	}

}

//class Problem<T> extends Exception {
//	} // Error

