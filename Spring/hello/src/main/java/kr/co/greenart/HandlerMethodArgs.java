package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/handle")
public class HandlerMethodArgs {
	@GetMapping("/cookie")//쿠키값
	public @ResponseBody String args(@CookieValue(name = "JSESSIONID") String jsessionid) {
		return jsessionid;
	}
	
	@GetMapping("/header")//헤더값
	public @ResponseBody String head(@RequestHeader ("Accept") String accept) {
		return accept;
		
	}
	
	@GetMapping("/{path1}/{path2}")//경로값
	public @ResponseBody String paths(@PathVariable String path1, @PathVariable String path2) {
		//주소 자체를 변수처럼 사용 하기 위해서 사용자 요청에 따라서 입력한 두 값을 불러옴
		return path1 + path2;
	}

}
