package kr.co.greenart;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
	@GetMapping(value="/??.two", produces = "text/plain; charset=utf-8")
	public @ResponseBody String two() {
		//http://localhost:8080/greenart/mapping/zz.two
		//? 개수 만큼의 모든 글자 주소 요청
		//응답헤더 설정은 리스폰스 설정
		return "두글자 매핑";
	}
	
	@GetMapping(value="/*.do", produces = "text/plain; charset=utf-8")
	public @ResponseBody String doURI() {
		//http://localhost:8080/greenart/mapping/asdfasdfasf.do
		//*로 시작하는 것은 모든 글자 주소 요청
		return "do로 끝나는 매핑";
	}
	
	//파라미터가 있고 없고 null 체크 하고??
	//http://localhost:8080/greenart/mapping/ppp?com
	@GetMapping(value="/ppp", params = "com")
	public @ResponseBody String ppp(@RequestParam (defaultValue = "default")String com) {
		//값이 없을 경우 defaultValue로 "default"값을 줄 수 있음
		return com;
	}
	
}
