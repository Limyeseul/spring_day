package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration	// 설정 파일
@ComponentScan	// 설정한 어노테이션 사용 가능?
public class Application {
	
	@Bean
	MessageService mockMessageService() {
		// 만들자 마자 바로 return 
		// 익명 클래스
		return new MessageService() {
			
			@Override
			public String getMessage() {
				return "helloWorld!!!";
			}
		};
	}
	
	
	public static void main(String[] args) {
		// 해당 클래스가 설정파일이기 때문에 자기 자신 클래스를 넣어준다.
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
	    printer.printMessage();
	}
}
