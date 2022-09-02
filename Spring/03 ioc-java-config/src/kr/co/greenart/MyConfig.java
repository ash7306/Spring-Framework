package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//설정을 가지고 있는 컴퍼넌트
@ComponentScan(value = "kr.co.greenart")//패키지를 적어줘서 스캔을 해라
public class MyConfig {
	@Bean
	//빈이라는 어노테이션 아래 등록하고자 하는 빈의 타입을 적어 주면 됨
	public List<Integer> myList() {
		// 빈의 아이디가 메소드 이름으로 작성
		return new ArrayList<>(Arrays.asList(10,2,3,4,5));//내가 원하는 객체를 만들고 반환만
		//메소드를 등록하는게 아니고 리턴값인 ArrayList<>(Arrays.asList(1,2,3,4,5));을 등록하는 것임
	}
	
	@Bean
	public Set<Integer> mySet() {
		return new HashSet<Integer>(Arrays.asList(6,7,3,4,5));
	}
}
