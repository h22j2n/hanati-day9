# 하나금융티아이 20180828

## 예외

- 프로그램이 shut down 안되고 예외결과 보여주고~

- try 와 finally로만 쓸 수도 있다.

- 예외처리는 compile checked exception들만

- throws는 예외 처리 / throw는 예외 강제 발생

- 사용자 정의 예외 클래스 : 잘 알려진 예외가 아닌 프로그램 로직 상 필요한 더 구체적인 예외처리를 위해 개발자가 직접 예외클래스를 만들어 사용할 수 있다.

  - 필수는 아님

  ``` java
  public class AccountException extends Exception {
  	//String message;
  	
  	private int errorCode;	
  	
  	public AccountException() {
  		this("계좌처리 중 예기치 않은 에러가 발생하였습니다.", -9);
  		
  	}
  
  	public AccountException(String arg0, int errorCode) {
  		super(arg0);
  		this.errorCode = errorCode;
  	}
  
  	public int getErrorCode() {
  		return errorCode;
  	}
  
  	@Override
  	public String toString() {
  		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
  	}
  	
  	
  	
  
  }
  ```

  ``` java
      public long deposit(long money)throws AccountException{
      	if(money <= 0) {
      		throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.",-1);
      	}
          restMoney += money;
          return restMoney;
      }
      public long withdraw(long money) throws AccountException{
      	if(money <= 0) {
      		throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.",-1);
      	}
      	if(money > restMoney) {
      		throw new AccountException("잔액이 부족합니다.",-2);
      	}    	
          restMoney -= money;
          return restMoney;
      }
  ```

  ``` java
  try {
  	money = account.deposit(100000);
  	System.out.println("입금 후 잔액: "+money);
  //	account.deposit(-5000);
  				
  	money = account.withdraw(500000);
  } catch (AccountException e) {
  	System.out.println(e.getMessage());
  }
  
  /*출력
  입금 후 잔액: 200000
  잔액이 부족합니다.
  */
  ```

  

## 자료구조(Data Structure)

- 대량의 데이터를 효율적으로 저장, 관리하고 검색 수행 속도를 향상시키기 위한 데이터 저장 구조
- 자료구조의 중요성 때문에 대부분의 프로그래밍 언어에서는 자주 사용하는 자료구조를 표현한 기본 라이브러리를 제공하며, Java 언어 또한 자료구조를 표현한 API를 제공하는데 이를 **Collection API** 또는 **Collection Framework**라 부른다.
  - **Collection API(Framework)**  
    - 일관된(표준화) 사용을 위해 자바 인터페이스를 이용하여 다양한 자료구조에 대한 기본 규약을 명세하고 있으며, 또한 기본 규약을 준수하는 많은 자료구조 클래스들을 제공
    - ![그림1](https://github.com/h22j2n/hanati-day9/blob/master/img/%EA%B7%B8%EB%A6%BC1.png)
    - 더 있지만 일단 이정도만 필수로 알아두기!
    - list는 순서가 있어서 같은 것 집어넣을 수 있음
    - Queue 는 양쪽이 다 뚫려 있음 Stack이랑 반대 개념

## Collection API

### Set

- ``` java
  import java.util.Calendar;
  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.Set;
  
  /**
   * Set은 데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스)이다.
   * 순서와 관련 없이 데이터를 관리한다.
   * HashSet이 Set 인터페이스를 구현한 대표적인 클래스이다.
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
  		// 7갠데 5개 나옴(중복된 것이 두개라서)
  		// set은 담기전에 같은 것이 있나 찾아봄
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
  /* 출력
  담겨진 갯수 : 5
  비어있는지 여부 : false
  담겨진 갯수 : 8
  삭제결과 : true
  true
  false
  3
  AAA
  3
  CCC
  3
  BBB
  100
  java.util.GregorianCalendar[time=1535437628424,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=7,WEEK_OF_YEAR=35,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,DAY_OF_YEAR=240,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=27,SECOND=8,MILLISECOND=424,ZONE_OFFSET=32400000,DST_OFFSET=0]
  3
  손흥민
  3
  황의조
  */
  ```



### List

- 순서가 있고 중복된 값 허용

- 대부분의 프로그램은 동기방식 / 비동기방식(일을 하는 동안 다른데서 일함)도 있긴 함 

- Vector는 무거움.. 동기처리를 해야해서 / 비동기방식!

- ArrayList는 동기처리가 안되어있음 / 담아서 운송하는 역할은 ArrayList가 유용

  ``` java
  // ArrayList
  
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
  /*
  담겨진 갯수 : 7
  비어있는지 여부 : false
  담겨진 갯수 : 10
  삭제결과 : true
  true
  false
  3
  황의조
  3
  손흥민
  100
  100
  java.util.GregorianCalendar[time=1535438056865,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=7,WEEK_OF_YEAR=35,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,DAY_OF_YEAR=240,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=34,SECOND=16,MILLISECOND=865,ZONE_OFFSET=32400000,DST_OFFSET=0]
  3
  황의조
  3
  AAA
  3
  CCC
  3
  BBB
  조희진
  조희진
  황희찬
  9
  황희찬
  손흥민
  100
  */
  ```

  ``` java
  // Vector
  
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
  
  /*
  담겨진 갯수 : 7
  비어있는지 여부 : false
  황의조
  true
  황의조
  손흥민
  100
  100
  java.util.GregorianCalendar[time=1535438892913,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=7,WEEK_OF_YEAR=35,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,DAY_OF_YEAR=240,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=48,SECOND=12,MILLISECOND=913,ZONE_OFFSET=32400000,DST_OFFSET=0]
  황의조
  */
  ```

- Vector를 이용한 AccountManager

  ``` java
  import java.util.ArrayList;
  import java.util.Enumeration;
  import java.util.List;
  import java.util.Vector;
  
  /**
   * Vector를 이용한 은행계좌 관리
   * 
   * @author 조희진
   *
   */
  public class AccountManager2 {
  
  	private Vector accounts;
  	// count 가 필요없음 size()가 있으니까
  
  	AccountManager2(int capacity) {
  		accounts = new Vector(capacity, 5);
  	}
  
  	public Vector getAccounts() {
  		return accounts;
  	}
  
  	public void setAccounts(Vector accounts) {
  		this.accounts = accounts;
  	}
  
  	/**
  	 * 계좌 추가
  	 * 
  	 * @param account 추가할 계좌
  	 */
  	public void add(Account account) {
  		accounts.addElement(account);
  	}
  
  	// 실제 들어있는 것만 반환
  	/**
  	 * @return 계좌 목록
  	 */
  	public List list() {
  //		return accounts; 로 해도 됨
  		List l = new ArrayList(accounts.size());
  		Enumeration e = accounts.elements();
  		while (e.hasMoreElements()) {
  			Object account = e.nextElement();
  			l.add(account);
  		}
  		return l;
  	}
  
  	/**
  	 * @param accountNum 계좌번호
  	 * @return 검색결과
  	 */
  	public Account get(String accountNum) {
  
  		Enumeration e = accounts.elements();
  		Account object = null;
  		while (e.hasMoreElements()) {
  			object = (Account) e.nextElement();
  			if (accountNum.equals(object.getAccountNum())) {
  				return object;
  
  			}
  		}
  
  		return null;
  	}
  
  	// 이름으로 검색
  	/**
  	 * @param accountOwner 소유주
  	 * @return 검색결과
  	 */
  	public List search(String accountOwner) {
  		List list = new ArrayList();
  		Enumeration e = accounts.elements();
  		while (e.hasMoreElements()) {
  			Account object = (Account) e.nextElement();
  			if (object.getAccountOwner().equals(accountOwner)) {
  				list.add(object);
  			}
  		}
  
  		return list;
  	}
  
  	/**
  	 * @param accountNum 삭제할 계좌번호
  	 * @return 결과 성공/실패
  	 */
  	public boolean remove(String accountNum) {
  		boolean ck = false;
  		Enumeration e = accounts.elements();
  		while (e.hasMoreElements()) {
  			Account object = (Account) e.nextElement();
  			if(object.getAccountNum().equals(accountNum)) {
  				accounts.removeElement(object);
  				ck = true;
  			}	
  		}
  		return ck;
  	}
  }
  ```

### Generic(제네릭)

- 데이터타입을 설정해주기위한 시그너처역할

- Vector<String> : 이 벡터는 String만 담을 수 있는 Class / 기능을 축소시킨 것/ Vector : Generic Class , String : Generic Type

  ``` java
  Vector vec = new Vector();
  vec.addElement("Apple"); // 내부적으로 요소들을 Object형으로 관리
  vec.addElement("Banana"); 
  vec.addElement("Orange"); 
  String temp; //toUpperCase() 메서드를 사용하기 위해서 String 선언
  for(int i=0; i<vec.size(); i++){ 
     temp = vec.get(i);        //컴파일시 에러 발생
     temp = (String)vec.get(i);//Object형을 String형으로 Down Casting
     System.out.println(temp.toUpperCase()); 
  }
  ```

- Generic Type을 내가 만들 수 있음

  ``` java
  public class GenericClass<T> {
       private T member;
       
       public GenericClass(T member){
            this.member = member;
       }
       public void setMember(T member){
            this.member = member;
       }
       public T getMember(){
            return member;
       }
       
       public static void main(String[] args) {
            // Generic 클래스 사용
            GenericClass<String> generic = new GenericClass<String>("김기정”);
            generic.setMember(“김기정”);
            String member = generic.getMember());
            System.out.println(member);
       }
  }
  ```

  ``` java
  /**
   * 제너릭 클래스
   * @author 조희진
   *
   */
  public class Student<T> {
  	private String name;
  	private T ssn;
  	
  	public Student() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  
  	public Student(String name, T ssn) {
  		super();
  		this.name = name;
  		this.ssn = ssn;
  	}
  
  	public String getName() {
  		return name;
  	}
  
  	public void setName(String name) {
  		this.name = name;
  	}
  
  	public T getSsn() {
  		return ssn;
  	}
  
  	public void setSsn(T ssn) {
  		this.ssn = ssn;
  	}
  	
  	public static void main(String[] args) {
  		Student<String> student = new Student<String>("조희진","111");
  		System.out.println(student.getSsn());
  		student.setSsn("1234");
  		System.out.println(student.getSsn());		
  	}
  
  }
  
  /*
  111
  1234
  */
  ```

  ``` java
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
  /*
  조희진
  박보검
  양의지
  */
  ```

  

