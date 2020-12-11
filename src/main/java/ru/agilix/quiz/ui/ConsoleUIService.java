package ru.agilix.quiz.ui;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.agilix.quiz.configs.AppConfig;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.service.IOService;

@Service
public class ConsoleUIService implements UIService {
    private final IOService readerWriter;
    private final MessageSource messageSource;
    private final AppConfig config;

    public ConsoleUIService(IOService readerWriter, MessageSource messageSource, AppConfig config) {
        this.readerWriter = readerWriter;
        this.messageSource = messageSource;
        this.config = config;
    }

    @Override
    public User getUser() {
        readerWriter.displayText(getLocalisedMessageByKey("enter.firstName") + ": ");
        String firstName = readerWriter.getText();

        readerWriter.displayText(getLocalisedMessageByKey("enter.lastName") + ": ");
        String lastName = readerWriter.getText();
        return new User(firstName + " " + lastName);
    }

    @Override
    public void displayQuestion(Question question) {

        String text = "\n" + question.getId() + ".) " + getLocalisedMessageByKey(question.getKey());

        for (Answer answer : question.getAnswers()) {
            text += "\n\t [" + answer.getId() + "] " + getLocalisedMessageByKey(answer.getText());
        }
        readerWriter.displayText(text);
    }

    public String getLocalisedMessageByKey(String key) {
        return messageSource.getMessage(key, null, config.getLocale());
    }

    @Override
    public void displayResultsFor(User user) {
        readerWriter.displayText("Score for student " + user.getUsername() + " is: " + user.getScore() + "\n");
    }

    @Override
    public String getAnswer() {
        readerWriter.displayText("\nType your answer: ");
        return readerWriter.getText();
    }
}
