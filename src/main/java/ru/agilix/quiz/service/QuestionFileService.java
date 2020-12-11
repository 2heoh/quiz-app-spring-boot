package ru.agilix.quiz.service;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.dao.Questionable;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.ui.UIService;

@Service
public class QuestionFileService implements QuestionService {
    private Questionable dao;
    private UIService uiService;

    public QuestionFileService(Questionable dao, UIService uiService) {
        this.dao = dao;
        this.uiService = uiService;
    }

    @Override
    public void runQuiz() {
        User user = uiService.getUser();
        for (Question question : dao.getAllQuestions()) {
            uiService.displayQuestion(question);
            user.updateScore(question.scoreAnswer(uiService.getAnswer()));
        }
        uiService.displayResultsFor(user);
    }
}
