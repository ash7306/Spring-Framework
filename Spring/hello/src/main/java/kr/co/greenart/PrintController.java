package kr.co.greenart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// "/print" GET 요청 - > text 입력가능 (view)form.jsp으로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 foward
@Controller
@RequestMapping(value = "/print")//맵핑을 상단에 해주면 다 적용 됨
public class PrintController {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);

	//1. print를 주소창에 치면 GET방식의 print.jsp로 포워드 시켜준다
	//@RequestMapping(value = "/print", method = RequestMethod.GET)
	@GetMapping
	public String req() {
		return "form";
	}
	
	//2. form에서 작성한 텍스트, name="param"으로 전달받아서 POST방식으로 print.jsp로 포워드 시켜준다
	//그 전달받은 param 값을 model에 "text"라는 이름으로 담아준다 
	//그 후에 print.jsp 에서 text를 출력하면 끝
	//@RequestMapping(value = "/print", method = RequestMethod.POST)
	
	@PostMapping
	public String req2(@RequestParam String param, Model model) {
		//HttpServletRequest request 로 받아와서 사용해도 된다.
		
		
		logger.info(String.valueOf(param));
		model.addAttribute("text", param);
		return "print";
	}
	
	@GetMapping("/sub") // 상단 맵핑 주소 다음에 맵핑 주소로 감 ==> /print/sub
	public @ResponseBody String sub() {
		//리스폰스 바디는 뷰 이름으로 반환이 아니라 응답 바디(바디 내용으로)로 그냥 문자열로 보냅니다~
		return "/print/sub";
	}
}
