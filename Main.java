import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final PasswordChecker passCheck = new PasswordChecker();

    public static void main(String[] args) {
        inputSetting();
        inputPass();
    }

    public static void inputSetting() {
        try {
            System.out.print("Введите мин. длину пароля: ");
            int lengthPass = sc.nextInt();
            passCheck.setMinLength(lengthPass);

            System.out.print("\nВведите макс. доступное количество повторений символа подряд: ");
            int countSymbol = sc.nextInt();
            passCheck.setMaxRepeats(countSymbol);

        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
            System.out.println("Программа завершена.");
            System.exit(0);
        }
    }

    public static void inputPass() {
        try {
            while (true) {
                System.out.print("\nВведите пароль или end: ");
                String pass = sc.next();
                if (pass.equals("end")) {
                    System.out.println("Программа завершена.");
                    break;
                }
                if (passCheck.verify(pass)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }
    }
}