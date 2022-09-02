package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	private FirstComponent need;
	
	@Autowired//bean은 타입으로써 빈을 찾을수가 있는데 
	//오토와이얼드 해당 타입의 빈을 찾아서 알아서 의존성을 주입 시켜 준다.
	public SecondComponent(FirstComponent need) {
		super();
		this.need = need;
	}

	public void setNeed(FirstComponent need) {
		this.need = need;
	}

	public void myServiceMethod() {
		System.out.println("의존성이 필요함.");
		need.hello();
	}
}
