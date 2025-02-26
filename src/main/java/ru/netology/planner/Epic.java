package ru.netology.planner;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) { // перебираем все задачи
            if (subtask.contains(query)) {
                return true;
            }
        }
            return false;
        }
    }
