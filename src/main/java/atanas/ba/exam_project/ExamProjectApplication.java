package atanas.ba.exam_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExamProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamProjectApplication.class, args);
	}

}
