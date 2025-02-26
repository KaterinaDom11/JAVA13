package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldQuery() {
        // Создаем задачи
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        // Создаем объект Todos и добавляем задачи
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Выполняем поиск
        Task[] expected = { simpleTask, meeting }; // Ожидаем, что найдутся только эти задачи
        Task[] actual = todos.search("родителям"); // Ищем по запросу "родителям"

        // Проверяем результат
        Assertions.assertArrayEquals(expected, actual);

        // Проверим еще один запрос
        Task[] expectedEpic = { epic }; // Ожидаем, что найдется только эпик
        Task[] actualEpic = todos.search("Хлеб"); // Ищем по запросу "Хлеб"
        Assertions.assertArrayEquals(expectedEpic, actualEpic);

        // Проверим еще один запрос
        Task[] expectedMeeting = { meeting }; // Ожидаем, что найдется только встреча
        Task[] actualMeeting = todos.search("НетоБанка"); // Ищем по запросу "НетоБанка"
        Assertions.assertArrayEquals(expectedMeeting, actualMeeting);
    }
}
