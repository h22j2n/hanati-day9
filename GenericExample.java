import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("조희진");
		list.add("박보검");
		list.add("양의지");
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String string = iter.next();
			System.out.println(string);
		}
		
		for (String string : list) {
			System.out.println(string);
		}
		
	}

}
