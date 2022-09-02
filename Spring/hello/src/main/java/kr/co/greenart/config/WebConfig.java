package kr.co.greenart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//servlet-context.xml 설정
@Configuration
@EnableWebMvc
@ComponentScan("kr.co.greenart")
//<context:component-scan base-package="kr.co.greenart" />
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
								//src 아래 폴더 이름
				//<resources mapping="/resources/**" location="/resources/" />
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
									//리소스 하위 자원으로 요청하면			실제 리소스의 하위중에 알아서 호출된다
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//<beans:property name="prefix" value="/WEB-INF/views/" />
		//<beans:property name="suffix" value=".jsp" />
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
