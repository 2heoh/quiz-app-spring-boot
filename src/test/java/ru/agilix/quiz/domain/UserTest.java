package ru.agilix.quiz.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void scoreIsZeroByDefault() {
        User user = new User("test");

        assertEquals(0, user.getScore());
    }

    @Test
    void scoreCanBeUpdated() {
        User user = new User("test");

        user.updateScore(1);

        assertEquals(1, user.getScore());
    }
}