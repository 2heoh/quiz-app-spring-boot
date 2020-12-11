package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import ru.agilix.quiz.domain.Question;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.csv.CSVFormat.DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

class CSVProcessorTest {

    @Test
    void parseQuestions() {
        CsvProcessor processor = new CsvProcessor(new TestableReader("1,test,+a,b"));

        List<Question> questions = processor.parseQuestions();

        assertThat(questions.size()).isEqualTo(1);
    }

    private class TestableReader implements ResourceReader {
        private final String content;

        public TestableReader(String content) {
            this.content = content;
        }

        @Override
        public Iterable<CSVRecord> getRecords()  {
            try {
                return new CSVParser(new StringReader(content), DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
    }
}