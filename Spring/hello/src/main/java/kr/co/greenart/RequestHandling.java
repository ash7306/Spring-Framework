package kr.co.greenart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);

	@RequestMapping(value = "/req", method = RequestMethod.GET)
//	public String req(HttpServletRequest request) {
//		String param = request.getParameter("param");
//		String param2 = request.getParameter("param2");
	public String req(@RequestParam int param, @RequestParam int param2, Model model) {

		logger.info(String.valueOf(param + param2));
		// http://localhost:8080/greenart/req?param=1&param2=2
		// 콘솔엔 3

		// 어트리뷰트르 관리하는 하나의 Map 모델
		model.addAttribute("result", param + param2);
		return "plusResult";
	}
}
