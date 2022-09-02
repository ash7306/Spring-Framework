package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")//스코프를 프로토 타입으로
@Primary
public class ThirdComponent {
	private String value;
	private int num;
	
	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int num) {
						//밸류로 값 주입도 가능함 
		this.value=value;
		this.num=num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}
