package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.model.User;
import kr.co.greenart.model.UserService;
import kr.co.greenart.model.UserValidator;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// UserValidator를 컴포넌트로 등록함
//	@Autowired
//	private UserValidator validator;

	@Autowired
	private UserService service;

	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "userlist";
	}


	@PostMapping("/user")
//	public String submit(@RequestParam String name, @RequestParam int age) {
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {// 입력에 대한 유효값 같은 것은 고려 하지 않음.
																							// 필드에 집어 넣기만을 위한 것
		// 리퀘스트 바디에 담겨 있을 뿐임 user와 구조는 동알함
		// User user = new User(name, age);
		logger.info("입력정보: " + user.toString());

//		validator.validate(user, errors);

		// 에러가 하나라도 있으면 참을 뱉음
		if (errors.hasErrors()) {
			
			return "userForm";// 포워드를 통해 다시 입력 폼으로
		}
		service.add(user);
		return "redirect:/user/list";
	}

	// 이 컨트롤러 안에서 사용할 모델 객체를 어노테이션으로 설정을 한것임
	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 2);
	}
	
	// 사용자의 입력을 받아서 그 정보를 확인하는 연습
	@GetMapping("/user")
//	public String useForm(Model model) {
	public String useForm(@ModelAttribute("user") User user) {
//		model.addAttribute("user", new User("기본값", 1));
		return "userForm";
	}
}
