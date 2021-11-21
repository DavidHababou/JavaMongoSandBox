package david.hababou.sandbox.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"david.hababou.sandbox.kafka","david.hababou.sandbox.mongo", "david.hababou.sandbox.controller"})
public class SandBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandBoxApplication.class, args);
	}
}