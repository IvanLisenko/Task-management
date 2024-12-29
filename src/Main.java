import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отметить задачу как выполненную");
            System.out.println("4. Показать все задачи");
            System.out.println("5. Сохранить задачи в файл");
            System.out.println("6. Загрузить задачи из файла");
            System.out.println("0. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите описание задачи:");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    break;
                case 2:
                    System.out.println("Введите ID задачи для удаления:");
                    int idToDelete = scanner.nextInt();
                    manager.deleteTask(idToDelete);
                    break;
                case 3:
                    System.out.println("Введите ID задачи для отметки как выполненной:");
                    int idToComplete = scanner.nextInt();
                    manager.markTastAsCompleted(idToComplete);
                    break;
                case 4:
                    manager.showAllTasks();
                    break;
                case 5:
                    try {
                        manager.saveToFile("tasks.txt");
                        System.out.println("Задачи сохранены в файл");
                    } catch (IOException e){
                        System.out.println("Ошибка при сохранении файла");
                    }
                    break;
                case 6:
                    try {
                        manager.loadFromFile("tasks.txt");
                        System.out.println("Задачи загружены из файла");
                    } catch (IOException e) {
                        System.out.println("Ошибка при загрузке файла");
                    }
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}