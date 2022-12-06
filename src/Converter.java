public class Converter {
    public double convertSteps(int sumSteps) { // Метод преобразует шаги в киллометры
        return sumSteps * 0.00075;
    }
    public double burntCalories (int sumSteps) { // Метод преобразует шаги в калории
        return sumSteps * 0.05;
    }
}
