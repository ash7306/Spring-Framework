package mybeans;

import org.springframework.stereotype.Component;

@Component(value = "first")//컴퍼논트 라는 어노테이션으로 등록 시킬 수 있음
public class FirstComponent {
	public void hello() {
		System.out.println("어노테이션으로 Bean 설정하기 연습");
	}
}
