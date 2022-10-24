import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int purpose = 10000;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        StepTracker.Converter converter = new StepTracker.Converter();
        while (true) {
            stepTracker.printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите номер месяца");
                int i = scanner.nextInt();
                System.out.println("Введите номер дня");
                int j = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                stepTracker.inputSteps(i, j, steps);
            }
            else if (command == 2) {
                System.out.println("Введите номер месяца, за который вы хотите просмотерть статистику.");
                int i = scanner.nextInt()-1;
                stepTracker.outputDaySteps(i);
                System.out.println("всего шагов за " + (i+1) + " месяц: " + stepTracker.foundSumSteps(i));
                stepTracker.foundMaxSteps(i);
                stepTracker.foundAverageSteps(i,stepTracker.foundSumSteps(i));
                stepTracker.foundBestStreak(i, stepTracker.daySteps, purpose);
                System.out.println("Пройденная дистанция за " + (i+1) + " месяц: " +
                        converter.foundDistance(stepTracker.foundSumSteps(i)) + " км");
                System.out.println("Сожжено кКал за " + (i+1) + " месяц: " +
                        converter.foundKcal(stepTracker.foundSumSteps(i)));
            } else if (command == 3) {
                System.out.println("Введите новую цель по количеству шагов в день");
                purpose = scanner.nextInt();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Неизвестная команда.");
            }
        }


    }
}
