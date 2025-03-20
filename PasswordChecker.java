public class PasswordChecker {

    private int minLength = -1;
    private int maxRepeats = 0;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Введено \"" + minLength + "\". Длина пароля не может быть отрицательной.");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Введено \"" + maxRepeats + "\". Количество повторений символов не может быть отрицательным или нулевым.");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String pass) {
        if (minLength == -1 || maxRepeats == 0) {
            throw new IllegalStateException("Настройки чекера не были установлены");
        }

        int repeat = 1;
        boolean checkCounts = true;
        for (int i = 1; i < pass.length(); i++) {
            if (pass.charAt(i) == pass.charAt(i - 1)) {
                repeat++;
                if (repeat > maxRepeats) {
                    checkCounts = false;
                }
            } else {
                repeat = 1;
            }
        }

        return pass.length() >= minLength && checkCounts;
    }
}