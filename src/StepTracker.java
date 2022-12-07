import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int numberSteps = 10000; // цель по количеству шагов в день
    MonthData[] monthToData; // Объявил массив

    class MonthData{
        int[] stepsDay = new int[30]; // Массив со значениями шагов по дням
    }

     public StepTracker(){
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

       public void saveSteps(int month, int day, int steps) { // Метод ввода количества пройденных шагов за определенный день
         monthToData[month].stepsDay[day] = steps;
    }

    void showStatistic(int month) { // Метод печатает статистику за определённый месяц
        System.out.println("1. Количество пройденных шагов за месяц по дням: ");
        showStat(month);
        System.out.println();
        System.out.println("2. Общее количество шагов за месяц: " + sumSteps(month));
        System.out.println("3. Максимальное пройденное количество шагов в месяце: " + maxSteps(month));
        System.out.println("4. Среднее количество шагов за месяц: " + meanStep(month));
        System.out.println("5. Пройденная дистанция(в км) за месяц: " + distanceMonth(month));
        System.out.println("6. Количество сожжённых килокалорий: " + burnCal(month));
        System.out.println("7. Лучшая серия дней: " + bestSeries(month));
    }
    void showStat(int month) { //Метод выводит статистику шагов по дням
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month].stepsDay[i] + ", ");
        }
    }

    int sumSteps(int month) { // Метод возвращающий сумму шагов за месяц
        int sum = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            sum = sum + monthToData[month].stepsDay[i];
        }
        return sum;
    }

    int maxSteps(int month) { // Метод возвращает максимальное количество шагов в месяце
        int maxStep = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            if (monthToData[month].stepsDay[i] > maxStep) {
                maxStep = monthToData[month].stepsDay[i];
            }
        }
        return maxStep;
    }

    int meanStep(int month) { // Метод выводит среднее кол-во шагов за месяц
        int sum = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            sum = sum + monthToData[month].stepsDay[i];
        }
        return sum / 30;
    }

    double distanceMonth(int month) { // Метод выводит пройденную дистанцию(в км) за месяц
        int sum = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            sum = sum + monthToData[month].stepsDay[i];
        }
        double distance = converter.convertSteps(sum);
        return distance;
    }

    double burnCal(int month) { // Метод выводит количество сожжённых килокалорий
        int sum = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) {
            sum = sum + monthToData[month].stepsDay[i];
        }
        double burnKcal = converter.burntCalories(sum);
        return burnKcal;
    }

    int bestSeries(int month) { // Метод возвращает значение лучшей серии дней(максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.)
        int countDays = 0;
        int maxCountDays = 0;
        for (int i = 0; i < monthToData[month].stepsDay.length; i++) { // поправил алгоритм подсчета лучшей серии
            if (monthToData[month].stepsDay[i] >= numberSteps) {
                countDays = countDays + 1;

                if (maxCountDays < countDays) {
                    maxCountDays = countDays;
                }
            } else {
                countDays = 0;
            }
        }
        return maxCountDays;
    }

    void newGoal(int step) { // Метод меняет цель по количеству шагов в день
        if (step < 0) {
            System.out.println("Введите положительное значение!");
        } else {
            numberSteps = step;
            System.out.println("Значение изменено!");
        }
    }
}
