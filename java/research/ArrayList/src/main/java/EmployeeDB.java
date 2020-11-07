import java.util.ArrayList;

public class EmployeeDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> s = new ArrayList<>();
		s.add("1");
		s.add("2");
		EmployeeDB e = new EmployeeDB();
		e.update(s);
		System.out.println(e.s);
		s.addAll(e.s);
		System.out.println(s);
		ArrayList<String> result = (ArrayList) e.s;
		System.out.println(s.getClass());
	}
	private ArrayList s = new ArrayList();
	
	public boolean update(ArrayList list) {
		boolean is_ok = this.s.addAll(list);
		return is_ok;
	}

}
