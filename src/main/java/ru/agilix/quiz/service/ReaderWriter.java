package ru.agilix.quiz.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ReaderWriter implements IOService {
    public void displayText(String text) {
        System.out.println(text);
    }

    @Override
    public String getText() {
        return new Scanner(System.in).next();
    }
}
