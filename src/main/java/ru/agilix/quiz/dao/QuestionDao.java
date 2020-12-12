package ru.agilix.quiz.dao;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.List;

@Service
public class QuestionDao implements Questionable{
    private final QuestionProcessor questionProcessor;

    public QuestionDao(QuestionProcessor questionProcessor) {
        this.questionProcessor = questionProcessor;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionProcessor.parseQuestions();
    }
}
