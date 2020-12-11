package ru.agilix.quiz.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class LocalizationConfig {
    private static final Logger logger = LoggerFactory.getLogger(LocalizationConfig.class);
    @Bean
    public MessageSource messageSource() {
        var ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/questions.csv");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
