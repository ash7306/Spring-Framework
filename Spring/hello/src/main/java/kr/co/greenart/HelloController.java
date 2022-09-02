package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	//헬로라는 주소를 요청하면 맵핑을 
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		//string 으로 반환한다면 뷰로 반환할거라고 인식함
		return "hello"; 
	}
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi() {
		return "home"; 
	}
	
	//하나의 컨트롤에서 여러개의 메소드로  존재 한다
}
