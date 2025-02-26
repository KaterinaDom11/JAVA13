package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldQuerySimpleTaskTrue() {
        Task task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = task.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQuerySimpleTaskFalse() {
        Task task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = task.matches("Набрать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryEpicTrue() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryEpicFalse() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Лук");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryMeetingTrue() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("3й");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQueryMeetingFalse() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("4й");
        Assertions.assertEquals(expected, actual);
    }
}