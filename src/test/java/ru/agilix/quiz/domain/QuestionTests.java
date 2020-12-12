package ru.agilix.quiz.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTests {

    @Test
    void getScoreForWrongAnswer() {
        List<Answer> answers = Collections.singletonList(new Answer(0, "A", false));
        Question questionWithWrongAnswerOnly = new Question(0, "question", answers);

        int score = questionWithWrongAnswerOnly.scoreAnswer("A");

        assertThat(score).isEqualTo(0);
    }

    @Test
    void getScoreForCorrectAnswer() {
        List<Answer> answers = Collections.singletonList(new Answer(0, "A", true));
        Question questionWithRightAnswerOnly = new Question(1, "question", answers);

        int score = questionWithRightAnswerOnly.scoreAnswer("A");

        assertThat(score).isEqualTo(1);
    }

    @Test
    void answerShouldBeCaseInsensitive() {
        List<Answer> answers = Collections.singletonList(new Answer(0, "A", true));
        Question questionWithRightAnswerOnly = new Question(1, "question", answers);

        int score = questionWithRightAnswerOnly.scoreAnswer("a");

        assertThat(score).isEqualTo(1);
    }
}
