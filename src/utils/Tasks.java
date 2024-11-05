package utils;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
    
    private String name;
    private String description; 
    private Boolean state;
    public List<Tasks> tasks;
    protected List<TaskVersion> history;

    public Tasks(String name, String description, Boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
        saveVersion();
    }

    private void saveVersion() {
        history.add(new TaskVersion(name, description, state));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getState() {
        return state;
    }

    public Boolean addTask(Tasks task) {
        tasks.add(task);
        System.out.println(name + " added, Description : " + description + ", State : " + state);
        return true;
    }

    public String removeTask(Tasks task) {
        if (tasks.remove(task)) {
            return "Task removed";
        } else {
            return "Task not found";
        }
    }

    public Boolean updateTask(String newName, String newDescription, Boolean newState) {
        this.name = newName;
        this.description = newDescription;
        this.state = newState;
        saveVersion();
        System.out.println("Task updated");
        return true;
    }

    public TaskVersion getPreviousVersion(int versionIndex) {
        if (versionIndex >= 0 && versionIndex < history.size()) {
            return history.get(versionIndex);
        } else {
            return null;
        }
    }

    public List<TaskVersion> getHistory() {
        return history;
    }

    public static class TaskVersion {
        protected String name;
        protected String description;
        protected Boolean state;

        public TaskVersion(String name, String description, Boolean state) {
            this.name = name;
            this.description = description;
            this.state = state;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Boolean getState() {
            return state;
        }

        @Override
        public String toString() {
            return "TaskVersion{name='" + name + "', description='" + description + "', state=" + state + '}';
        }
    }
}