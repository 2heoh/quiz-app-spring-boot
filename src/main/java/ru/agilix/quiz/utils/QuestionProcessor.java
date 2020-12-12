package ru.agilix.quiz.utils;

import ru.agilix.quiz.domain.Question;

import java.util.List;

public interface QuestionProcessor {
    List<Question> parseQuestions();
}
