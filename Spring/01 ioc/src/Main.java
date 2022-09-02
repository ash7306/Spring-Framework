import mybeans.MyBean;
import mybeans.MyLogic;

public class Main {
	public static void main(String[] args) {
		MyBean obj = new MyBean();
		obj.hello();
		
		//의존성을 가지고 있는 객체를
		//생성자나 세터로 주입을 시켜서 사용
		MyLogic logic = new MyLogic(new MyBean());
		logic.someMethod();
		
		
	}
}
