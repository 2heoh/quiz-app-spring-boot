package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Component
public class CsvProcessor implements QuestionProcessor {
    private final ResourceReader resourceReader;

    public CsvProcessor(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }

    @Override
    public List<Question> parseQuestions() {
        List<Question> result = new ArrayList<>();
        for (CSVRecord record : resourceReader.getRecords()) {
            String id = record.get(0);
            String text = record.get(1);

            List<Answer> answers = new ArrayList<>();
            for (int i = 2; i < record.size(); i++) {

                String optionText = record.get(i);
                boolean isRight = false;
                if (optionText.startsWith("+")) {
                    optionText = optionText.substring(1);
                    isRight = true;
                }
                answers.add(new Answer(i - 2, optionText, isRight));
            }

            result.add(new Question(Integer.parseInt(id), text, answers));
        }
        return result;
    }

}
