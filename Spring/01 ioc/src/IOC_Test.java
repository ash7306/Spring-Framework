import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		MyLogic logic = context.getBean(MyLogic.class);
		logic.someMethod();
		MyStatefulObj third = context.getBean(MyStatefulObj.class);
		System.out.println(third.toString());
		
		third.setName("new-name");
		third.setNumber(200);
		
		MyStatefulObj oneMoretime = context.getBean(MyStatefulObj.class);
		System.out.println(oneMoretime.toString());
		//값이 바껴 있다 왜? 같은 인스턴스 참조기 때문에 값이 변경 됨
		//ex)한개의 객체를 유지해서 사용 하는 - 싱글턴 패턴 을 사용 함
		
		System.out.println(third == oneMoretime);//flase가 뜸 
		//myconfig 에서 scope="prototype" 설정을 하면 
		
		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString());
		
//		// 이거 만들어서 관리해라 xml로
//		MyBean b = context.getBean(MyBean.class);
//		// ioc 콘테이너에 보관하다가 달라고 함 //class 형식으로
//		b.hello();
//		
//		MyBean b2 = (MyBean) context.getBean("first");
//		MyBean b3 = context.getBean("first", MyBean.class);
//		// id 값으로 달라고 하는 것도 가능함
//		b2.hello();
//		b3.hello();
//		
//		System.out.println(b == b2);// 참조가 같은지 - 똑같은 인스턴스에 대한 참조를 물음
	}
}
