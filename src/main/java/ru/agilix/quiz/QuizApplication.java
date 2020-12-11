package ru.agilix.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.agilix.quiz.configs.AppConfig;
import ru.agilix.quiz.service.QuestionFileService;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class QuizApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuizApplication.class, args);
		QuestionFileService service = context.getBean(QuestionFileService.class);
		service.runQuiz();
	}

}
