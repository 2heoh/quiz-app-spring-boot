package ru.agilix.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import ru.agilix.quiz.configs.AppConfig;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.ui.ConsoleUIService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleUIServiceTest {

    @Mock
    private IOService readerWriter;

    private ConsoleUIService consoleUIService;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        consoleUIService = new ConsoleUIService(readerWriter, messageSource, new AppConfig());
    }

    @Test
    void getUser() {
        given(readerWriter.getText()).willReturn("test");
        User user = consoleUIService.getUser();

        assertThat(user.getUsername()).isEqualTo("test test");
    }

    @Test
    void getLocalisedMessageByKey() {
        given(messageSource.getMessage(eq("test"), eq(null), any())).willReturn("some text");

        String localisedText = consoleUIService.getLocalisedMessageByKey("test");

        assertThat(localisedText).isEqualTo("some text");
    }


    @Test
    void displayQuestion() {
        List<Answer> answers = Collections.singletonList(new Answer(0, "a", true));

        given(messageSource.getMessage(eq("test"), eq(null), any())).willReturn("some text");
        given(messageSource.getMessage(eq("a"), eq(null), any())).willReturn("a");

        consoleUIService.displayQuestion(new Question(1, "test", answers));

        verify(readerWriter).displayText("\n1.) some text\n\t [A] a");
    }

    @Test
    void displayResultsFor() {
        consoleUIService.displayResultsFor(new User("test"));

        verify(readerWriter).displayText("Score for student test is: 0\n");
    }

    @Test
    void getAnswer() {
        given(readerWriter.getText()).willReturn("test");

        String answer = consoleUIService.getAnswer();

        assertThat(answer).isEqualTo("test");
    }
}