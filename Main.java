import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО по-русски: ");
        String fullName = scanner.nextLine();

        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        String birthDate = scanner.nextLine();

        User user = new User(fullName, birthDate);

        System.out.println("Инициалы: " + user.getInitials());
        System.out.println("Пол: " + user.getGender());
        System.out.println("Возраст: " + user.getAgeWithSuffix());
    }
}
