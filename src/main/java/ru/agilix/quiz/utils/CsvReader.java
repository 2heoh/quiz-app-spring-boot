package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.agilix.quiz.configs.AppConfig;

import java.io.*;

@Service
public class CsvReader implements ResourceReader {
    private final AppConfig config;

    public CsvReader(AppConfig config) {
        this.config = config;
    }

    @Override
    public Iterable<CSVRecord> getRecords() {
        Iterable<CSVRecord> records = null;
        try {
            FileInputStream stream = new FileInputStream(ResourceUtils.getFile("classpath:" + config.getFile()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            records = CSVFormat.RFC4180.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
