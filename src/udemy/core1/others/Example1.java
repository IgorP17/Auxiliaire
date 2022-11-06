package udemy.core1.others;

public class Example1 {
    public static void main(String[] args) {
        resolve(Weather.CLOUDY);
        resolve(Weather.RAINY);
        resolve(Weather.SNOWY);

        // FINAL
        // 1. field - константа, необходимо проинициализировать или создать конструктор
        // 2. static final field - константа, название с больших букв FIELD_1
        // 3. метод - нельзя переопределять
        // 4. класс - нельзя наследоваться
    }

    private static void resolve(Weather weather) {
        switch (weather) {
            case RAINY:
                System.out.println(weather.getSValue() + " " + weather.getIValue());
                break;
            case CLOUDY:
                System.out.println(weather.getSValue() + ":" + weather.getIValue());
                break;
            default:
                System.out.println("DEFAULT " + weather.getSValue() + "-" + weather.getIValue());
        }
    }
}
