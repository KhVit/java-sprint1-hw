import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Добро пожаловать в Счетчик калорий!");

        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) { // 1 - Ввести количество шагов за определённый день
                System.out.println("Введите номер мясяца начиная с 0(Январь) до 11(Декабрь):");
                int month = scanner.nextInt();
                System.out.println("Введите день с 0(1-ый день) до 29(зо-ый день):");
                int day = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов:");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Количество шагов не может быть отрицательным. Попробуйте еще раз!");
                    System.out.println("Введите количество пройденных шагов:");
                    steps = scanner.nextInt();
                }
                stepTracker.saveSteps(month, day, steps);
                System.out.println("Данные сохранены!");
            }
                else if (userInput == 2) { // 2 - Напечатать статистику за определённый месяц
                System.out.println("За какой месяц показать статистику с 0(Январь) до 11(Декабрь)?");
                int month = scanner.nextInt();
                stepTracker.showStatistic(month);
            }
                else if (userInput == 3) { // 3 - Изменить цель по количеству шагов в день
                System.out.println("Введите новую цель: ");
                int steps = scanner.nextInt();
                stepTracker.newGoal(steps);
            }
                else if(userInput == 4){ // 4 - Выйти из приложения
                System.out.println("Программа завершена!");
                break;
            }
                else
                    System.out.println("Введена неверная команда!");
        }
    }

        private static void printMenu () {
            System.out.println("Введите команду, что вы хотите сделать? Список и номера доступных команд:");
            System.out.println("1 - Ввести количество шагов за определённый день");
            System.out.println("2 - Напечатать статистику за определённый месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("4 - Выйти из приложения");
        }
}

