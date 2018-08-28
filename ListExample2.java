import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Set은 데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스)이다.
 * 순서와 관련 없이 데이터를 관리한다.
 * HashSet이 Set 인터페이스를 구현한 대표적인 클래스이다.
 * @author 조희진
 *
 */
public class ListExample2 {
	
	public static void main(String[] args) {
		Vector list = null;
		list = new Vector();
		// Vector는 인자가 2개 Vector(용량, ) : 용량이 부족하면 배로 늘어남
		// 그래서 Vector(용량, 증가치) => Vector(10,5) => 10개로 만들고 부족하면 5개씩 늘어남
		// vector는 List로 선언하면 안됨 추가된 메소드가 있기때문!
		
		
		list.addElement("황의조");
		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100); // Object obj = 1000;
		list.addElement(new Integer(100));
		list.addElement(Calendar.getInstance());
		list.addElement("황의조");
		
		
		System.out.println("담겨진 갯수 : " + list.size());
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		System.out.println(list.elementAt(0));
		System.out.println(list.removeElement("바나나"));
		
		Enumeration e = list.elements(); //모든 구성요소들을 동기화 처리할때
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			System.out.println(object);
		}

		
	}

}
