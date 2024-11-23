import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class User {
    private String fullName;
    private LocalDate birthDate;

    public User(String fullName, String birthDate) {
        this.fullName = fullName;
        this.birthDate = parseBirthDate(birthDate);
    }

    private LocalDate parseBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d[./]M[./]yyyy");
        return LocalDate.parse(birthDate, formatter);
    }

    public String getInitials() {
        String[] parts = fullName.split("\\s+");
        if (parts.length != 3) return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
        return String.format("%s %s.%s.", parts[0], parts[1].charAt(0), parts[2].charAt(0));
    }

    public String getGender() {
        String[] parts = fullName.split("\\s+");
        if (parts.length != 3) return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
        
        String patronymic = parts[2];
        if (patronymic.endsWith("ич")) return "Мужской";
        if (patronymic.endsWith("на")) return "Женский";
        return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
    }

    public String getAgeWithSuffix() {
        int age = calculateAge();
        if (age % 10 == 1 && age % 100 != 11) return age + " год";
        if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) return age + " года";
        return age + " лет";
    }

    private int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
