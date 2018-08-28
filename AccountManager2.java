import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 조희진
 *
 */
public class AccountManager2 {

	private Vector<Account> accounts;
	// count 가 필요없음 size()가 있으니까

	AccountManager2(int capacity) {
		accounts = new Vector<Account>(capacity, 5);
	}

	public Vector<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector<Account> accounts) {
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
	public List<Account> list() {
//		return accounts; 로 해도 됨
		List<Account> l = new ArrayList<Account>(accounts.size());
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account account = e.nextElement();
			l.add(account);
		}
		return l;
	}

	/**
	 * @param accountNum 계좌번호
	 * @return 검색결과
	 */
	public Account get(String accountNum) {
		Enumeration<Account> e = accounts.elements();
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
	public List<Account> search(String accountOwner) {
		List<Account> list = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
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
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account object = (Account) e.nextElement();
			if(object.getAccountNum().equals(accountNum)) {
				return accounts.removeElement(object);
			}	
		}
		return false;
	}

	public static void main(String[] args) {
		AccountManager2 manager = new AccountManager2(100);
		Account account = new Account("1111-2222-3333", "조희진", 1111, 10000);
		manager.add(account);
		manager.add(new Account("2222-2222-3333", "양의지", 1111, 200000));
		manager.add(new Account("3333-2222-3333", "박건우", 1111, 300000));
		manager.add(new Account("4444-2222-3333", "오재원", 1111, 400000));
		manager.add(new Account("5555-2222-3333", "박보검", 1111, 1000000));
		manager.add(new Account("6666-2222-3333", "박보검", 1111, 2000000));

		List<Account> list = manager.list();

		for (Object object : list) {
			System.out.println(object);
		}

		if (manager.get("1111-2222-3333") == null) {
			System.out.println("해당하는 계좌가 없습니다.");
		} else
			System.out.println(manager.get("1111-2222-3333").toString());
		List<Account> search = manager.search("박보검");
		
		System.out.println();
		if (search == null) {
			System.out.println("해당하는 계좌가 없습니다.");
		} else {
			for (Object account2 : search) {
				System.out.println(account2);
			}

		}
		boolean remove = manager.remove("1111-2222-3333");
		if (remove == false) {
			System.out.println("삭제 실패!");
		} else
			System.out.println("삭제 완료!");
	}

}
