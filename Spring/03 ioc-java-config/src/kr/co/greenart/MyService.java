package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component 컴퍼넌트의 명확한 구분을 위해서 다른 이름을 사용 할 수 있음
@Service
public class MyService { //MyService는 컴포넌트
	@Autowired 	
	// 제일위에 있으면 '또는'으로 생성자와 세터를 가져오고, 선택하고 싶으면 그 위에 
	// 오토와일드를 적으면 됨
	
	// 생성자, 필드, setter
	// 위의 3가지의 경우에 Autowired를 사용할 수 있다. 그리고 Autowired는 기본값이 true이기 때문에 의존성 주입을 할 대상을
	// 찾지 못한다면 애플리케이션 구동에 실패한다. 그러면 Autowired를 사용할 때의 경우의 수가 존재하는데 각각의 상황에 대해서
	// 정리해보자.
	@Qualifier(value = "mylist")//아이디 값을 주고 해당하는 객체를 찾는 것
	// 인터페이스 여러개 이름 가진거 중에 'mylist' 인터페이스를 쓸거야~~
	private MyDataRepository repo;
	//인터페이스에 대한 의존성이 있음
	
	//이 인터페이스에 대한 객체들을 찾음. (인터페이스 부모 MyDataRepository)
	//인터페이스의 구연체 마다 고유한 이름을 줘서 

	public Iterable<Integer> numberService() {
		return repo.getMyNumbers(); 
	}
}
