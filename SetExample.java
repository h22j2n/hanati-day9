import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * List는 순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 * Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * @author 조희진
 *
 */
public class SetExample {
	
	public static void main(String[] args) {
		Set set = null;
		set = new HashSet(10);
		
		set.add("황의조");
		set.add("손흥민");
		set.add("바나나");
		set.add(100); // Object obj = 1000;
		set.add(new Integer(100));
		set.add(Calendar.getInstance());
		set.add("황의조");
		
		System.out.println("담겨진 갯수 : " + set.size());
		System.out.println("비어있는지 여부 : " + set.isEmpty());
		
		Set boddari = new HashSet();
		boddari.add("AAA");
		boddari.add("BBB");
		boddari.add("CCC");
		
		set.addAll(boddari);
		
		System.out.println("담겨진 갯수 : " + set.size());
		
		boolean result = set.remove("바나나");
		System.out.println("삭제결과 : "+ result);
		
		System.out.println(set.contains("황의조"));
		System.out.println(set.contains(Calendar.getInstance()));
		
		Object[] list = set.toArray();
		for (Object object : list) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Object object = iter.next();
		}
		
		
	}

}
