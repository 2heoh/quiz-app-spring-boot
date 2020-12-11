package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVRecord;

public interface ResourceReader {
    Iterable<CSVRecord> getRecords();
}
