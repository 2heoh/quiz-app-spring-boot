package ru.agilix.quiz.dao;

import org.junit.jupiter.api.Test;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionDaoTest {

    @Test
    void getAllQuestionsShouldReturnQuestionsFromCSV() {
        QuestionDao questionDao = new QuestionDao(new TestProcessor());

        List<Question> result = questionDao.getAllQuestions();

        assertThat(result.get(0))
                .matches(q -> q.getKey().equals("test"))
                .matches(q -> q.getId() == 1);
    }

    private class TestProcessor implements QuestionProcessor {


        @Override
        public List<Question> parseQuestions() {
            List<Answer> answers = Collections.singletonList(new Answer(1, "A", false));
            return Collections.singletonList(new Question(1, "test", answers));
        }
    }
}