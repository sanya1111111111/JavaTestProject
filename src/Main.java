import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Объект отвечающий за ввод данных
        System.out.println("Введите путь к конвертируемому файлу");
        String inputFile = input.next();//Строка отвечающая за путь получает значение из консоли
        System.out.println("Введите путь к итоговому файлу");
        String outputFile = input.next();//Строка отвечающая за  получает значение из консоли
        System.out.println("Введите формат для конвертации файла");
        String format = input.next();//Строка отвечающая за путь получает значение из консоли
        try {
            fileConverter.convert(inputFile, outputFile, format);
            System.out.println("Конвератция прошла успешно!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
