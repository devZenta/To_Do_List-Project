package go;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.*;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            List<Tasks> tasksList = new ArrayList<>();
            
            boolean running = true;
            while (running) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Ajouter une nouvelle tâche");
                System.out.println("2. Afficher toutes les tâches");
                System.out.println("3. Modifier une tâche existante");
                System.out.println("4. Supprimer une tâche");
                System.out.println("5. Quitter");
                System.out.print("Choisissez une option : ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Entrez le nom de la nouvelle tâche : ");
                        String name = scanner.nextLine();
                        System.out.print("Entrez la description de la tâche : ");
                        String description = scanner.nextLine();
                        System.out.print("Entrez l'état initial (true pour complétée, false pour non complétée) : ");
                        boolean state = scanner.nextBoolean();
                        scanner.nextLine();
                        
                        Tasks newTask = new Tasks(name, description, state);
                        tasksList.add(newTask);
                        System.out.println("Nouvelle tâche ajoutée avec succès.");
                    }
                        
                    case 2 -> {
                        if (tasksList.isEmpty()) {
                            System.out.println("Aucune tâche n'est disponible.");
                        } else {
                            System.out.println("Liste de toutes les tâches :");
                            for (int i = 0; i < tasksList.size(); i++) {
                                System.out.println("Tâche " + i + ": " + tasksList.get(i).getName() + " - " + tasksList.get(i).getDescription() + " - " + tasksList.get(i).getState());
                                List<Tasks.TaskVersion> history = tasksList.get(i).getHistory();
                                System.out.println("Historique des versions :");
                                for (int j = 0; j < history.size(); j++) {
                                    System.out.println("Version " + j + ": " + history.get(j));
                                }
                            }
                        }
                    }
                        
                    case 3 -> {
                        System.out.print("Entrez l'index de la tâche à modifier : ");
                        int taskIndex = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (taskIndex >= 0 && taskIndex < tasksList.size()) {
                            Tasks taskToUpdate = tasksList.get(taskIndex);
                            System.out.print("Entrez le nouveau nom de la tâche : ");
                            String newName = scanner.nextLine();
                            System.out.print("Entrez la nouvelle description de la tâche : ");
                            String newDescription = scanner.nextLine();
                            System.out.print("Entrez le nouvel état (true pour complétée, false pour non complétée) : ");
                            boolean newState = scanner.nextBoolean();
                            scanner.nextLine();
                            
                            taskToUpdate.updateTask(newName, newDescription, newState);
                            System.out.println("La tâche a été mise à jour.");
                        } else {
                            System.out.println("Index de tâche invalide.");
                        }
                    }
                        
                    case 4 -> {
                        System.out.print("Entrez l'index de la tâche à supprimer : ");
                        int taskToRemoveIndex = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (taskToRemoveIndex >= 0 && taskToRemoveIndex < tasksList.size()) {
                            tasksList.remove(taskToRemoveIndex);
                            System.out.println("Tâche supprimée avec succès.");
                        } else {
                            System.out.println("Index de tâche invalide.");
                        }
                    }
                        
                    case 5 -> {
                        running = false;
                        System.out.println("Au revoir !");
                    }
                        
                    default -> System.out.println("Option non valide. Veuillez réessayer.");
                }
            }
        }
    }
}