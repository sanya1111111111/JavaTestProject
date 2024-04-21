import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число");
        switch (input.nextInt()){
            case (1):
                System.out.println("Введите длину генерируемого пароля");
                System.out.println("Ваш пароль: "+ PasswordGenerator.generate(input.nextInt()));
                break;
            case (2):
                System.out.println("Введите путь к конвертируемому файлу");
                String inputFile = input.next();
                System.out.println("Введите путь к итоговому файлу");
                String outputFile = input.next();
                System.out.println("Введите формат для конвертации файла");
                String format = input.next();
                try {
                    fileConverter.convert(inputFile, outputFile, format);
                    System.out.println("Конвератция прошла успешно!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Ошибка ввода");
                break;
        }
    }

}