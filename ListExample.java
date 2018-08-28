import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Set은 데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스)이다.
 * 순서와 관련 없이 데이터를 관리한다.
 * HashSet이 Set 인터페이스를 구현한 대표적인 클래스이다.
 * @author 조희진
 *
 */
public class ListExample {
	
	public static void main(String[] args) {
		List list = null;
		list = new ArrayList();
		
		list.add("황의조");
		list.add("손흥민");
		list.add("바나나");
		list.add(100); // Object obj = 1000;
		list.add(new Integer(100));
		list.add(Calendar.getInstance());
		list.add("황의조");
		
		System.out.println("담겨진 갯수 : " + list.size());
		// 7갠데 5개 나옴(중복된 것이 두개라서)
		// set은 담기전에 같은 것이 있나 찾아봄
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		Set boddari = new HashSet();
		boddari.add("AAA");
		boddari.add("BBB");
		boddari.add("CCC");
		
		list.addAll(boddari);
		
		System.out.println("담겨진 갯수 : " + list.size());
		
		boolean result = list.remove("바나나");
		System.out.println("삭제결과 : "+ result);
		
		System.out.println(list.contains("황의조"));
		System.out.println(list.contains(Calendar.getInstance()));
		
		Object[] lists = list.toArray();
		for (Object object : lists) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object object = iter.next();
		}
		
		// List에 추가된 규약 메소드들 ...
		list.add(0,"조희진");
		System.out.println(list.get(0));
		System.out.println(list.remove(0));
		list.set(0, "황희찬");
		System.out.println(list.get(0));
		
		System.out.println(list.size());
		List l = list.subList(0, 3);
		for (Object object : l) {
			System.out.println(object);
		}
		
	}

}
