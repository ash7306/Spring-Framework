package kr.co.greenart.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
							//이거 긴거 상속 받은 클래스는 @Configuration로 등록된 이너테이션들로 설정가능
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}
	//루트컨피그 클래스를 만들면 그역할을 대신하는 root-context.xml 지워도 된다
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	//xml 필터 인코딩 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] { encodingFilter };
	}
}
