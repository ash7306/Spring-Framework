package kr.co.greenart.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
		//유저타입 검사만
	}

	@Override
	public void validate(Object target, Errors errors) {
		//유효성 체크, 타겟이라는 친구가 유효성 체크를 할 객체
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name-empty", "이름을 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"age", "age-empty", "나이를 입력하세요.");
	
		User user = (User) target;
		if (user.getName().length() > 5) {
			errors.rejectValue("name", "name.tooli", "이름이 너무 깁니다.");
		}
		if (user.getAge() > 200) {
			errors.rejectValue("age", "name.tooli", "나이 범위를 초과.");
		}
		
	}
	
}
