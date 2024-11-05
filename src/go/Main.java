package go;
import utils.*;

public class Main {
    public static void main(String[] args) {

        Tasks task1 = new Tasks("Task 1", "Description 1", true);
        Tasks task2 = new Tasks("Task 2", "Description 2", false);
        task1.addTask(task2);
        
        task1.updateTask("Task 1 Updated", "Description 1 Updated", false);
        
        System.out.println("Historique des versions de task1:");
        for (Tasks.TaskVersion version : task1.getHistory()) {
            System.out.println(version);
        }
        
        Tasks.TaskVersion previousVersion = task1.getPreviousVersion(0);
        if (previousVersion != null) {
            System.out.println("Version précédente de task1: " + previousVersion);
        }
        
        String removeResult = task1.removeTask(task2);
        System.out.println(removeResult);
        
        if (!task1.tasks.contains(task2)) {
            System.out.println("La tâche a été supprimée avec succès.");
        } else {
            System.out.println("La tâche n'a pas été supprimée.");
        }
    }
}