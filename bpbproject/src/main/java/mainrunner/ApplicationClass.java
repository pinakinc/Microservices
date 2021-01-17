package mainrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(scanBasePackages = "com.bpbproject")
	public class ApplicationClass {

		public static void main(String[] args) {
			SpringApplication.run(ApplicationClass.class, args);
		}
}
