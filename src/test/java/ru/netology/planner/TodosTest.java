package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findSingleTask() {
        // Создаем задачи
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);

        Task[] expectedEpic = {epic};
        Task[] actualEpic = todos.search("Хлеб");
        Assertions.assertArrayEquals(expectedEpic, actualEpic);

        Task[] expectedMeeting = {meeting};
        Task[] actualMeeting = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expectedMeeting, actualMeeting);
    }
    @Test
    public void findMultipleIssues() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко после обеда");
        String[] subtasks = {"молоко", "яйца", "хлеб"};

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение молоко",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("молоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findZeroIssues() {
        // Создаем задачи
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко после обеда");
        String[] subtasks = {"молоко", "яйца", "хлеб"};

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение молоко",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("сметана");
        Assertions.assertArrayEquals(expected, actual);

    }
}
