import java.util.Scanner;

public class StepTracker {
    int[][] daySteps = new int[12][30];
    Scanner scanner = new Scanner(System.in);


    StepTracker() {

    }

    public void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за день.");
        System.out.println("2. Напечатать статистику за месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("0. Выйти из приложения.");
    }

    public void inputSteps(int i, int j, int steps) {

            if (steps >= 0) {
                daySteps[i-1][j-1] = steps;
                System.out.println("Сохранено!");
            } else {
                System.out.println("Количество шагов не может быть отрицательным!");
        }
    }

    public void outputDaySteps(int i) {
        for (int j = 1; j < 30; j++) {
            System.out.print((j) + " день: " + daySteps[i][j - 1] + ", ");
        }
        System.out.println(30 + " день: " + daySteps[i][29]);
    }

    public int foundSumSteps(int i) {
        int sumSteps = 0;
        for (int j = 0; j < 30; j++) {
            sumSteps = sumSteps + daySteps[i][j];
        }
        return sumSteps;
    }

    public void foundMaxSteps(int i) {
        int maxSteps = 0;
        for (int j = 0; j < 30; j++) {
            if (daySteps[i][j] > maxSteps) {
                maxSteps = daySteps[i][j];
            }
        }
        System.out.println("Максимальное количество шагов за день в " + (i+1) + " месяце: " + maxSteps);
    }

    public void foundAverageSteps(int i, int sumSteps) {
        double averageSteps = (double) sumSteps/(30);
        System.out.println("Среднее количество шагов: "+ averageSteps);
    }
    public void foundBestStreak(int i, int[][] daySteps, int purpose) {
        int yesterdaySteps = 0;
        int streak = 1;
        int bestStreak = 0;
        for (int j=1; j<30; j++) {
            yesterdaySteps = daySteps[i][j-1];
            if ((daySteps[i][j]>=purpose) & (yesterdaySteps>=purpose)) {
                streak++;
                if (streak>bestStreak) {
                    bestStreak = streak;
                }
            } else {
                streak = 1;
            }
        }
        if (streak == 1) {
            streak = 0;
        }
        System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за " +
                "день было равно или выше целевого в " + (i+1) + " месяце: " +  bestStreak);
    }
    public static class Converter {

        public double foundDistance(int sumSteps) {
            double distance = (double) sumSteps*0.75/1000;
            return distance;
        }

        public double foundKcal(int sumSteps) {
            double kcal = (double) (sumSteps*50)/1000;
            return kcal;
        }
    }
}

